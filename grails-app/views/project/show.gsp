<%--
  User: steve
  Date: 11/17/14
  Time: 9:17 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${user.username}</title>
    <meta name="layout" content="main" />
</head>

<body>

<div class="container">
    <div class="page-header">
        <h1>
            ${user.name ?: user.username}<br/>
        </h1>
    </div>
    
    <div class="row">
        <div class="col-sm-4">
            <img src="${user.avatar_url}" alt="${user.username}" title="@${user.username}"
                 class="img-responsive img-thumbnail"/>
            <div id="user-info">
                <div class="list-group">
                    <a href="https://github.com/${user.username}" target="_blank" class="list-group-item">
                        <i class="fa fa-github fa-lg"></i>
                        ${user.username}
                    </a>

                    <g:if test="${user.company}">
                        <div class="list-group-item">
                            <i class="glyphicon glyphicon-briefcase"></i>
                            ${user.company}
                        </div>
                    </g:if>

                    <g:if test="${user.location}">
                        <div class="list-group-item">
                            <i class="glyphicon glyphicon-map-marker"></i>
                            ${user.location}
                        </div>
                    </g:if>

                    <g:if test="${user.blog}">
                        <a target="_blank" href="${user.blog}" class="list-group-item">
                            <i class="glyphicon glyphicon-link"></i>
                            ${user.blog}
                        </a>
                    </g:if>

                    <g:if test="${user.email}">
                        <a href="mailto:${user.email}" class="list-group-item" >
                            <i class="glyphicon glyphicon-envelope"></i>
                            ${user.email}
                        </a>
                    </g:if>
                </div>

                <g:if test="${user.bio}">
                    <p>${user.bio}</p>
                </g:if>

            </div>
        </div>

        <div class="col-sm-8">
            <div class="list-group">
                <g:each in="${user.repos.findAll{ it.visible }.sort { it.name }}" var="repo">
                    <a href="${repo.html_url}" target="_blank" class="list-group-item">
                        <span class="badge">${repo.size}</span>
                        <h4 class="list-group-item-heading">
                            ${repo.name}
                        </h4>
                        <div class="list-group-item-text">${repo.description}</div>
                    </a>
                </g:each>
            </div>
        </div>
    </div>
</div>

</body>
</html>
