1.Endpoint to retrieve data from SampleDataGenerator:

GET : localhost:8080/student-management-system/api/v1/subjects

QueryParam:

          name:name     value:Java/.Net/Python



2.Endpoints to create and retrieve one sample subject with a student and a teacher connected to it following example from lecture:

POST: localhost:8080/student-management-system/api/v1/subjects

             {
                  "name":"Golang"
                                    }

GET:   localhost:8080/student-management-system/api/v1/subjects

QueryParam:

            name:name     value:Golang