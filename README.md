# phonebook
## How to build

To build project, use root phonebook `gradle.build` file.

The script to initialize database is stored in [create_schema.sql](src/main/resources/create_schema.sql) file.

## Required setup

[Glassfish 4.0](http://download.java.net/glassfish/4.0/release/glassfish-4.0.zip)

[PostgreSql 9.4](https://www.postgresql.org/download/)

## Request examples

### Personal data
```
$ curl -X GET http://localhost:8080/phonebook/rest/data/personalData
```

```
$ curl -X GET http://localhost:8080/phonebook/rest/personalData/id
```

```
$ curl -X PUT --data "name=yourname&surname=yoursurname" http://localhost:8080/phonebook/rest/personalData
```

```
$ curl -X POST --data="id=42&name=yourname&surname=yoursurname" http://localhost:8080/phonebook/rest/personalData
```

```
$ curl -X DELETE http://localhost:8080/phonebook/rest/personalData/id
```

### Phonebook entry
```
$ curl -X GET http://localhost:8080/phonebook/rest/data/phoneEntry
```

```
$ curl -X POST --data="id=42&name=yourname&surname=yoursurname&phone=123456789&type=cell" http://localhost:8080/phonebook/rest/phoneEntry
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
