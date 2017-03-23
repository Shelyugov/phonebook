package ru.alexander.phonebook.web.dto;

import ru.alexander.phonebook.entity.PersonalData;
import ru.alexander.phonebook.entity.PhoneNumber;
import ru.alexander.phonebook.entity.PhonebookEntry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Вспомогательный класс, предоставяющий методы для конвертации сущностей в DTO.
 */
public class PhonebookDtoHelper {

    public static Collection<PhonebookDto> convert(final Collection<PersonalData> personalDatapersonalDataCollection) {
        if (personalDatapersonalDataCollection == null || personalDatapersonalDataCollection.isEmpty()) {
            return Collections.emptySet();
        }
        final Set<PhonebookDto> phoneDtos = new HashSet<>(personalDatapersonalDataCollection.size());
        for (PersonalData pd : personalDatapersonalDataCollection) {
            phoneDtos.add(convert(pd));
        }
        phoneDtos.remove(null);
        return phoneDtos;
    }

    public static Collection<PhonebookDto> convertPhones(final Collection<PhonebookEntry> phones) {
        if (phones == null || phones.isEmpty()) {
            return Collections.emptySet();
        }
        final Set<PhonebookDto> phoneDtos = new HashSet<>(phones.size());
        for (PhonebookEntry pd : phones) {
            phoneDtos.add(convert(pd));
        }
        phoneDtos.remove(null);
        return phoneDtos;
    }

    public static PhonebookDto convert(final PersonalData pd) {
        if (pd == null) {
            return null;
        }
        final PhonebookDto dto = new PhonebookDto();
        dto.setName(pd.getName());
        dto.setSurname(pd.getSurname());
        return dto;
    }

    public static PhonebookDto convert(final PhonebookEntry pd) {
        if (pd == null) {
            return null;
        }
        final PhonebookDto dto = new PhonebookDto();
        dto.setName(pd.getPerson().getName());
        dto.setSurname(pd.getPerson().getSurname());
        final Set<PhoneDto> phoneDtos = new HashSet<>(pd.getPhoneNumbers().size());
        for (PhoneNumber phone : pd.getPhoneNumbers()) {
            phoneDtos.add(new PhoneDto(phone.getNumber(), phone.getPhoneNumberType().name()));
        }
        dto.setPhoneDtos(phoneDtos);
        return dto;
    }

    private PhonebookDtoHelper() {}
}
