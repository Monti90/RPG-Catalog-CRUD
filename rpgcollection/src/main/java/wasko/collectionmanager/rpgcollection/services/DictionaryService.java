package wasko.collectionmanager.rpgcollection.services;


import org.apache.el.stream.Optional;
import wasko.collectionmanager.rpgcollection.entities.dictionary.DictionaryEntity;

import java.util.List;

public interface DictionaryService {

    DictionaryEntity findOrCreateValueByValueAndType(String value, String dType);

    DictionaryEntity findByValueAndType(String value, String dType);

    List<DictionaryEntity> findAllValuesByType(String dType);


}
