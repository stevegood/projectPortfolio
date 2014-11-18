class UrlMappings {

	static mappings = {
        "/"(controller: 'project', action: 'stats')
        "/search"(controller: 'project', action: 'search')
        "/$id"(controller: 'project', action: 'show')
        "/$id/refresh"(controller: 'project', action: 'refreshUser')
        "500"(view:'/error')
	}
}
