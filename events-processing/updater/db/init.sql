
CREATE TABLE event_logs (
  id BIGINT(11) NOT NULL AUTO_INCREMENT,
  user_id varchar(100) NOT NULL,
  post_id varchar(100) NOT NULL,
  action_type varchar(50) DEFAULT NULL,
  publish_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE action_logs (
  post_id varchar(100) NOT NULL,
  action_type varchar(50) DEFAULT NULL,
  total_count int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;