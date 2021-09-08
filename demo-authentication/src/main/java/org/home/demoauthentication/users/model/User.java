package org.home.demoauthentication.users.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private  long login_id;
    private  String name;
    private String role;
    private long experience;
    private long credits;

    public User(long login_id, String name, String role, long experience, long credits){
        this.login_id = login_id;
        this.name = name;
        this.role = role;
        this.experience = experience;
        this.credits = credits;
    }

}
