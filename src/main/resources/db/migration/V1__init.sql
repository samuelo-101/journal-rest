/*CREATE TABLE hibernate_sequence (
  sequence_name varchar(255) CHARACTER SET UTF8 not null ,
  next_val bigint(20),
  primary key (sequence_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user (
  id bigint(20) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  version INTEGER NOT NULL,
  created_on TIMESTAMP NOT NULL,
  updated_on TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY UK__user_handle (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE journal (
  id bigint(20) NOT NULL,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  version INTEGER NOT NULL,
  created_on TIMESTAMP NOT NULL,
  updated_on TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
