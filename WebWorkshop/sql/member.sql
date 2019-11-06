drop table member;

create table member( 
 id varchar(20) primary key, 
 pw varchar(20) not null,
 name varchar(20) not null,
 nickname varchar(30),
 email varchar(30),
 homepage varchar(30),
 address varchar(100),
 hobby varchar(50)
);

insert into member values('admin', 'admin', 'admin', 'admin',
     'admin@ssafy.com','www.ssafy.com','seoul','독서');
insert into member values('ssafy', 'ssafy', 'ssafy', 'ssafy',
     'java@ssafy.com','www.ssafy.com','seoul','독서 여행');
commit;

select * from member;



