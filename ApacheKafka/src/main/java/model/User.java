package model;

import java.io.Serializable;

/**
 * Created by Habib, on 17/11/2020
 */
public class User implements Serializable {

    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "model.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
