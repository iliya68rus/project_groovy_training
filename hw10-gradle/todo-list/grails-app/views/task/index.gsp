<!DOCTYPE html>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1>
    <ul>
        <g:each in="${todos}">
            <li>
                ${it.title} - ${it.description} - ${it.completed ? 'Completed' : 'Not Completed'}<br>
                Start Date: ${it.startDate}<br>
                End Date: ${it.endDate}
            </li>
        </g:each>
    </ul>
    <a href="${createLink(controller: 'todo', action: 'create')}">Create New Todo</a>
</body>
</html>
