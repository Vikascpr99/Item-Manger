This is a backend application with the help of spring boot.
This is very basic application we can use it to make chit-sheet which we can use for daily life. 

Here is how to use the application:-
For Creating new Items
Method :- Post
Api :- http://localhost:9090/api/items
**Request Body**

{
    "title" : "Book",
    "description" : "Spring Boot and Micro-services"
}


![image](https://github.com/user-attachments/assets/4aec17d5-b08f-4c2c-b1f9-a20cc7307b62)

* For Search item by it's title
* Api :- http://localhost:9090/api/search-items-by-title?title=Book
* Method :- GET

  ![image](https://github.com/user-attachments/assets/1bcf1ee8-e717-436c-9a7b-2bbc70767bcb)




