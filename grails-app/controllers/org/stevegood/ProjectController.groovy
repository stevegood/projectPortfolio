package org.stevegood

import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProjectController {

	def ghUserService

    def index() {
    	redirect uri: '/'
    	return
    }

	def stats() {
		def users = GhUser.count()
		def repos = GhRepo.count()
		[users: users, repos: repos]
	}

    def search() {
    	def users = GhUser.findAllByUsernameLike("%${params.q.trim()}%")

		if (users.size() == 1) {
    		redirect action: 'show', id: users[0].username
    		return
    	}

		if (!users.size()) {
			def user = ghUserService.importFromGithub(params.q.trim())
			if (user) {
				redirect action: 'show', id: user.username
				return
			} else {
				flash.message = "Unable to import a user by the name [${params.q.trim()}]. Please check the name and try your search again."
				flash.type = 'danger'
			}
		}

    	[users: users]
    }

    def show(GhUser user) {
		if (!params.id) {
			flash.message = 'No user by that name found. Please try searching again!'
			flash.type = 'danger'
			redirect uri: '/'
			return
		}

		if (!user) {
			user = ghUserService.importFromGithub(params.id)
		}

		if (!user) {
			flash.message = "Unable to import a user by the name ${params.id}. Please check the name and try your search again."
			flash.type = 'danger'
			redirect uri: '/'
			return
		}

    	[user: user]
    }

	def refreshUser(GhUser user) {
		user = ghUserService.importFromGithub(user?.username ?: params.id)

		flash.message = "Refreshed data for ${user.username}"
		flash.type = 'success'

		redirect action: 'show', id: user.username
	}
}
