package org.home.demoauthentication.users.model;

import org.home.demoauthentication.challenges.model.Challenge;
import org.home.demoauthentication.challenges.repository.ChallengesRepo;
import org.home.demoauthentication.users.repository.UserChallengesRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserChallengesService{
    private UserChallengesRepo userChallengesRepo;
    private Authentication authentication;

    public UserChallengesService(UserChallengesRepo userChallengesRepo){
        this.userChallengesRepo = userChallengesRepo;
    }


    public List<Challenge> getAll(){

        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))){

            return userChallengesRepo.getAll();
        }
        else {
              return userChallengesRepo.getChallenges();
        }
    }

    public List<UserChallenges> getUserChallenges() { return null;
    }

    public void delete() {
    }

    public void update(String userChallengeId, String status) {
    }
}
