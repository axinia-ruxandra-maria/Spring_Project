package org.home.demoauthentication.rewards.repository;

import org.home.demoauthentication.challenges.endpoints.ChallengeDTO;
import org.home.demoauthentication.challenges.model.Challenge;
import org.home.demoauthentication.rewards.endpoints.RewardDTO;
import org.home.demoauthentication.rewards.model.Reward;
import org.home.demoauthentication.rewards.model.RewardRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Repository
public class RewardsRepo implements RewardRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public RewardsRepo(NamedParameterJdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }

        private static final String CHALLENGES_TABLE_NAME = "rewards";

    @Override
    public List<Reward> getAll(){
        return jdbcTemplate.query("SELECT * FROM " + CHALLENGES_TABLE_NAME, (rs, rowNum) -> {
            long id = rs.getLong("ID");
            String name = rs.getString("NAME");
            String description = rs.getString("DESCRIPTION");
            String url = rs.getString("URL");
            long credits = rs.getLong("CREDITS");
            return new Reward(id, name, url, credits); });
    }

    @Override
    public RewardDTO getRewardById(Long id) {
            MapSqlParameterSource in = new MapSqlParameterSource();
            in.addValue("id", id);
            String SQL = "SELECT * FROM " + CHALLENGES_TABLE_NAME + " where id =:id";
            RowMapper<Reward> todoRowMapper = (rs, rowNum) -> new Reward(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("url"),
                    rs.getInt("credits")
            );
            List<Reward> rewards = jdbcTemplate.query(SQL, todoRowMapper);

            Reward rezultat = rewards.get(0);

            return new RewardDTO(id,rezultat.getName(),rezultat.getDescription(),rezultat.getUrl(), rezultat.getCredits());

        }

        @Override
        public void delete(Long id) {
            MapSqlParameterSource in = new MapSqlParameterSource();
            in.addValue("id", id);

            String SQL = "DELETE FROM "+ CHALLENGES_TABLE_NAME  +" where id = :id";

            jdbcTemplate.update(SQL, in);

        }

        @Override
        public RewardDTO update(Reward reward) {
            MapSqlParameterSource in = new MapSqlParameterSource();
            in.addValue("id", reward.getId());
            in.addValue("title", reward.getName());
            in.addValue("description", reward.getDescription());
            in.addValue("credits", reward.getCredits());

            String SQL = "update " + CHALLENGES_TABLE_NAME +  " set description = :description, name=:name, credits=:credits where id = :id";
            return new RewardDTO(reward.getId(),reward.getName(), reward.getDescription(),reward.getUrl(), reward.getCredits());
        }

        public RewardDTO create(RewardDTO reward) {

            List<Reward>chs = jdbcTemplate.query("SELECT * FROM " + CHALLENGES_TABLE_NAME, (rs, rowNum) -> {
                long id = rs.getLong("ID");
                String name = rs.getString("NAME");
                String description = rs.getString("DESCRIPTION");
                long credits = rs.getLong("CREDITS");
                return new Reward(id, name, description, credits); });

            long id = chs.get(chs.size()-1).getId() + 1;

            MapSqlParameterSource in = new MapSqlParameterSource();
            in.addValue("id", id);
            in.addValue("title", reward.getName());
            in.addValue("description", reward.getDescription());
            in.addValue("credits", reward.getCredits());
            String SQL = "insert into " + CHALLENGES_TABLE_NAME + " (id, title, description, credits) values (:id, :title, :description, :credits)";

            if (jdbcTemplate.update(SQL, in) == 1) {
                return new RewardDTO(id, reward.getName(), reward.getDescription(), reward.getUrl(),reward.getCredits());
            }
            else return null;
          }

    }
