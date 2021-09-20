package wasko.collectionmanager.rpgcollection.entities.dictionary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "dictionaries")
@Getter
@Setter
public class DictionaryEntity {
    @Id
    @SequenceGenerator(name = "dictionary_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_generator")
    @Column(name = "id")
    protected Long id;
    protected String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryEntity that = (DictionaryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @Override
    public String toString() {
        return "DictionaryEntity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
