package ru.alexander.phonebook.web.soap;

import ru.alexander.phonebook.web.dto.PhoneBookDto;
import ru.alexander.phonebook.web.dto.PhoneDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Контроллер обработки SOAP-запросов.
 */
@WebService
public class SoapPhonebookController {
    @WebMethod
    public Set<PhoneBookDto> getAllPhoneNumbers() {
        final PhoneBookDto dto = new PhoneBookDto();
        dto.setName("Hello");
        dto.setSurname("World");
        final Set<PhoneDto> phoneDtos = new HashSet<>();
        final PhoneDto phoneDto = new PhoneDto();
        phoneDto.setNumber("+7(915)974-89-83");
        phoneDto.setType("CELL");
        phoneDtos.add(phoneDto);
        dto.setPhoneDtos(phoneDtos);

        return new HashSet<>(Arrays.asList(dto));
    }
}
