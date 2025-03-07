-- 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회
-- 2022년도의 평가 점수는 상,하반기 점수의 합을 의미하고
-- 평가 점수를 나타내는 컬럼의 이름은 SCORE로 해주세요.
-- dept 테이블 필요 없음
SELECT SUM(SCORE) AS SCORE, e.EMP_NO, EMP_NAME, POSITION, EMAIL
FROM HR_EMPLOYEES e JOIN HR_GRADE g ON e.EMP_NO = g.EMP_NO
GROUP BY EMP_NO
ORDER BY SCORE DESC
LIMIT 1;
