package org.stevegood

class GhUser {

    Date dateCreated
    Date lastUpdated

	String username
    String email
    String name
    String html_url
    String avatar_url
    String location
    String blog
    String company
    String bio

    static hasMany = [repos:GhRepo]

    static constraints = {
        email nullable: true, blank: false, email: true
        name nullable: true, blank: false
        html_url blank: false, url: true
        avatar_url nullable: true, blank: false, url: true
        location nullable: true, blank: false
        blog nullable: true, blank: true, url: true
        company nullable: true, blank: true
        bio nullable: true, blank: true
    }

    static mapping = {
    	id generator: 'assigned', name: 'username', type: 'string'
        bio type: 'text'
    }
}
