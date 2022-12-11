select * from test
select count(*) as cnt from test
use plproject
create table udata(
 id int primary key identity(1, 1),
 full_name nvarchar(50),
 gender nvarchar(7),
 email nvarchar(50),
 [password] nvarchar(10),
 age int ,
 img_url nvarchar(100),
 city nvarchar(15),
 /*data we have is formated like*/
 /*1948-12-22T01:36:50.539Z*/
 /*smalldatetime*/
 /*YYYY-MM-DD hh:mm:ss*/
 /*datatime*/
 /*YYYY-MM-DD hh:mm:ss[.nnn]*/
 date_of_birth datetime,
 phone nvarchar(15),
)

insert into udata values('Georgia Hall',
                         'female',
						 'georgia.hall@example.com', 
						 'blake1', 
						 25,
						 'https://randomuser.me/api/portraits/women/78.jpg', 
						 'Lower Hutt',
						 '1997-12-18T19:42:29.979Z',
						 '(731)-705-8145')
insert into udata values('Axel Dunker', 'male', 'axel.dunker@example.com', 'girsl', 28, 'https://randomuser.me/api/portraits/men/10.jpg', 'Krakow am See', '1994-04-19T18:39:39.545Z', '0858-9110881')
insert into udata values('Victoria Horton', 'female', 'victoria.horton@example.com', 'design', 34, 'https://randomuser.me/api/portraits/women/2.jpg', 'City of London', '1988-12-03T20:25:02.951Z', '017683 32647')
insert into udata values('Vilho Maijala', 'male', 'vilho.maijala@example.com', 'monique', 72, 'https://randomuser.me/api/portraits/men/42.jpg', 'Lumijoki', '1950-10-12T07:21:47.255Z', '09-523-765')
insert into udata values('Aria Bjelland', 'female', 'aria.bjelland@example.com', 'altima', 73, 'https://randomuser.me/api/portraits/women/44.jpg', 'Slåttevik', '1949-05-25T16:30:56.756Z', '37920614')
insert into udata values('Lucas Harris', 'male', 'lucas.harris@example.com', 'password2', 64, 'https://randomuser.me/api/portraits/men/1.jpg', 'Christchurch', '1958-09-06T02:01:53.397Z', '(304)-204-9415')
insert into udata values(N'آرمین احمدی', 'male', 'armyn.hmdy@example.com', 'uuuuuuu', 62, 'https://randomuser.me/api/portraits/men/76.jpg', N'سیرجان', '1960-10-02T14:49:47.894Z', '058-78613426')
insert into udata values('Toby Green', 'male', 'toby.green@example.com', 'jack1', 74, 'https://randomuser.me/api/portraits/men/78.jpg', 'Greymouth', '1948-12-22T01:36:50.539Z', '(387)-513-4471')

select * from udata