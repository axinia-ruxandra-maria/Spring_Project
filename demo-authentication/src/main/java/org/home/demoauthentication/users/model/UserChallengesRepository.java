package org.home.demoauthentication.users.model;

import org.home.demoauthentication.challenges.model.Challenge;

import java.util.List;

public interface UserChallengesRepository {
    public List<Challenge> getAll();

    public List<Challenge> getChallenges();
}
