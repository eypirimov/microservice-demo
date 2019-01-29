package com.dev.updater.utils;

public class Sql {
    public static final String INSERT_EVENT = "INSERT INTO event_logs(user_id,post_id,action_type) " +
            " VALUES(?,?,?)";

    public static final String UPSERT_ACTION_FOR_UNLIKE_AND_LIKE = "INSERT INTO action_logs(post_id,action_type,total_count) \n" +
            "VALUES   (?,?,1) \n" +
            "ON DUPLICATE KEY UPDATE total_count=(total_count + 1)";

    public static final String GET_LIKE_AND_UNLIKE_ACTION_COUNT = " select t1.like_, t2.unlike " +
            " from (select count(al1.action_type) as like_ from action_logs al1 where post_id=? and action_type='like') t1, \n" +
            "        (select count(al2.action_type) as unlike from action_logs al2 where post_id=? and action_type='unlike') t2 ";


}
