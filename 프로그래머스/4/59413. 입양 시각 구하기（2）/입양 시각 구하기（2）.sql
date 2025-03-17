WITH RECURSIVE hours AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1 FROM hours WHERE HOUR < 23
)
SELECT 
    LPAD(h.HOUR, 2, '0') AS HOUR,  
    COUNT(o.DATETIME) AS COUNT
FROM hours h
LEFT OUTER JOIN ANIMAL_OUTS o
ON h.HOUR = DATE_FORMAT(o.DATETIME, '%H')
GROUP BY h.HOUR
ORDER BY h.HOUR;
