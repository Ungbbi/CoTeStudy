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

--DATE_FORMAT은 문자열, YEAR은 정수형
```

# LIMIT, ROWNUM
-- 상위 몇개를 출력하고 싶다.
### MYSQL
```MYSQL
SELECT NAME
FROM BOOK
LIMIT 10;
```
### ORACLE
```SQL
SELECT NAME
FROM (SELECT * FROM BOOK ORDER BY DATETIME ASC)
WHERE ROWNUM=1;
```

# FORMAT()
MySQL에서 컬럼 값을 특정 형식(예: 50.00cm)으로 출력하려면 FORMAT(), CONCAT(), CAST() 등을 사용할 수 있다.
```MYSQL
-- FORMAT
SELECT FORMAT(length, 2) AS formatted_length FROM your_table;
-- CONCAT - FORMAT
SELECT CONCAT(FORMAT(length, 2), 'cm') AS formatted_length FROM your_table;
-- CONCAT - CAST
SELECT CONCAT(CAST(length AS DECIMAL(10,2)), 'cm') AS formatted_length FROM your_table;
-- CONCAT - ROUND
SELECT CONCAT(ROUND(length, 2), 'cm') AS formatted_length FROM your_table;
```

# 주의
### ORDER BY
- `SELECT` 에서 `CONCAT`을 사용한 컬럼을 기준으로 정렬할 때, `CONCAT`에 의해 문자열로 타입이 변경되어 문자열 기준으로 정렬됨.
```SQL
SELECT CONCAT(SUM(DISTANCE), "km") AS TOTAL_DIS
FROM map
-- ORDER BY TOTAL_DIS (X)
ORDER BY SUM(DISTANCE);
```
