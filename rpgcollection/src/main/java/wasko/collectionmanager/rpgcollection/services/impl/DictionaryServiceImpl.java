package wasko.collectionmanager.rpgcollection.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wasko.collectionmanager.rpgcollection.entities.dictionary.AuthorDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.DictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.GenreDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.CategoryDictionaryEntity;
import wasko.collectionmanager.rpgcollection.exceptions.IllegalDictionaryTypeException;
import wasko.collectionmanager.rpgcollection.repositories.DictionaryRepository;
import wasko.collectionmanager.rpgcollection.services.DictionaryService;

import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository dictionaryRepository;


    @Override
    public DictionaryEntity findOrCreateValueByValueAndType(String value, String dType) {
        return dictionaryRepository.findByValueAndType(value, dType).orElseGet(() -> {
            switch(dType.toLowerCase()){
                case "author":
                    return  dictionaryRepository.save(new AuthorDictionaryEntity(value));
                case "category":
                    return dictionaryRepository.save(new CategoryDictionaryEntity(value));
                case "genre":
                    return dictionaryRepository.save(new GenreDictionaryEntity(value));
                default:
                    throw new IllegalDictionaryTypeException(
                            "A dictionary entry with type: " + dType + " cannot be created");
            }
        });
    }

    @Override
    public DictionaryEntity findByValueAndType(String value, String dType) {
        return dictionaryRepository.findByValueAndType(value, dType).orElseThrow(()-> new IllegalDictionaryTypeException("Specified value does not exist in the Dictionary"));
    }


    @Override
    public List<DictionaryEntity> findAllValuesByType(String dType) {
        return dictionaryRepository.findAllByType(dType);
    }
}
