<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit</title>
</head>
<body>
	<div class="container" style="max-width: 800px;">
		<div class="row mt-5">
			<div class="col-12">
				<a class="btn btn-primary m-3" href="/languages">Dashboard</a>
				<a href="/languages/delete/${ idioma.id }" class="btn btn-primary">Delete</a>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-12">
				<c:if test = "${error_todos != null }">
			    	<h4 class="text-danger mt-3 mb-3"><c:out value="${ error_todos }"/></h4>
			    </c:if>
				<form action="/languages/create" method="POST">
				  <input type="hidden" value="${idioma.id}" name="id"/>
				  <div class="form-group row mb-3">
				    <label for="nameid" class="col-sm-2 col-form-label">Name</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="nameid" name="name" value="${idioma.name}">
				    </div>
				    <c:if test = "${error_nombre != null }">
				    	<p class="text-danger mt-3 mb-3"><c:out value="${ error_nombre }"/></p>
				    </c:if>
				  </div>
				  <div class="form-group row mb-3">
				    <label for="creatorid" class="col-sm-2 col-form-label">Creator</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="creatorid" name="creator" value="${idioma.creator}">
				    </div>
				    <c:if test = "${error_creador != null }">
				    	<p class="text-danger mt-3 mb-3"><c:out value="${ error_creador }"></c:out></p>
				    </c:if>
				  </div>
				  <div class="form-group row mb-3">
				    <label for="versionid" class="col-sm-2 col-form-label">Version</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="versionid" name="version" value="${idioma.version}">
				    </div>
				  </div>
				  <div class="clearfix">
				  	<button type="submit" class="btn btn-primary float-right">Submit</button>
				  </div> 
				</form>
			</div>
		</div>
	</div>
</body>
</html>