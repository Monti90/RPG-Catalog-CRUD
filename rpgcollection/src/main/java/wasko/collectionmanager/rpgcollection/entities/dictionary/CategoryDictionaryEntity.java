package wasko.collectionmanager.rpgcollection.entities.dictionary;


import lombok.*;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
//@AllArgsConstructor
@DiscriminatorValue(value = "category")
@EqualsAndHashCode(callSuper = false)
public class CategoryDictionaryEntity extends DictionaryEntity{

    //@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
   // private Set<GameEntity> gameEntity;

    public CategoryDictionaryEntity(String value){
        super();
        this.value = value;
    }
}
