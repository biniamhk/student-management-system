# student-management-system
#Lab2
Java20/komplex javaprogrammering

Deltagare :
.Samir Alsalhani

.Biniam Haile


Endpoints for Subject-Entity

1. POST :  localhost:8080/student-management-system/api/v1/subjects
 
     {"subject":"Java"}

2.GET : localhost:8080/student-management-system/api/v1/subjects/{id}

3.Enrolling a student to a subject:
     
     POST: localhost:8080/student-management-system/api/v1/subjects/subjectId/{subjectId}/studentId/{studId}

4.Adding a teacher to a subject:
    
    POST: localhost:8080/student-management-system/api/v1/subjects/subjectId/{subjectId}/teacherId/{teacherId}

5.Getting complete information about a subject(students enrolled and assigned teacher):
     
     GET : localhost:8080/student-management-system/api/v1/subjects/getbysubject

              QueryParam: 
              
              name:subject             value:Java

Endpoints for Teacher-Entity

1.POST:localhost:8080/student-management-system/api/v1/teachers

{   

    "firstName":"FirstName",

    "lastName":"LastName",
    
    "email":"test@test.se"  }

2. GET localhost:8080/student-management-system/api/v1/teachers/{id}


3. GET localhost:8080/student-management-system/api/v1/teachers



Arbetsmetod : Vi jobbade agilt med remote pair programming och turades om att göra commits till Github.
Vi hade var och en sin egen branch som vi uppdaterade efter varje commit. När vi slutförde labben mergade vi till main branchen på remote repository.

