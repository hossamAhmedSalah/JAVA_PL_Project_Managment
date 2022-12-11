from randomuser import RandomUser



# Generate a list of 10 random users
user_list = RandomUser.generate_users(10)
users_data = [(
                     i.get_full_name(),
                     i.get_gender(),
                     i.get_email(),
                     i.get_password(),
                     i.get_age(),
                     i.get_picture(),
                     i.get_city(),
                     i.get_dob(),
                     i.get_phone()
                     )
                    for i in user_list]
table_name = "test"
for i in users_data:
    if i[0].isascii():
        print(f"insert into {table_name} values{i}")
    else:
        print(f"insert into {table_name} values (", end="")
        for j in range(len(i)):
            # for age to be detected 
            if (i[j]).isnumeric():
                print(f"{i[j]}", end="")
                continue
            # for name and city if they are Arabic letters 
            if j == 0 or j == 6:
                print(f"N'{i[j]}'", end=",")
            # last in the querey string
            elif j == len(i) - 1:
                print(f"{i[j]} )")
            # what ever else
            else:
                print(f"'{i[j]}'", end="")

"""
sample Run🌟
insert into test values('Huguette Roy', 'female', 'huguette.roy@example.com', 'micro', 75, 'https://randomuser.me/api/portraits/women/53.jpg', 'Oberburg', '1947-02-14T07:40:41.461Z', '075 715 57 90')
insert into test values('Elouan Renaud', 'male', 'elouan.renaud@example.com', 'shark1', 77, 'https://randomuser.me/api/portraits/men/61.jpg', 'Boulogne-Billancourt', '1945-07-08T07:37:35.564Z', '05-84-44-43-96')
insert into test values('Deborah Kliphuis', 'female', 'deborah.kliphuis@example.com', 'yang', 25, 'https://randomuser.me/api/portraits/women/17.jpg', 'Schin op Geul', '1997-04-18T10:48:52.781Z', '(063) 2664630')
insert into test values('Daniela Sanchez', 'female', 'daniela.sanchez@example.com', 'newark', 57, 'https://randomuser.me/api/portraits/women/93.jpg', 'Langendorf', '1965-11-17T12:48:07.880Z', '077 946 40 23')
insert into test values('Latife Abadan', 'female', 'latife.abadan@example.com', 'rafael', 58, 'https://randomuser.me/api/portraits/women/74.jpg', 'Rize', '1964-09-22T04:42:07.797Z', '(771)-513-1211')
insert into test values('Caroline Roberts', 'female', 'caroline.roberts@example.com', 'wifes', 54, 'https://randomuser.me/api/portraits/women/4.jpg', 'Chichester', '1968-07-17T02:42:50.728Z', '0112338 163 5848')
insert into test values('Aiden Smith', 'male', 'aiden.smith@example.com', 'fantasia', 36, 'https://randomuser.me/api/portraits/men/82.jpg', 'Westport', '1986-07-11T06:19:09.870Z', '401-480-0413')
insert into test values('Kurt Schmidt', 'male', 'kurt.schmidt@example.com', 'gggggggg', 27, 'https://randomuser.me/api/portraits/men/10.jpg', 'Warrnambool', '1995-08-16T19:25:13.308Z', '02-5893-5208')
insert into test values('Gabe Sanders', 'male', 'gabe.sanders@example.com', 'emily', 55, 'https://randomuser.me/api/portraits/men/32.jpg', 'Cobh', '1967-01-16T07:42:02.630Z', '031-157-7502')
insert into test values('Jessica Jenkins', 'female', 'jessica.jenkins@example.com', '1222', 26, 'https://randomuser.me/api/portraits/women/27.jpg', 'Norwalk', '1996-12-03T12:32:19.638Z', '(022)-462-6990')
🌟🌟
"""
