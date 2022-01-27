# SpringBootRestFullApp
miniRESTfull

Requests from Postman:

http://localhost:8090/users/registration
body: 
{
    "username":"Lev",
    "password":"2222"
}

http://localhost:8090/users/get_user?id=1

http://localhost:8090/users/delete_user/2

http://localhost:8090/todo/create_todo?userId=1
body:
{
    "title":"TODO TITLE2",
    "completed":false,
    "description": "some description"
}

http://localhost:8090/todo/update_todo?id=2

http://localhost:8090/todo/get_todo?id=6

SWAGGER:  http://localhost:8090/swagger-ui.html
