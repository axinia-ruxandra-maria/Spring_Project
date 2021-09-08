package org.home.demoauthentication.challenges.repository;

import org.home.demoauthentication.challenges.endpoints.ChallengeDTO;
import org.home.demoauthentication.challenges.model.Challenge;
import org.home.demoauthentication.challenges.model.ChallengeRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChallengesRepo implements ChallengeRepository {
    private static final String TITLE_COLUMN_NAME = "TITLE";
    private static final String CHALLENGES_TABLE_NAME = "challenges";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ChallengesRepo(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Challenge> getAll(){
        return jdbcTemplate.query("SELECT * FROM " + CHALLENGES_TABLE_NAME, (rs, rowNum) -> {
            long id = rs.getLong("ID");
            String title = rs.getString(TITLE_COLUMN_NAME);
            String description = rs.getString("DESCRIPTION");
            long credits = rs.getLong("CREDITS");
            return new Challenge(id, title, description, credits); });
    }


    @Override
    public void delete(long id) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("id", id);

        String SQL = "DELETE FROM "+ CHALLENGES_TABLE_NAME  +" where id = :id";

        jdbcTemplate.update(SQL, in);

    }

    @Override
    public ChallengeDTO create(Challenge challenge) {
        List<Challenge>chs = jdbcTemplate.query("SELECT * FROM " + CHALLENGES_TABLE_NAME, (rs, rowNum) -> {
            long id = rs.getLong("ID");
            String title = rs.getString(TITLE_COLUMN_NAME);
            String description = rs.getString("DESCRIPTION");
            long credits = rs.getLong("CREDITS");
            return new Challenge(id, title, description, credits); });

        long id = chs.get(chs.size()-1).getId() + 1;

        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("title", challenge.getTitle());
        in.addValue("description", challenge.getDescription());
        in.addValue("credits", challenge.getCredits());
        String SQL = "insert into " + CHALLENGES_TABLE_NAME + " (title, description, credits) values (:title, :description, :credits)";

        if (jdbcTemplate.update(SQL, in) == 1) {
            return new ChallengeDTO(id, challenge.getTitle(), challenge.getDescription(), challenge.getCredits());
        }
        else return null;
    }

    @Override
    public ChallengeDTO update(Challenge challenge) {

        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("id", challenge.getId());
        in.addValue("title", challenge.getTitle());
        in.addValue("description", challenge.getDescription());
        in.addValue("credits", challenge.getCredits());

        String SQL = "update " + CHALLENGES_TABLE_NAME +  " set description = :description, title=:title, credits=:credits where id = :id";
        if (jdbcTemplate.update(SQL, in) == 1) {
            return new ChallengeDTO(challenge.getId(), challenge.getTitle(), challenge.getDescription(), challenge.getCredits());
        } else {
            return null;
        }
    }
}
