# phonebook
Phonebook application

Required setup:
Glassfish 4.0
PostgreSql 9.4

Request examples:
GET http://localhost:8080/phonebook/rest/data/personalData
GET http://localhost:8080/phonebook/rest/data/personalData/id
PUT http://localhost:8080/phonebook/rest/data/personalData (with form parameters name and surname)
POST http://localhost:8080/phonebook/rest/data/personalData (with id, name and surname parameters)
DELETE http://localhost:8080/phonebook/rest/data/personalData/id

Obtain information about latest currency conversion at fixer.io
GET http://localhost:8080/phonebook/rest/external/currency

WSDL locations
http://localhost:8080/phonebook/soap/PersonalData?wsdl
http://localhost:8080/phonebook/soap/Weather?wsdl

Project structure
phonebook
- phonebook-entity
- phonebook-jpa (Work in progress)
- phonebook-jdbc
- phonebook-web

To build project, use root phonebook gradle.build file.
