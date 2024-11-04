<!DOCTYPE html>
<html>
<head>
    <title>Create Todo</title>
</head>
<body>
    <h1>Create Todo</h1>
    <g:form action="save" method="POST">
        <label for="title">Title:</label>
        <input type="text" name="title" required>
        <br>
        <label for="description">Description:</label>
        <input type="text" name="description">
        <br>
        <label for="startDate">Start Date:</label>
        <input type="date" name="startDate">
        <br>
        <label for="endDate">End Date:</label>
        <input type="date" name="endDate">
        <br>
        <input type="submit" value="Create">
    </g:form>
</body>
</html>
