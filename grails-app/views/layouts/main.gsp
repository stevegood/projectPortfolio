<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<g:link class="navbar-brand" uri="/">
						Project Portfolio
					</g:link>
					<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>

				<div id="navbar-main" class="navbar-collapse collapse">
					<g:form controller="project" action="search" method="GET" class="navbar-form navbar-right" role="search">
						<div class="input-group">
							<input name="q" type="text" placeholder="Search" class="form-control" value="${params?.q}">
							<span class="input-group-btn">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
					</g:form>
				</div>
			</div>
		</div>

		<g:if test="${flash.message}">
			<div class="container">
				<div class="alert alert-${flash.type ?: 'info'}">
					${flash.message}
				</div>
			</div>
		</g:if>

		<g:layoutBody/>
	</body>
</html>
