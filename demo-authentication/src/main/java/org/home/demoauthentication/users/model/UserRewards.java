package org.home.demoauthentication.users.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRewards {
    private long login_id;
    private long reward_id;

    public UserRewards(long login_id, long reward_id){
        this.reward_id = reward_id;
        this.login_id = login_id;
    }
}
