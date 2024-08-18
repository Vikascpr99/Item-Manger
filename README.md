This is a backend application with the help of spring boot.
* This is very basic application we can use it to make chit-sheet which we can use for daily life.
* Here is how to use the application:-
* For Creating new Items
* Method :- Post
* Api :- http://localhost:9090/api/items
* **Request Body**
* {
    "title" : "Book",
    "description" : "Spring Boot and Micro-services"
}

![image](https://github.com/user-attachments/assets/4aec17d5-b08f-4c2c-b1f9-a20cc7307b62) 

----------------------------------------------------------------------------------------------------------------------------------------------------
* For Search item by it's title
* Api :- http://localhost:9090/api/search-items-by-title?title=Book
* Method :- GET

  ![image](https://github.com/user-attachments/assets/1bcf1ee8-e717-436c-9a7b-2bbc70767bcb)
---------------------------------------------------------------------------------------------------------------------------------------------------------
* For Get All items
* Api :- http://localhost:9090/api/items
* Method :- GET
* ![image](https://github.com/user-attachments/assets/c2296c3b-bfe4-40ea-9df8-d1f5c2099499)
* **Response **
* [
    {
        "_id": 302,
        "title": "Java",
        "description": "Learn DSA with Java",
        "createdAt": "2024-06-10T08:59:25.525827",
        "updatedAt": "2024-06-15T16:19:27.115539"
    },
    {
        "_id": 303,
        "title": "C++",
        "description": "Learn DSA with C++",
        "createdAt": "2024-06-10T08:59:43.605476",
        "updatedAt": "2024-06-10T08:59:43.605476"
    },
    {
        "_id": 304,
        "title": "Pyhton",
        "description": "Learn DSA with phyton",
        "createdAt": "2024-06-10T09:00:04.427746",
        "updatedAt": "2024-06-10T09:00:04.427746"
    },
    {
        "_id": 1902,
        "title": "DSA",
        "description": "DSA need to learn through any programming code",
        "createdAt": "2024-06-15T15:03:07.611576",
        "updatedAt": "2024-06-15T15:03:07.611576"
    },
    {
        "_id": 1952,
        "title": "Saturday Gurantee Delivery",
        "description": "1. This is the feature where we can enable the config to deliver a package on Saturday.",
        "createdAt": "2024-08-17T22:37:30.16387",
        "updatedAt": "2024-08-17T22:37:30.16387"
    },
    {
        "_id": 2002,
        "title": "Book",
        "description": "Spring Boot and Micro-services",
        "createdAt": "2024-08-18T09:24:09.715858",
        "updatedAt": "2024-08-18T09:24:09.715858"
    }

]
-------------------------------------------------------------------------------------------------------------------------------------------
* For Getting Item by itemId
* Api :- http://localhost:9090/api/items/302
* Method :- GET
* ![image](https://github.com/user-attachments/assets/c8c81bc2-c004-4fcc-b97d-993c21d50691)
* {
    "_id": 302,
    "title": "Java",
    "description": "Learn DSA with Java",
    "createdAt": "2024-06-10T08:59:25.525827",
    "updatedAt": "2024-06-15T16:19:27.115539"

}
-----------------------------------------------------------------------------------------------------------------------------------------
* For Updating Item by new information
* request body
* {
    "title" : "Updated Title",
    "description" : "Updated Description"
}
* Api :- http://localhost:9090/api/items/302
* Mehtod :- PUT
* ![image](https://github.com/user-attachments/assets/97525952-cb5b-4150-9a9b-abb3391ff34d)
-------------------------------------------------------------------------------------------------------------------------------
* For Delete of Item by ItemId
* Api :- http://localhost:9090/api/items?id=302
* Method :- DELETE
* ![image](https://github.com/user-attachments/assets/fee44c3a-2261-46f2-8882-a0500b48f591)








