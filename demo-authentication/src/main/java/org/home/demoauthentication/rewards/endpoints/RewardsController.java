package org.home.demoauthentication.rewards.endpoints;


import org.home.demoauthentication.challenges.model.Challenge;
import org.home.demoauthentication.rewards.model.Reward;
import org.home.demoauthentication.rewards.model.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RewardsController {
    private final RewardService rewardService;

    public RewardsController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/rewards")
    public List<Reward> getAll() {
        return rewardService.getAll();
    }

    @GetMapping("/rewards/{id}")
    public RewardDTO getById(@PathVariable("id") String id) { return rewardService.getById(Long.valueOf(id)); }

    @PostMapping("/rewards")
    public RewardDTO create(@RequestBody RewardDTO rewardDTO){
        return  rewardService.create(rewardDTO);
    }

    @PutMapping("/rewards/{id}")
    public RewardDTO update(@PathVariable("id") String id, @RequestBody Reward reward){
        reward.setId(Long.parseLong(id));
        return rewardService.update(reward);
    }

    @DeleteMapping("/rewards/{id}")
    public void delete(@PathVariable("id") String id){ rewardService.delete(Long.parseLong(id));
    }

}

