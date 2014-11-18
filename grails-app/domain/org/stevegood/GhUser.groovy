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

    String getBlog() {
        return blog
    }

    void setBlog(String blog) {
        this.blog = prepURL blog
    }

    String getAvatar_url() {
        return avatar_url
    }

    void setAvatar_url(String avatar_url) {
        this.avatar_url = prepURL avatar_url
    }

    String getHtml_url() {
        return html_url
    }

    void setHtml_url(String html_url) {
        this.html_url = prepURL html_url
    }

    protected String prepURL(String url) {
        if (!url.toLowerCase().startsWith('http'))
            url = "http://$url"
        url
    }
}
