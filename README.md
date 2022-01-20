## Building REST services with Spring

REST is different from RPC (Remote Procedure Call) in the sense that with RPC there is no way to know how to interact with a service.
In this project, Spring HATEOAS is leveraged in order to build a RESTful service with hypermedia-driven outputs.

### Setting up the project
- Java 17
- Maven build tool
- Spring Web
- Spring Data JPA
- H2 Database
- Spring HATEOAS

### RESTful representation of a single employee
A JSON response body containing data and links to other resources of the service.
```
{
  "id": 1,
  "name": "John Doe",
  "role": "developer",
  "_links": {
    "self": {
      "href": "http://localhost:8080/employees/1"
    },
    "employees": {
      "href": "http://localhost:8080/employees"
    }
  }
}
```

