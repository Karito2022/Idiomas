<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Show</title>
</head>
<body>
	<div class="container" style="max-width: 800px;">
		<div class="row mt-5">
			<div class="col-12">
				<a href="/languages" class="btn btn-primary mb-3">Dashboard</a>  	
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-12">
				<h2 class="mb-3"><c:out value="${ idioma.name }"/></h2>
				<h4 class="mb-3"><c:out value="${ idioma.creator }"/></h4>
				<h4 class="mb-3"><c:out value="${ idioma.version }"/></h4>
				<a href="/languages/edit/${ idioma.id }" class="btn btn-primary mb-3">Edit</a>
				<a href="/languages/delete/${ idioma.id }" class="btn btn-primary mb-3">Delete</a>  	
			</div>
		</div>
	</div>
</body>
</html>