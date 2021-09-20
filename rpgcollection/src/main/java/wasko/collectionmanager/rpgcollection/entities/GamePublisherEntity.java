package wasko.collectionmanager.rpgcollection.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GamePublisherEntity implements Serializable {

    @Id
    @SequenceGenerator(name="publisher_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
    @Column(name = "publisherID")
    private long id;
    private String name;
    private String website;
    private String imageUrl;

}
