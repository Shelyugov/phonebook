package ru.alexander.phonebook.web.dto;

import ru.alexander.phonebook.entity.PersonalData;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Вспомогательный класс, предоставяющий методы для конвертации сущностей в DTO.
 */
public class PhonebookDtoHelper {

    public static Collection<PhonebookDto> convert(Collection<PersonalData> personalDataList) {
        if (personalDataList == null || personalDataList.isEmpty()) {
            return Collections.emptySet();
        }
        final Set<PhonebookDto> phoneDtos = new HashSet<>(personalDataList.size());
        for (PersonalData pd : personalDataList) {
            phoneDtos.add(convert(pd));
        }
        phoneDtos.remove(null);
        return phoneDtos;
    }

    public static PhonebookDto convert(PersonalData pd) {
        if (pd == null) {
            return null;
        }
        final PhonebookDto dto = new PhonebookDto();
        dto.setName(pd.getName());
        dto.setSurname(pd.getSurname());
        return dto;
    }

    private PhonebookDtoHelper() {}
}
