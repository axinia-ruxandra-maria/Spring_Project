package org.home.demoauthentication.rewards.model;

import org.home.demoauthentication.rewards.endpoints.RewardDTO;

import java.util.List;

public interface RewardRepository {
        public List<Reward> getAll();
        public RewardDTO getRewardById(Long id);
        public void delete(Long id);
        public RewardDTO update(Reward reward);
        public RewardDTO create(RewardDTO reward);
    }

