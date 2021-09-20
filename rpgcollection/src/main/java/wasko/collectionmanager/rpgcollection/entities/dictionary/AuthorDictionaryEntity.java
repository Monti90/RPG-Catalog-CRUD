package wasko.collectionmanager.rpgcollection.entities.dictionary;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
//@AllArgsConstructor
@DiscriminatorValue(value = "author")
@EqualsAndHashCode(callSuper = false)
public class AuthorDictionaryEntity extends DictionaryEntity{


    //@OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private Set<GameEntity> gameEntity;

    public AuthorDictionaryEntity(String value){
        super();
        this.value = value;
    }
}
