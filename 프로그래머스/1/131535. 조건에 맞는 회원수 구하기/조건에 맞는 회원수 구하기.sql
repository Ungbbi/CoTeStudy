SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE BETWEEN 20 AND 29
AND TO_CHAR(JOINED, 'YYYY') = '2021';
