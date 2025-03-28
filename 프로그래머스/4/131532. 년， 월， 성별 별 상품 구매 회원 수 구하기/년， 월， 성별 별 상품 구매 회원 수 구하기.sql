-- // GENDER 0:MALE, 1: FEMALE
-- 년 월 성별 별로 상품 구매 회원 수 조회
SELECT DATE_FORMAT(s.SALES_DATE,'%Y') AS YEAR, DATE_FORMAT(s.SALES_DATE,'%m') + 0 AS MONTH,
GENDER, COUNT(DISTINCT(s.USER_ID)) AS USERS
FROM USER_INFO u
JOIN ONLINE_SALE s
ON u.USER_ID = s.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER;