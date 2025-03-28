-- 코드를 입력하세요
SELECT CONCAT("/home/grep/src/",
       CONCAT(f.BOARD_ID,
       CONCAT("/",
       CONCAT(FILE_ID,
       CONCAT(FILE_NAME,FILE_EXT))))) AS FILE_PATH
FROM USED_GOODS_FILE f
JOIN USED_GOODS_BOARD b
ON b.BOARD_ID = f.BOARD_ID
WHERE b.BOARD_ID = (SELECT BOARD_ID FROM USED_GOODS_BOARD ORDER BY VIEWS DESC LIMIT 1)
ORDER BY FILE_ID DESC;