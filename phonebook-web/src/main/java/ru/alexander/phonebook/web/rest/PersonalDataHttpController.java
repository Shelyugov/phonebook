package ru.alexander.phonebook.web.rest;

import ru.alexander.phonebook.services.PersonalDataService;
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

    private final PersonalDataService service = new PersonalDataService();

    @GET
    public List<PhonebookDto> getAllPersonalData() {
        return new ArrayList<>(PhonebookDtoHelper.convert(service.get()));
    }

    @GET
    @Path("/{pdId}")
    public PhonebookDto getPersonalData(@DefaultValue("0") @PathParam("pdId") final Long id) {
        return PhonebookDtoHelper.convert(service.get(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addPersonalData(
            @FormParam("name") String name,
            @FormParam("surname") String surname
    ) {
        if (service.create(name, surname)) {
            return SUCCESS_RESULT;
        } else {
            return FAILURE_RESULT;
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updatePersonalData(
            @FormParam("id") final Long id,
            @FormParam("name") String name,
            @FormParam("surname") String surname
    ){
        if (service.update(id, name, surname)) {
            return SUCCESS_RESULT;
        } else {
            return FAILURE_RESULT;
        }
    }

    @DELETE
    @Path("/{pdId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String deletePersonalData(@DefaultValue("0") @PathParam("pdId") final Long id) {
        if (service.delete(id)) {
            return SUCCESS_RESULT;
        } else {
            return FAILURE_RESULT;
        }
    }
}
