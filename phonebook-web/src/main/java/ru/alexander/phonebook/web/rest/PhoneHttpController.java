package ru.alexander.phonebook.web.rest;

import ru.alexander.phonebook.entity.PersonalData;
import ru.alexander.phonebook.jpa.Repository;
import ru.alexander.phonebook.web.dto.PhonebookDto;
import ru.alexander.phonebook.web.dto.PhonebookDtoHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Collection;

/**
 * Веб-сервис, выполняющий работу с номерами телефона.
 */
@Path("/data")
public class PhoneHttpController {

    private final Repository repository = new Repository();

    @GET
    @Path("/phoneEntry")
    public Collection<PhonebookDto> getAllPhoneEntries() {
        final Collection<PersonalData> pds = repository.getAllPersonalData();
        return PhonebookDtoHelper.convert(pds);
    }
}
