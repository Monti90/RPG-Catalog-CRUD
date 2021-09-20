package wasko.collectionmanager.rpgcollection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wasko.collectionmanager.rpgcollection.entities.dictionary.DictionaryEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface DictionaryRepository extends JpaRepository<DictionaryEntity, Long> {

   @Query(value = "SELECT * FROM dictionaries WHERE dtype =?1", nativeQuery = true)
    List<DictionaryEntity> findAllByType(String dType);

   @Query(value = "SELECT * from dictionaries where value = ?1 and dtype = ?2", nativeQuery = true)
    Optional<DictionaryEntity> findByValueAndType(String value, String dType);

}
