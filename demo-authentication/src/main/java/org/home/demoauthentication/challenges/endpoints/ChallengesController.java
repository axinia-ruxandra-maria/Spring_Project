package org.home.demoauthentication.challenges.endpoints;

import org.home.demoauthentication.challenges.model.Challenge;
import org.home.demoauthentication.challenges.model.ChallengeService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengesController {

    private final ChallengeService challengeService;

    public ChallengesController(final ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public List<Challenge> getAll() {
        return challengeService.getAll();
    }

    @PutMapping("/challenges/{id}")
    @Secured("ROLE_ADMIN")
    public void updateChallenge(@PathVariable("id") String id, @RequestBody Challenge challenge){
        challenge.setId(Long.parseLong(id));
        challengeService.updateChallenge(challenge);
    }

    @PostMapping("/challenges")
    @Secured("ROLE_ADMIN")
    public ChallengeDTO createChallenge(@RequestBody Challenge challenge){
        return challengeService.createChallenge(challenge);
    }

    @DeleteMapping("/challenges/{id}")
    @Secured("ROLE_ADMIN")
    public void delete(@PathVariable("id") String id){
        challengeService.deleteChallenge(Long.valueOf(id));
    }

}

