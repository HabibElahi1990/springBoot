package model;

import lombok.*;

/**
 * Created by Habib, on 19/11/2020
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    @NonNull
    private Long id;
    @NonNull
    private String name;

}
