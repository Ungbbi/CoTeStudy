SELECT t.AUTHOR_ID, a.AUTHOR_NAME, CATEGORY, (SUM(TOTAL)) AS TOTAL_SALES
FROM AUTHOR a
JOIN (SELECT AUTHOR_ID, b.BOOK_ID, (SUM(SALES) * PRICE) AS TOTAL, CATEGORY
      FROM BOOK b
      JOIN BOOK_SALES s
      ON b.BOOK_ID = s.BOOK_ID
      WHERE s.SALES_DATE LIKE '2022-01-%'
      GROUP BY s.BOOK_ID) t
ON t.AUTHOR_ID = a.AUTHOR_ID
GROUP BY a.AUTHOR_ID, t.CATEGORY
ORDER BY a.AUTHOR_ID, CATEGORY DESC;

