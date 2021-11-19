# student-management-system
#Lab1
Java20/komplex javaprogrammering

 Deltagare :
 
. Samir Alsalhani

. Biniam Haile

 1. POST :  localhost:8080/student-management-system/api/v1/students
 
           
	     {        "firstName" : "John",
	              "lastName" : "kalle",
	              "email" : "test@test.com",
	              "phoneNumber" : "0790234525"
	            }


2. GET : localhost:8080/student-management-system/api/v1/students

3. GET : localhost:8080/student-management-system/api/v1/students/{id} 
            
4. DELETE : localhost:8080/student-management-system/api/v1/students/{id}

5. PUT : localhost:8080/student-management-system/api/v1/students/{id}
         
             {        "firstName" : "John",
	              "lastName" : "kalle",
	              "email" : "test@test.com",
	              "phoneNumber" : "0790234525"
	            }

6. GET : localhost:8080/student-management-system/api/v1/students/getbylastname

           QueryParam:
          name: lastName     value: "kalle"


Arbetsmetod : Vi jobbade agilt med remote pair programming och turades om att göra commits till Github. Vi hade var och en sin egen branch som vi uppdaterade efter varje commit. När vi slutförde labben mergade vi till main branchen på remote repository.




