package org.home.demoauthentication.users.endpoints;

import org.home.demoauthentication.challenges.model.Challenge;
import org.home.demoauthentication.users.model.UserChallenges;
import org.home.demoauthentication.users.model.UserChallengesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    private final UserChallengesService userChallengesService;

    public UsersController(UserChallengesService userChallengesService){this.userChallengesService = userChallengesService;}

    @GetMapping("/user-challenges")
    public List<Challenge> userChallenges(){ return userChallengesService.getAll(); }

    @GetMapping("/user-challenges?userId={id}") // what is the difference between this and the one above????
    public List<UserChallenges> userChallenges2(){ return userChallengesService.getUserChallenges();}

    @DeleteMapping("/user-challenges/{userChallengeId}")
    public void delete(@PathVariable String userChallengeId){ userChallengesService.delete();
    }

    @PostMapping("/user-challenges")//userId taken from the session
    public void create(String challengeId, String status){ }

    @PutMapping("/user-challenges/{userChallengeId}")
    public void update(@PathVariable String userChallengeId, String status){
        status = "completed";
        userChallengesService.update(userChallengeId,status);
    }
}
