package org.home.demoauthentication.rewards.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Reward {
    private long id;
    private String name;
    private String description;
    private String url;
    private long credits;

    public Reward(long id, String name, String description, String url, long credits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.credits = credits;
    }

    public Reward(long id, String name, String url, long credits) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.credits = credits;
    }
}
