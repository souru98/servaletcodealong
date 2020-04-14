<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code Wall</title>
<link type="text/css" rel="stylesheet" href="./css/blog.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.main.css">

</head>
<body>
<nav>
<img src="../assets/logo.svg" alt="logo"/>
<ul>
<li><a href="${PageContext.request.contextPath}/myblogs">My Blogs</a></li>
<li><a href="${PageContext.request.contextPath}/allblogs">All Blogs</a></li>
<li><a href="${PageContext.request.contextPath}/login">Login</a></li>
<li><a href="${PageContext.request.contextPath}/signup">Sign Up</a></li>
</ul>
</nav>
<div class="body-div1">
<div>Your Blog's Posts</div>
<a href="new"><button class="button" id="addBlog"><i class="fas fa-plus-circle"></i>Add New Post</button></a>
</div>


<div class="body-div2">

<c:forEach var="blog" items="${listBlog}">
 <div class="article-card">
   <img src="./assets/java card image.svg" alt="">
     <div class="card-text">
      <h1 id="blog-title"><c:out value="${blog.getBlogTitle()}" /></h1>
      <p id="blog-description"><c:out value="${blog.getBlogDescription()}" /></p>
      <p>Posted on <b><c:out value="${blog.getPostedOn()}" /></b></p>
  </div>
    
    <div class="card-buttons">
       <a href="edit?id=<c:out value='${blog.getBlogId() }' />"><button type="button" id="edit">Edit</button></a>
       <a href="delete?id=<c:out value='${blog.getBlogId() }' />"><button type="button" id="delete">Delete</button></a>
    </div>
 </div>
 
</c:forEach>
</div>

<div class="body-div3">
<h1>${message }</h1>
</div>


</body>
</html>