package ru.alexander.phonebook.web.rest;

import ru.alexander.phonebook.entity.PersonalData;
import ru.alexander.phonebook.jdbc.PersonalDataRepository;
import ru.alexander.phonebook.web.dto.PhonebookDto;
import ru.alexander.phonebook.web.dto.PhonebookDtoHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер телефонной книги для обработки HTTP-запросов.
 * Использует JDBC.
 */
@Path("/personalData")
@Produces(MediaType.APPLICATION_XML)
public class PersonalDataHttpController {

    private static final String SUCCESS_RESULT = "<result>success</result>";
    private static final String FAILURE_RESULT = "<result>failure</result>";

    private final PersonalDataRepository repository = new PersonalDataRepository();

    @GET
    public List<PhonebookDto> getAllPersonalData() {
        return new ArrayList<>(PhonebookDtoHelper.convert(repository.getAllPersonalData()));
    }

    @GET
    @Path("/{pdId}")
    public PhonebookDto getPersonalData(@DefaultValue("0") @PathParam("pdId") long id) {
        if (id <= 0) {
            return null;
        }
        return PhonebookDtoHelper.convert(repository.getPersonalData(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addPersonalData(
            @FormParam("name") String name,
            @FormParam("surname") String surname
    ) {
        final PersonalData pd = new PersonalData(name, surname);
        if (repository.create(pd)) {
            return SUCCESS_RESULT;
        } else {
            return FAILURE_RESULT;
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updatePersonalData(
            @FormParam("id") long id,
            @FormParam("name") String name,
            @FormParam("surname") String surname
    ){
       final PersonalData pd = new PersonalData(id, name, surname);
        if (repository.update(pd)) {
            return SUCCESS_RESULT;
        } else {
            return FAILURE_RESULT;
        }
    }

    @DELETE
    @Path("/{pdId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String deletePersonalData(@DefaultValue("0") @PathParam("pdId") final long id) {
        if (id <= 0) {
            return FAILURE_RESULT;
        }
        if (repository.delete(id)) {
            return SUCCESS_RESULT;
        } else {
            return FAILURE_RESULT;
        }
    }
}
