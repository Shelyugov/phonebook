package ru.alexander.phonebook.web.rest;

import ru.alexander.phonebook.entity.PhonebookEntry;
import ru.alexander.phonebook.jpa.Repository;
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

    private final Repository repository = new Repository();

    @GET
    public List<PhonebookDto> getAllPhoneEntries() {
        final Collection<PhonebookEntry> pds = repository.getAllPhoneEntries();
        return new ArrayList<>(PhonebookDtoHelper.convertPhones(pds));
    }

    @GET
    @Path("/{phId}")
    public PhonebookDto getPhoneEntry(@DefaultValue("0") @PathParam("phId") long id) {
        final PhonebookEntry entry = repository.getPhoneEntryById(id);
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
//        PersonalData pd = repository.findPersonalData(name, surname);
//        if (pd == null) {
//            pd = new PersonalData();
//        }
//        pd.setName(name);
//        pd.setSurname(surname);
//        pd = repository.save(pd);
//
//        PhonebookEntry entry = new PhonebookEntry();
//        entry.setPerson(pd);
//        entry = repository.save(entry);
//
//        final PhoneNumber number = new PhoneNumber();
//        number.setNumber(phone);
//        number.setPhoneNumberType(PhoneNumberType.valueOf(type));
//        number.setEntry(entry);
//        repository.save(number);
        repository.process(name, surname, phone, type);
        return "OK!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updatePhoneEntry(
            @FormParam("id") long id,
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("phone") String phone,
            @DefaultValue("cell") @FormParam("phoneType") String type
    ) {
        final PhonebookEntry entry = repository.getPhoneEntryById(id);
        repository.save(entry);
        return "OK!";
    }

    @DELETE
    @Path("/{phId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String deletePhoneEntry(@DefaultValue("0")  @PathParam("phId") long id) {
        repository.delete(id);
        return "OK!";
    }

}
