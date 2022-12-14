from datetime import date, timedelta
import random

pm_emails = [
'HAFEZ_PM@gmail.com',
'HAMID_PM@gmail.com',
'HAZEM_AHMED_PM@gmail.com',
'HAZEM_WALIED_PM@gmail.com',
'Hossam@gmail.com',
'HOSSAM_PM@gmail.com',
'JOUMANA_PM@gmail.com',
'TOQA_PM@gmail.com',
    
]
tl_emails = [
'HAFEZ_TL@gmail.com',
'HAMID_TL@gmail.com',
'HAZEM_AHMED_TL@gmail.com',
'HAZEM_WALIED_TL@gmail.com',
'Hossam@gmail.com',
'HOSSAM_TL@gmail.com',
'JOUMANA_TL@gmail.com',
'TOQA_TL@gmail.com',

]
# pro_name pro_desc deadline proState progress pm_email tl_email
pro_names = ['pro_'+i.split('@')[0] for i in pm_emails]
# initializing dates ranges
test_date1, test_date2 = date(2022, 12, 14), date(2022, 12, 30)

# getting days between dates
dates_bet = test_date2 - test_date1
total_days = dates_bet.days

dates = []
for idx in range(len(pm_emails)):
    random.seed(a=None)

    # getting random days
    randay = random.randrange(total_days)

    # getting random dates
    dates.append(test_date1 + timedelta(days=randay))
table = "project"
for i in range(len(pro_names)):
    print(f"insert into {table} values('{pro_names[i]}', '', '{dates[random.randint(0, len(dates)-1)]}',{random.randint(0, 2)}, {random.randint(3, 100)}, '{pm_emails[i]}','{tl_emails[i]}') ")





