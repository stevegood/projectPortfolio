package org.stevegood

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class GithubService {

	static String HOST = 'https://api.github.com'

    def getUser(String username) {
    	new JsonSlurper().parseText(new URL("$HOST/users/$username").text)
    }

    def getReposForUser(String username) {
        new JsonSlurper().parseText(new URL("$HOST/users/${username}/repos?type=all&sort=name").text)
    }
}
