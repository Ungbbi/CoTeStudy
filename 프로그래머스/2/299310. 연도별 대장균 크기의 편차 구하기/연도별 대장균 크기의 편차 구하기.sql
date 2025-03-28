-- DATE_FORMAT쓰면 결과가 옳아도 틀린다.
SELECT 
    YEAR(e.DIFFERENTIATION_DATE) AS "YEAR",  
    (s.MAX_SIZE - e.SIZE_OF_COLONY) AS YEAR_DEV, 
    e.ID
FROM ECOLI_DATA e
JOIN (
    SELECT 
        MAX(SIZE_OF_COLONY) AS MAX_SIZE,
        YEAR(DIFFERENTIATION_DATE) AS YEAR
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
) s
ON YEAR(e.DIFFERENTIATION_DATE) = s.YEAR
ORDER BY YEAR ASC, YEAR_DEV ASC;
