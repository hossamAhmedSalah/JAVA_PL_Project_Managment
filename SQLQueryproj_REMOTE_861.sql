select * from udata

create table Account(
	[email] nvarchar(50) PRIMARY KEY,
	username nvarchar(50),
	[password] nvarchar(50),
	gender char,
	[role] nvarchar(50),
	imgurl nvarchar(100),
	salary decimal
)

create table workhours(
	email nvarchar(50) references Account(email),
	number_of_hours int,
	date_of_day date
)

insert into Account
values('hamid@gmail.com','hamid','1234','M','EM','//',123.0)

insert into workhours
values('hamid@gmail.com',3,'2022-12-12')

insert into workhours
values('hamid@gmail.com',5,'2022-12-11')

select * from workhours
where email = 'hamid@gmail.com'

create table AD(
	ad_email nvarchar(50) references Account(email) PRIMARY KEY
)

create table PM(
	pm_email nvarchar(50) references Account(email) PRIMARY KEY
)

create table TL(
	tl_email nvarchar(50) references Account(email) PRIMARY KEY
)

create table EM(
	em_email nvarchar(50) references Account(email) PRIMARY KEY
)

/* 
0 in state => not started
1 => completed
2 => in progress
*/
create table project(
	pro_name nvarchar(50) PRIMARY KEY,
	pro_desc nvarchar(100),
	deadline date,
	pro_state tinyint DEFAULT(0),
	comp_percent decimal DEFAULT(0.0),
	pm_email nvarchar(50) references PM(pm_email),
	tl_email nvarchar(50) references TL(tl_email)
)

/* 
0 in state => not started
1 => completed
2 => in progress
*/
create table tasks(
	task_name nvarchar(50) PRIMARY KEY,
	task_desc nvarchar(100),
	task_state tinyint DEFAULT(0),
	pro_name nvarchar(50) references project(pro_name),
	tl_email nvarchar(50) references TL(tl_email),
	em_email nvarchar(50) references EM(em_email)
)

create table penalties(
	em_email nvarchar(50) references EM(em_email) PRIMARY KEY,
	amount decimal,
	p_desc nvarchar(100)
)

create table report(
	em_email nvarchar(50) references EM(em_email) PRIMARY KEY,
	report_desc nvarchar(100)
)

/* 
0 in state => rejected
1 => accepted
2 => pending
*/
create table vacation(
	v_id int PRIMARY KEY IDENTITY(20220,1),
	em_email nvarchar(50) references EM(em_email),
	s_date date,
	e_date date,
	v_state tinyint DEFAULT(2)
)