package com.dev.updater.repositories;

import com.dev.updater.domains.Action;
import com.dev.updater.domains.Event;
import com.dev.updater.utils.Sql;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class EventRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertEvent(Event event) {
        log.info("<insertEvent> Event : {}", event.toString());
        return jdbcTemplate.update(Sql.INSERT_EVENT, new Object[]{event.getUserId(), event.getPostId(), event.getActionType().toLowerCase()});
    }

    public int updateActionReport(String postId, String actionType) {
        log.info("<updateActionReport> POST ID : {} , ACTION TYPE : {}", postId, actionType);
        return jdbcTemplate.update(Sql.UPSERT_ACTION_FOR_UNLIKE_AND_LIKE, new Object[]{postId, actionType.toLowerCase()});
    }

    public Action getActionByPostId(String postId) {
        return jdbcTemplate.queryForObject(Sql.GET_LIKE_AND_UNLIKE_ACTION_COUNT, new Object[]{postId, postId},
                (r, i) -> new Action(r.getInt("like_"), r.getInt("unlike")));
    }

}
