Roles = [('EM', 1250.0), ('PM', 2000.0), ('TL', 1900.0), ('AD', 2200.0)]
Names = [
         ('TOQA', 'F'),
         ('JOUMANA', 'F')
         ('HAMID', 'M'),
         ('HOSSAM', 'M'),
         ('HAZEM_AHMED', 'M'),
         ('HAZEM_WALIED', 'M'),
         ('HAFEZ', 'M'),

         ]
# imgUrl[0] => M , imgUrl[1] => F
imgUrl = (
    'https://i.pinimg.com/564x/5f/40/6a/5f406ab25e8942cbe0da6485afd26b71.jpg',
    'https://i.pinimg.com/564x/ec/b3/32/ecb3320a4cb66ecdd9dd903f1fd6a5d8.jpg'
)
table = 'Account'
for name in Names:
    for role in Roles:
        if name[1] == 'M':
            print(f"insert into {table} values('{name[0]}_{role[0]}@gmail.com', '{name[0]}', '1234', '{name[1]}', '{role[0]}', '{imgUrl[0]}', {role[1]} )")
            print(f"insert into {role[0]} values('{name[0]}_{role[0]}@gmail.com')")
        else:
            print(f"insert into {table} values('{name[0]}_{role[0]}@gmail.com', '{name[0]}', '1234', '{name[1]}', '{role[0]}', '{imgUrl[1]}', {role[1]} )")
            print(f"insert into {role[0]} values('{name[0]}_{role[0]}@gmail.com')")






