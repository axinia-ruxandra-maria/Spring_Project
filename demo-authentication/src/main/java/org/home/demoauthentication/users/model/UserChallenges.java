package org.home.demoauthentication.users.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserChallenges {
    private long id;
    private long challenge_id;
    private long login_id;
    private String status;

    public UserChallenges(long id, long challenge_id, long login_id, String status){
        this.id = id;
        this.challenge_id = challenge_id;
        this.login_id = login_id;
        this.status = status;
    }

}
