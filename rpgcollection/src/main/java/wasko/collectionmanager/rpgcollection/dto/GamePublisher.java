package wasko.collectionmanager.rpgcollection.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class GamePublisher {
    private long id;
    private String name;
    private String website;
    private String imageUrl;
}
