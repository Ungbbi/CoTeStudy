-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, SUM(PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER u
JOIN USED_GOODS_BOARD b
ON u.USER_ID = b.WRITER_ID
WHERE b.STATUS = 'DONE'
GROUP BY b.WRITER_ID
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES