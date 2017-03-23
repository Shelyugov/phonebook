package ru.alexander.phonebook.web.soap;

import ru.alexander.phonebook.entity.PersonalData;
import ru.alexander.phonebook.jdbc.PersonalDataRepository;
import ru.alexander.phonebook.web.dto.PhonebookDto;
import ru.alexander.phonebook.web.dto.PhonebookDtoHelper;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Контроллер обработки SOAP-запросов.
 */
@WebService
public class SoapPhonebookController {

    private PersonalDataRepository repository = new PersonalDataRepository();

    @WebMethod
    @WebResult(name = "personalData")
    public Set<PhonebookDto> getAllPersonalData() {
        final List<PersonalData> personalDataList = repository.getAllPersonalData();
        if (personalDataList == null) {
            return Collections.emptySet();
        }
        return new HashSet<>(PhonebookDtoHelper.convert(personalDataList));
    }
}
