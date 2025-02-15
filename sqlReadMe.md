# LIKE
- 정규표현식 사용 가능
```MYSQL
SELECT * FROM TABLE WHERE NAME LIKE '라면%'
-- 라면으로 시작하는 이름을 가진 ROW 출력
SELECT * FROM TABLE WHERE LIKE '_라면%'
-- 맨 앞 한글자 아무거나 오고 그 뒤에 라면으로 시작하는 이름을 가진 ROW들 출력
```
