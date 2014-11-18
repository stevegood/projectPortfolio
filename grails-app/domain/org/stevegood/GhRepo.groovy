package org.stevegood

/**
 * @author <a href="http://stevegood.org">Steve Good</a>
 * @since 11/17/14.
 */
class GhRepo {
    Date dateCreated
    Date lastUpdated

    long githubid
    String name
    String description
    String html_url
    long size
    boolean visible = true

    static belongsTo = [owner:GhUser]

    static constraints = {
        name blank: false
        description nullable: true, blank: true
        html_url blank: false, url: true
    }

    static mapping = {
        description type: 'text'
        sort 'name'
    }
}
