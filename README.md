# User API - Tomcat + Jersey + Postman

This application implements a REST architecture based on web standards and using the HTTP protocol. The following four HTTP methods are implemented: GET, PUT, DELETE, POST. Used Jersey Framework to build RESTful web services.

### Tech

* Tomcat;
* Jersey;
* Postman:
* JSON.

### Task

Create an API to work with the User class (int id, String name, int age). Implement REST methods (GET, PUT, DELETE, POST). Each method must return a return code and response in JSON format with an enumeration of the result. For example, if the DELETE request was successful, then the return code will be 200 and the corresponding message, and if there was an attempt to delete the user who does not exist, then return the code 400 and the corresponding text.

### Functions

* **POST:** create a new user. Send to the server in x-www-form-urlencoded format. The server should return JSON with the created user;
* **PUT:** change user by id;
* **DELETE:** delete user by name;
* **GET:** get user by id;
* **GET:** get all users.

### Result

**1.** Adding a new user to the list:

[gif](https://github.com/bbogdasha/jerseyTomcat/blob/master/gif/add.gif)

---

**2.** Displaying all users per request **http://localhost:8081/TomcatProject/**. 
Result:

[screenshot](https://github.com/bbogdasha/jerseyTomcat/blob/master/gif/Screenshot_1.jpg)

---

**3.** Display user by a specific id **http://localhost:8081/TomcatProject/3**:

[screenshot](https://github.com/bbogdasha/jerseyTomcat/blob/master/gif/Screenshot_2.jpg)

and **http://localhost:8081/TomcatProject/1**:

[screenshot](https://github.com/bbogdasha/jerseyTomcat/blob/master/gif/Screenshot_3.jpg)

---

**4.** Delete user by name:

[gif](https://github.com/bbogdasha/jerseyTomcat/blob/master/gif/delete.gif)

---

**5.** Update user by id:

[gif](https://github.com/bbogdasha/jerseyTomcat/blob/master/gif/update.gif)
