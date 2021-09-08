package org.home.demoauthentication.challenges.model;

import org.home.demoauthentication.challenges.endpoints.ChallengeDTO;

import java.util.List;

public interface ChallengeRepository {
    public List<Challenge> getAll();
    public void delete(long id);
    public ChallengeDTO create(Challenge challenge);
    public ChallengeDTO update(Challenge challenge);
}
