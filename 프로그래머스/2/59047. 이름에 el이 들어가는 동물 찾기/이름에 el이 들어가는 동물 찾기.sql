-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = "Dog" AND NAME LIKE '%EL%'
ORDER BY NAME 

# SELECT ANIMAL_ID, NAME
# FROM ANIMAL_INS
# WHERE ANIMAL_TYPE = "Dog"
# ORDER BY NAME;