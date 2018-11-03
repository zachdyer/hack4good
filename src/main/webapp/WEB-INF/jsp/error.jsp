<%--@elvariable id="message" type="java.lang.String"--%>
<%--@elvariable id="code" type="java.lang.String"--%>
<%--@elvariable id="puppyId" type="java.lang.Integer"--%>
<%@include file="/WEB-INF/layouts/include.jsp" %>

<div class="text-center">
	<h1>${code}</h1>
	<h2>${message}</h2>
	<p>Sorry about that.</p>
	<img src="<c:url value="/resources/img/puppies/${puppyId}.jpg" />" id="puppy" alt="Sad puppy" class="img-fluid rounded">
</div>
