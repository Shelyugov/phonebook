package ru.alexander.phonebook.web.rest;

import ru.alexander.phonebook.entity.PhoneNumberType;
import ru.alexander.phonebook.entity.PhonebookEntry;
import ru.alexander.phonebook.services.PhonebookEntryService;
import ru.alexander.phonebook.web.dto.PhonebookDto;
import ru.alexander.phonebook.web.dto.PhonebookDtoHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Веб-сервис, выполняющий работу с номерами телефона.
 * Использует JPA.
 */
@Path("/phoneEntry")
@Produces(MediaType.APPLICATION_JSON)
public class PhoneHttpController {

    private static final String OK_RESULT = "{ result: success }";

    private final PhonebookEntryService service = new PhonebookEntryService();

    @GET
    public List<PhonebookDto> getAllPhoneEntries() {
        final Collection<PhonebookEntry> pds = service.get();
        return new ArrayList<>(PhonebookDtoHelper.convertPhones(pds));
    }

    @GET
    @Path("/{phId}")
    public PhonebookDto getPhoneEntry(@DefaultValue("0") @PathParam("phId") long id) {
        final PhonebookEntry entry = service.get(id);
        return PhonebookDtoHelper.convert(entry);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createPhoneEntry(
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("phone") String phone,
            @DefaultValue("cell") @FormParam("phoneType") String type
    ) {
        service.create(name, surname, phone, PhoneNumberType.valueOf(type.toUpperCase()));
        return OK_RESULT;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updatePhoneEntry(
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("phone") String phone,
            @DefaultValue("cell") @FormParam("phoneType") String type
    ) {
        service.update(name, surname, phone, PhoneNumberType.valueOf(type.toUpperCase()));
        return OK_RESULT;
    }

    @DELETE
    @Path("/{phId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String deletePhoneEntry(@DefaultValue("0") @PathParam("phId") long id) {
        service.delete(id);
        return OK_RESULT;
    }

}
