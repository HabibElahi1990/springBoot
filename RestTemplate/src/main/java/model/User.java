package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


/**
 * Created by Habib, on 20/11/2020
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    private Long id;
    private String userName;
    private String password;
    private Boolean activeFlag;

    @Builder
    public User(Long id, String userName, String password, Boolean activeFlag) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.activeFlag = activeFlag;
    }
}
