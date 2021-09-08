package org.home.demoauthentication.rewards.endpoints;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RewardDTO {
    private long id;
    private String name;
    private String description;
    private String url;
    private long credits;

    public RewardDTO(){}

    public RewardDTO(long id, String name, String description, String url,long credits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.credits = credits;
    }

}
