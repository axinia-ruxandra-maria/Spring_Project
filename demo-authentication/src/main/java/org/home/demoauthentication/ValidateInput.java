package org.home.demoauthentication;

import org.home.demoauthentication.challenges.model.Challenge;
import org.home.demoauthentication.exceptions.ValidationException;
import org.home.demoauthentication.rewards.endpoints.RewardDTO;
import org.home.demoauthentication.rewards.model.Reward;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static org.home.demoauthentication.exceptions.ValidationException.ValidationMessage.*;

@Component
public class ValidateInput {
    private static final int MAX_TITLE_LENGTH = 50;

    public void validateId(long id) throws ValidationException {
        if (isNull(id)) {
            throw new ValidationException(EXPECTED_ID);
        }

        try {
            Long.parseLong(String.valueOf(id));
        } catch (NumberFormatException nfe) {
            throw new ValidationException(ID_NOT_NUMERIC);
        }
    }

    public void validateTitle(String title) throws ValidationException  {
        if (isNull(title)) {
            throw new ValidationException(TITLE_CAN_NOT_BE_NULL);
        }

        if (title.length() > MAX_TITLE_LENGTH) {
            throw new ValidationException(TITLE_TOO_LONG);
        }
    }

    public void validateDescription(String description) throws  ValidationException{
        if( isNull(description)){
            throw  new ValidationException(DESCRIPTION_IS_NULL);
        }
        if(description.length() > 50){
            throw new ValidationException(DESCRITPION_TOO_LONG);
        }
    }


    private void validateName(String name) {
        if( isNull(name)){
            throw  new ValidationException(NAME_IS_NULL);
        }
        if(name.length() > 50){
            throw new ValidationException(NAME_TOO_LONG);
        }
    }

    public void validateCredits(long credits) throws ValidationException{
        if(isNull(credits)){
            throw new ValidationException(CREDITS_IS_NULL);
        }
        try {
            Long.parseLong(String.valueOf(credits));
        } catch (NumberFormatException nfe) {
            throw new ValidationException(CREDITS_NOT_NUMERIC);
        }
    }


    public void validateChallengeUpdate(Challenge challenge) {
        validateId(challenge.getId());
        validateTitle(challenge.getTitle());
        validateDescription(challenge.getDescription());
        validateCredits(challenge.getCredits());
    }

    public void validateCreateChallenge(Challenge challenge) {
        validateTitle(challenge.getTitle());
        validateDescription(challenge.getDescription());
        validateCredits(challenge.getCredits());
    }

    public void validateUrl(String url){
        if( isNull(url)){
            throw  new ValidationException(URL_IS_NULL);
        }
        if(url.length() > 50){
            throw new ValidationException(URL_TOO_LONG);
        }
    }

    public void validateCreateReward(RewardDTO rewardDTO) {
        validateDescription(rewardDTO.getDescription());
        validateCredits(rewardDTO.getCredits());
        validateName(rewardDTO.getName());
        validateUrl(rewardDTO.getUrl());
    }

    public void validateRewardUpdate(Reward reward) {
        validateId(reward.getId());
        validateDescription(reward.getDescription());
        validateCredits(reward.getCredits());
        validateName(reward.getName());
        validateUrl(reward.getUrl());
    }

}
