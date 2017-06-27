insert into user (id, name, userid) 
values (1, 'User Name 1', 'UserId1');

insert into user (id, name, userid) 
values (2, 'User Name 2', 'UserId2');

insert into user (id, name, userid) 
values (3, 'User Name 3', 'UserId3');

insert into user (id, name, userid) 
values (4, 'User Name 4', 'UserId4');

insert into todo (id, title, description, is_done, target_date, userid) 
values (101, 'Todo Title 1', 'Todo Desc 1', false, CURRENT_DATE(), 1);
insert into todo (id, title, description, is_done, target_date, userid) 
values (102, 'Todo Title 2', 'Todo Desc 2', false, CURRENT_DATE(), 1);
insert into todo (id, title, description, is_done, target_date, userid) 
values (103, 'Todo Title 3', 'Todo Desc 3', false, CURRENT_DATE(), 2);