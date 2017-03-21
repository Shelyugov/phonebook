package ru.alexander.phonebook.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Контроллер телефонной книги для обработки HTTP-запросов.
 */
@Path("/hello")
public class PhonebookHttpController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello, world!";
    }

}
