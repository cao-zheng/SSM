create table ssm_user(
  id varchar(36) not null,
  user_name varchar(36) not null,
  password varchar(64) not null,
  pwd_key varchar(6) not null,
  mobile char(11) not null,
  create_time datetime null,
  unique key(user_name),
  primary key(id)
);

delete from ssm_user