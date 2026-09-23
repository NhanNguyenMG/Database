<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Murach's Java SQL Gateway Servlet</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
<h1>The SQL Gateway</h1>
<p>Enter the SQL statement and click the Execute button</p>

<form action = "sqlGateway" method="post">
    <p><b>SQL statement:</b></p>
    <textarea name="sqlStatement" rows="8" cols="80">${sqlStatement}</textarea><br>
    <button type="submit">Execute</button>

</form>

<p><b>SQL result:</b></p>
<div>
    ${sqlResult}
</div>
</body>
</html>