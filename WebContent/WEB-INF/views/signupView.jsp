<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code Wall</title>
<link type="text/css" rel="stylesheet" href="./css/style.css">
</head>
<body>
<nav>
<img src="../assets/logo.svg" alt="logo" >
<ul>
<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
<li><a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
</ul>
</nav>
<div class="welcome-back">LEARN. CODE. REPEAT.</div>
<div class ="sub-text">share something new that you have learn today with the code wall community.</div>
<img class="login-illustration" src="../assets/illustration on sign up page.svg" alt="image">
<div class="signup-form">
<div class="title">Sign Up</div>
<form action="${pageContext.request.contextPath}/signup" method="post">
<label class="label" for="email">Email</label>
<input type="text" name="email" id="email">
<label class="label" for="password">Password</label>
<input type="text" name="password" id="password">
<div class="password-hint">Must consist of atleast 8 characters,a symbol,an uppercase,a lowercase letter</div>
<label class="label" for="password">Confirm Password</label>
<input type="text" name="Confirm Password" id="password">
${message}
<button class="button" type="submit">Sign In</button>
</form>
</div>


</body>
</html>