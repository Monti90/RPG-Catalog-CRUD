package wasko.collectionmanager.rpgcollection.view;

import wasko.collectionmanager.rpgcollection.entities.enums.Role;

public interface UserWithoutPasswordView {

    String getUserName();
    String getEmail();
    Role getRole();
}
