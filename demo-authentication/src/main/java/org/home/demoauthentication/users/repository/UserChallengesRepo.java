package org.home.demoauthentication.users.repository;

import org.home.demoauthentication.challenges.model.Challenge;
import org.home.demoauthentication.users.model.UserChallengesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserChallengesRepo implements UserChallengesRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public UserChallengesRepo(NamedParameterJdbcTemplate namedParameterJdbcTemplate){this.jdbcTemplate = namedParameterJdbcTemplate; }

    private long currentUserLoginId;

    @Override
    @RolesAllowed("ROLE_ADMIN")
    public List<Challenge> getAll() {
        return jdbcTemplate.query("SELECT * FROM Challenges" , (rs, rowNum) -> {
            long id = rs.getLong("ID");
            String title = rs.getString("TITLE");
            String description = rs.getString("DESCRIPTION");
            long credits = rs.getLong("CREDITS");
            return new Challenge(id, title, description, credits); });
    }

    Logger logger = LoggerFactory.getLogger(UserChallengesRepo.class);

    @Override
    public List<Challenge> getChallenges() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("username", currentPrincipalName);
        String SQL = "SELECT LOGIN_ID FROM users where username = :username";
        List<Long>ids = jdbcTemplate.queryForList(SQL,in,Long.class);
        long user_id = ids.get(0);
        this.currentUserLoginId = user_id;

        MapSqlParameterSource inFinal = new MapSqlParameterSource();
        inFinal.addValue("login_id",user_id);
        SQL = "SELECT challenge_id FROM user_challenge where login_id = :login_id";
        List<Long>challenge_ids = jdbcTemplate.queryForList(SQL,inFinal,Long.class);

        MapSqlParameterSource inFinal1 = new MapSqlParameterSource();
        inFinal.addValue("login_id",user_id);
        String SQL1 = "SELECT status FROM user_challenge where login_id = :login_id";
        List<String>statuses = jdbcTemplate.queryForList(SQL1,inFinal1,String.class);


        List<Challenge> result = new ArrayList<>();

        for(long i: challenge_ids){
            String SQL2 = "SELECT * FROM challenges where id = " + i ;
           List<Challenge>challenges =  jdbcTemplate.query(SQL2, (rs, rowNum) -> {
                long id = rs.getLong("ID");
                String title = rs.getString("Title");
                String description = rs.getString("DESCRIPTION");
                long credits = rs.getLong("CREDITS");
                return new Challenge(id, title, description, credits); });
           result.add(challenges.get(0));
        }
        return result;
    }


}
