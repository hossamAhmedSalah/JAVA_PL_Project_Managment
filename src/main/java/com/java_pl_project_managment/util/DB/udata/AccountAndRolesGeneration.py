from randomuser import RandomUser



# Generate a list of 20 random users
Salary = 1250.0
user_list = RandomUser.generate_users(20)
users_data = [(
                     i.get_email(),
                     i.get_full_name(),
                     i.get_password(),
                     'M'if i.get_gender() == 'male' else 'F',
                     # role
                     'EM',
                     i.get_picture(),
                     # Salary
                     Salary


                     )
                    for i in user_list]
table_name = "Account"
for i in users_data:
    if i[0].isascii():
        print(f"insert into {table_name} values{i}")
    else:
        print(f"insert into {table_name} values (", end="")
        for j in range(len(i)):

            # for name and city if they are Arabic letters
            if j == 1 :
                print(f"N'{i[j]}'", end=",")
            # last in the querey string
            elif j == len(i) - 1:
                print(f"{i[j]} )")
            # what ever else
            else:
                print(f"'{i[j]}'", end="")
Role_table = 'EM'
for i in users_data:
    print(f"insert into {Role_table} values ('{i[0]}')")
    continue


"""
🔥Sample Run🔥 
insert into Account values('josephine.woods@example.com', 'Josephine Woods', 'german', 'F', 'EM', 'https://randomuser.me/api/portraits/women/52.jpg', 1250.0)
insert into Account values('idalecio.monteiro@example.com', 'Idalécio Monteiro', 'tripod', 'M', 'EM', 'https://randomuser.me/api/portraits/men/2.jpg', 1250.0)
insert into Account values('zuzanna.sagbakken@example.com', 'Zuzanna Sagbakken', 'florida1', 'F', 'EM', 'https://randomuser.me/api/portraits/women/50.jpg', 1250.0)
insert into Account values('thomas.rodriguez@example.com', 'Thomas Rodriguez', 'chandra', 'M', 'EM', 'https://randomuser.me/api/portraits/men/24.jpg', 1250.0)
insert into Account values('abigail.silva@example.com', 'Abigail Silva', 'bitter', 'F', 'EM', 'https://randomuser.me/api/portraits/women/67.jpg', 1250.0)
insert into Account values('ted.lek@example.com', 'Ted Lek', 'nanook', 'F', 'EM', 'https://randomuser.me/api/portraits/women/25.jpg', 1250.0)
insert into Account values('irma.fernandez@example.com', 'Irma Fernandez', 'angelica', 'F', 'EM', 'https://randomuser.me/api/portraits/women/56.jpg', 1250.0)
insert into Account values('liva.pedersen@example.com', 'Liva Pedersen', 'sporty', 'F', 'EM', 'https://randomuser.me/api/portraits/women/17.jpg', 1250.0)
insert into Account values('mya.marie@example.com', 'Mya Marie', 'colonial', 'F', 'EM', 'https://randomuser.me/api/portraits/women/9.jpg', 1250.0)
insert into Account values('ryan.romero@example.com', 'Ryan Romero', 'cthulhu', 'M', 'EM', 'https://randomuser.me/api/portraits/men/47.jpg', 1250.0)
insert into Account values('arnaud.pelletier@example.com', 'Arnaud Pelletier', 'peugeot', 'M', 'EM', 'https://randomuser.me/api/portraits/men/36.jpg', 1250.0)
insert into Account values('mackenzie.walker@example.com', 'Mackenzie Walker', 'csfbr5yy', 'F', 'EM', 'https://randomuser.me/api/portraits/women/61.jpg', 1250.0)
insert into Account values('fanny.antonsen@example.com', 'Fanny Antonsen', 'gotcha', 'F', 'EM', 'https://randomuser.me/api/portraits/women/92.jpg', 1250.0)
insert into Account values('albert.mortensen@example.com', 'Albert Mortensen', 'thewho', 'M', 'EM', 'https://randomuser.me/api/portraits/men/92.jpg', 1250.0)
insert into Account values('jen.fitzsimmons@example.com', 'Jen Fitzsimmons', 'shoes', 'F', 'EM', 'https://randomuser.me/api/portraits/women/23.jpg', 1250.0)
insert into Account values('alfredo.palmer@example.com', 'Alfredo Palmer', 'misfit', 'M', 'EM', 'https://randomuser.me/api/portraits/men/74.jpg', 1250.0)
insert into Account values('pepe.costa@example.com', 'Pepe Costa', 'felicia', 'M', 'EM', 'https://randomuser.me/api/portraits/men/54.jpg', 1250.0)
insert into Account values('irene.wells@example.com', 'Irene Wells', 'joke', 'F', 'EM', 'https://randomuser.me/api/portraits/women/71.jpg', 1250.0)
insert into Account values('rocio.cortes@example.com', 'Rocio Cortes', 'barbara', 'F', 'EM', 'https://randomuser.me/api/portraits/women/8.jpg', 1250.0)
insert into Account values('nathaniel.riley@example.com', 'Nathaniel Riley', 'andersen', 'M', 'EM', 'https://randomuser.me/api/portraits/men/95.jpg', 1250.0)
insert into EM values ('josephine.woods@example.com')
insert into EM values ('idalecio.monteiro@example.com')
insert into EM values ('zuzanna.sagbakken@example.com')
insert into EM values ('thomas.rodriguez@example.com')
insert into EM values ('abigail.silva@example.com')
insert into EM values ('ted.lek@example.com')
insert into EM values ('irma.fernandez@example.com')
insert into EM values ('liva.pedersen@example.com')
insert into EM values ('mya.marie@example.com')
insert into EM values ('ryan.romero@example.com')
insert into EM values ('arnaud.pelletier@example.com')
insert into EM values ('mackenzie.walker@example.com')
insert into EM values ('fanny.antonsen@example.com')
insert into EM values ('albert.mortensen@example.com')
insert into EM values ('jen.fitzsimmons@example.com')
insert into EM values ('alfredo.palmer@example.com')
insert into EM values ('pepe.costa@example.com')
insert into EM values ('irene.wells@example.com')
insert into EM values ('rocio.cortes@example.com')
insert into EM values ('nathaniel.riley@example.com')

"""



