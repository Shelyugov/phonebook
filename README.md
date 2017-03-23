# phonebook
## How to build

To build project, use root phonebook `gradle.build` file.

## Required setup

Glassfish 4.0

PostgreSql 9.4

## Request examples

```
$ curl -X GET http://localhost:8080/phonebook/rest/data/personalData
```

```
$ curl -X GET http://localhost:8080/phonebook/rest/data/personalData/id
```

```
$ curl -X PUT --data "name=yourname&surname=yoursurname" http://localhost:8080/phonebook/rest/data/personalData
```

```
$ curl -X POST --data="id=42&name=yourname&surname=yoursurname" http://localhost:8080/phonebook/rest/data/personalData
```

```
$ curl -X DELETE http://localhost:8080/phonebook/rest/data/personalData/id
```


### Obtain information about latest currency conversion at fixer.io

```
$ curl -X GET http://localhost:8080/phonebook/rest/external/currency
```


## WSDL locations

http://localhost:8080/phonebook/soap/PersonalData?wsdl

http://localhost:8080/phonebook/soap/Weather?wsdl


## Project structure

phonebook
- phonebook-entity
- phonebook-jpa
- phonebook-jdbc
- phonebook-web
