package org.home.demoauthentication.rewards.model;

import org.home.demoauthentication.ValidateInput;
import org.home.demoauthentication.rewards.endpoints.RewardDTO;
import org.home.demoauthentication.rewards.repository.RewardsRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RewardService {

    private final RewardsRepo rewardsRepo;
    private final ValidateInput validateInput;

    public RewardService(RewardsRepo rewardsRepo, ValidateInput validateInput) {
        this.validateInput = validateInput;
        this.rewardsRepo = rewardsRepo;
   }

    public List<Reward>getAll(){ return rewardsRepo.getAll();}


    public RewardDTO getById(Long id) {
        validateInput.validateId(id);
       return rewardsRepo.getRewardById(id);
    }

    public RewardDTO create(RewardDTO rewardDTO) {
        validateInput.validateCreateReward(rewardDTO);
        return rewardsRepo.create(rewardDTO);
    }

    public RewardDTO update(Reward reward) {
        validateInput.validateRewardUpdate(reward);
        return rewardsRepo.update(reward);
    }

    public void delete(long parseLong) {
        validateInput.validateId(parseLong);
        rewardsRepo.delete(parseLong);
    }
}

