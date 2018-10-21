package com.rpg.homework.homeworkrpg.user;

/**
 * Created by scott on 10/20/2018.
 */

public class UserObject {

    private String name;
    private String description;

    UserObject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
