<%@include file="/WEB-INF/layouts/include.jsp" %>

<c:set value='${requestScope.get("javax.servlet.forward.servlet_path")}' var="page" />

<nav class="navbar navbar-expand-md navbar-dark bg-dark margin-bottom-5">
	<a class="navbar-brand" href="<c:url value="/" />">
		<img src="<c:url value="/resources/img/logo.png"/>" height="30" width="30" class="d-inline-block align-top" alt="Logo">
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbar">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link ${page eq "/" ? "active" : ""}" href="<c:url value="/" />">Home</a>
			</li>
		</ul>
	</div>
</nav>