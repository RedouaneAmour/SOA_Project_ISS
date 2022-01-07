This project is an illustration of a Service Oriented Architecture project using microservices concepts.
As an example, we simulated the behavior of an autonomous system for school rooms such as 
- blackboard adjustment for teachers
- self-regulated air-conditionning machine to detect carbon monoxyde or smoke

The project works as described right below : 
- There is a very central microservice acting like a central brain and that receives all public requests from outside
- There are two other subcentral microservices, one to handle the air conditionner subproject and the second to manage blackboard position given the teacher.
- Each subcentral microservice is an interface between the very central microservice and their respective project microservices.

For instance, BlackboardManagement subcentral microservice is an interface between the brain microservice and the blackboard microservices.

Do not forget to launch all the microservices to see the result

Requirements : 
- Eclipse
- Springboot framework
- Java 8 or 11
- Maven

