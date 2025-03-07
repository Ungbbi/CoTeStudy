-- 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 
-- 총 대여 횟수가 5회 이상인 자동차들에 대해서 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수
-- 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬
-- 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외.
-- 8월부터 10월 까지. CAR_ID의 합이 5 이상이어야 함
SELECT DATE_FORMAT(START_DATE,'%m') + 0 AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE MONTH(START_DATE) BETWEEN 08 AND 11
    GROUP BY CAR_ID HAVING COUNT(*) >= 5
    )
GROUP BY MONTH, CAR_ID
HAVING MONTH BETWEEN 8 AND 11
ORDER BY MONTH, CAR_ID DESC;