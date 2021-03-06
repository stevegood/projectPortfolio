package org.stevegood

import grails.transaction.Transactional
import groovy.json.JsonSlurper

/**
 * @author <a href="http://stevegood.org">Steve Good</a>
 * @since 11/17/14.
 */
@Transactional
class GhUserService {

    def githubService

    GhUser importFromGithub(String username) {
        def data
        try {
            data = githubService.getUser(username)
        } catch(e) {
            if (e instanceof FileNotFoundException) {
                log.info "No github user found for username: $username"
            }
        }
        if (!data) return
        GhUser user = GhUser.findOrCreateByUsername(username)
        user.properties = data
        importReposForUser(user)
        user.save()
    }

    void importReposForUser(GhUser user) {
        def repos = []
        try {
            repos = githubService.getReposForUser(user.username)
        } catch(e) {
            if (e instanceof FileNotFoundException) {
                log.info "No github user found for username: $user.username"
            }
        }

        def incomingIds = []
        repos?.each { _repo ->
            incomingIds << (_repo.id as long)
            if (!_repo.fork && !_repo.private) {
                def repo = GhRepo.findOrCreateByGithubid(_repo.id as long)
                _repo.remove('owner')
                _repo.remove('id')
                repo.properties = _repo
                user.addToRepos(repo)
            }
        }

        def savedIds = user.repos*.githubid
        if (savedIds?.size()) {
            def reposToRemove = savedIds - incomingIds
            if (reposToRemove.size()) GhRepo.findAllByGithubidInList(reposToRemove)*.delete()
        }
    }

}
