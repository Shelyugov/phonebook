package ru.alexander.phonebook.web.rest;

import ru.alexander.phonebook.entity.PersonalData;
import ru.alexander.phonebook.jdbc.JdbcRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Контроллер телефонной книги для обработки HTTP-запросов.
 */
@Path("/hello")
public class PhonebookHttpController {

//    private final Repository repository = new Repository();

    private final JdbcRepository repository = new JdbcRepository();

    @GET
    @Path("/helloWorld")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello, world!";
    }

    @PUT
    @Path("/addNewPersonalData")
    public String addNewPersonalData() {
        final PersonalData pd = new PersonalData();
        //try {
            pd.setName(UUID.randomUUID().toString());
            pd.setSurname(UUID.randomUUID().toString());
            if (repository.save(pd)) {
                return "Successfully added " + pd;
            } else {
                return "Failed to save " + pd;
            }
        //} catch (Exception e) {
            //return e.getMessage();
        //}
    }

    @DELETE
    @Path("/deletePersonalData")
    public String deletePersonalData(@DefaultValue("0") @QueryParam("id") final long id) {
        if (id <= 0) {
            return "Please, specify the required identifier of personal data with \"id\" parameter.";
        }
        if (repository.delete(id)) {
            return "Successfully deleted row with id " + id + "!";
        } else {
            return "Failed to delete row with id" + id + ".";
        }
    }
}
