# LIKE, TO_CHAR
- 정규표현식 사용 가능
- 만약 Column 타입이 DATE 일 경우에는 TO_CHAR을 사용하여야 한다.
```MYSQL
SELECT * FROM TABLE WHERE NAME LIKE '라면%'
-- 라면으로 시작하는 이름을 가진 ROW 출력
SELECT * FROM TABLE WHERE LIKE '_라면%'
-- 맨 앞 한글자 아무거나 오고 그 뒤에 라면으로 시작하는 이름을 가진 ROW들 출력

SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE BETWEEN 20 AND 29
AND TO_CHAR(JOINED, 'YYYY') = '2021';

```

# DATE_FORMAT
- 날짜 형식 지정

```MYSQL
SELECT DATE_FORMAT(BOOK_ID, '%Y-%m-%d') AS B
FROM BOOK;

-- %Y : xxxx 4자리,  %y : 2021이라면 21만 출력
```

# TOP, ROWNUM
-- 상위 몇개를 출력하고 싶다.
### MYSQL
```MYSQL
SELECT TOP 1 NAME
FROM BOOK;
```
### ORACLE
```SQL
SELECT NAME
FROM (SELECT * FROM BOOK ORDER BY DATETIME ASC)
WHERE ROWNUM=1;
```
