package wasko.collectionmanager.rpgcollection.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import wasko.collectionmanager.rpgcollection.entities.GameEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Builder
public class Game {
    private Long id;
    @NotBlank(message = "name cannot be null")
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private LocalDate releaseDate;
   @NotNull(message = "publisherID cannot be null")
    private Long publisherID;
   @NotNull(message = "UserID cannot be null")
    private Long userID;
    private String author;
    private String category;
    private String genre;

}
