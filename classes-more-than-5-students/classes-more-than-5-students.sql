SELECT 
    class
FROM 
    (SELECT
        class, COUNT(DISTINCT student) As num
    FROM courses
    GROUP BY class) AS temp_table
WHERE num >= 5