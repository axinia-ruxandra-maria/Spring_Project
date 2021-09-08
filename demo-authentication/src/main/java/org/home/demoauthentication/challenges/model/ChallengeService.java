package org.home.demoauthentication.challenges.model;

import org.home.demoauthentication.ValidateInput;
import org.home.demoauthentication.challenges.endpoints.ChallengeDTO;
import org.home.demoauthentication.challenges.repository.ChallengesRepo;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
public class ChallengeService {

    private final ChallengesRepo challengesRepo;
    private final ValidateInput validateInput;

    public ChallengeService(ChallengesRepo challengesRepo, ValidateInput validateInput){
        this.validateInput = validateInput;
        this.challengesRepo = challengesRepo;}

    public List<Challenge> getAll() { return challengesRepo.getAll(); }

    @RolesAllowed("ROLE_ADMIN")
    public ChallengeDTO updateChallenge(Challenge challenge) {
        validateInput.validateChallengeUpdate(challenge);
        return challengesRepo.update(challenge);
    }

    @RolesAllowed("ROLE_ADMIN")
    public ChallengeDTO createChallenge(Challenge challenge) {
        validateInput.validateCreateChallenge(challenge);
        return challengesRepo.create(challenge);
    }
    @RolesAllowed("ROLE_ADMIN")
    public void deleteChallenge(Long valueOf) {
        validateInput.validateId(valueOf);
        challengesRepo.delete(valueOf);
    }
}
