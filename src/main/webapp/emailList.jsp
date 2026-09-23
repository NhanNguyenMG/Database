<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Murach's Java Servlet</title>
    <link rel="stylesheet" href="styles/style.css">
  </head>
  <body>

  <h1>Join our email list</h1>

  <p>To join our email list, enter your name and email address below.</p>
  <p>${message}</p>

  <form action="emailList" method="post">
    <label>Email:</label>
    <input type="email" name="email" value="${user.email}"><br>
    <label>First Name:</label>
    <input type="text" name="firstName" value="${user.firstName}"><br>
    <label>Last Name:</label>
    <input type="text" name="lastName" value="${user.lastName}"><br>
    <button type="submit">Join Now</button><br>
  </form>
  
  </body>
</html>
