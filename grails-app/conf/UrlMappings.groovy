class UrlMappings {

	static mappings = {
        "/"(controller: 'project', action: 'stats')
        "/search"(controller: 'project', action: 'search')
        "/$id"(controller: 'project', action: 'show')
        "500"(view:'/error')
	}
}
