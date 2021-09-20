package wasko.collectionmanager.rpgcollection.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import wasko.collectionmanager.rpgcollection.entities.dictionary.AuthorDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.GenreDictionaryEntity;
import wasko.collectionmanager.rpgcollection.entities.dictionary.CategoryDictionaryEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameEntity implements Serializable {
    @Id
    @SequenceGenerator(name="game_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_generator")
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 3000)
    private String description;
    private String imageUrl;
    private BigDecimal price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @ManyToOne
    @JoinColumn(name ="publisherID")
    private GamePublisherEntity gamePublisher;
    @ManyToOne
    @JoinColumn(name ="categoryID")
    private CategoryDictionaryEntity category;
    @ManyToOne
    @JoinColumn(name="userID")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name="authorID")
    private AuthorDictionaryEntity author;
    @ManyToOne
    @JoinColumn(name="genreID")
    private GenreDictionaryEntity genre;



}
