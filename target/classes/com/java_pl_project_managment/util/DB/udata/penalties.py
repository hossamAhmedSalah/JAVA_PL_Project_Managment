EM_emails = [
'abigail.silva@example.com',
'albert.mortensen@example.com',
'alfredo.palmer@example.com',
'arnaud.pelletier@example.com',
'fanny.antonsen@example.com',
'HAFEZ_EM@gmail.com',
'hamid@gmail.com',
'HAMID_EM@gmail.com',
'HAZEM_AHMED_EM@gmail.com',
'HAZEM_WALIED_EM@gmail.com',
'HOSSAM_EM@gmail.com',
'idalecio.monteiro@example.com',
'irene.wells@example.com',
'irma.fernandez@example.com',
'jen.fitzsimmons@example.com',
'josephine.woods@example.com',
'JOUMANA_EM@gmail.com',
'liva.pedersen@example.com',
'mackenzie.walker@example.com',
'mya.marie@example.com',
'nathaniel.riley@example.com',
'pepe.costa@example.com',
'rocio.cortes@example.com',
'ryan.romero@example.com',
'ted.lek@example.com',
'thomas.rodriguez@example.com',
'TOQA_EM@gmail.com',
'zuzanna.sagbakken@example.com'
]
# email amount desc
table = "penalties"
for email in EM_emails:
    print(f"insert into {table} values('{email}', {0}, '')")

