drop table user_credential_table;
create table user_credential_table
(
user_id varchar(254),
internal_user_id varchar(500),
passkey varchar(100),
user_first_name varchar(50),
user_last_name  varchar(50),
user_phone_no   varchar(16),
user_birth_date date ,
user_gender     varchar(1),
user_login_attempt int ,
user_locked_flg  varchar(1),
user_active_flg varchar(1),
user_activation_date    date,
user_expiry_date        date,
password_expiry_date    date,
record_disable_flg      varchar(1),
record_created_by       varchar(16),
record_updated_by       varchar(16),
record_created_on       date,
record_updated_on       date,
constraint user_credential_table_pk primary key ( user_id )
);
drop  table user_role_xface ;
create table user_role_xface
(
urx_id INT(11)  ,
user_id varchar(16) ,
user_role_id  varchar(10),
record_disable_flg varchar(1),
record_created_by       varchar(16),
record_updated_by       varchar(16),
record_created_on       date,
record_updated_on       date,
constraint user_role_xface_pk primary key ( urx_id ),
KEY fk_username_idx (user_id),
CONSTRAINT fk_username FOREIGN KEY (user_id) REFERENCES user_credential_table (user_id)
);
create unique index user_role_xface_undx on user_role_xface ( user_id,user_role_id );

insert into user_credential_table
values ('test@gmail.com',
'1',
'$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y',
'Sairam',
'Sairam',
'+91-99999',
'1981-01-01',
'M',
0,
'N',
'Y',
'2000-01-01',
'2099-01-01',
'2099-01-01',
'N',
'SYSTEM',
'SYSTEM',
'2000-01-01',
'2000-01-01'
);

commit;

insert into user_role_xface 
( urx_id,user_id,user_role_id ) values ( 1,'test@gmail.com','ROLE_USER');

