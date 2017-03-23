package ru.alexander.phonebook.web.rest;

import ru.alexander.phonebook.entity.PersonalData;
import ru.alexander.phonebook.jpa.Repository;
import ru.alexander.phonebook.web.dto.PhonebookDto;
import ru.alexander.phonebook.web.dto.PhonebookDtoHelper;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Веб-сервис, выполняющий работу с номерами телефона.
 */
@Path("/data")
public class PhoneHttpController {

    private final Repository repository = new Repository();

    @GET
    @Path("/phoneEntry")
    public List<PhonebookDto> getAllPhoneEntries() {
        final Collection<PersonalData> pds = repository.getAllPersonalData();
        return new ArrayList<>(PhonebookDtoHelper.convert(pds));
    }

    @PUT
    @Path("/phoneEntry")
    public String createPhoneEntry() {
        final PersonalData pd = new PersonalData("Hello", "World");
        repository.save(pd);
        return "OK!";
    }
}
