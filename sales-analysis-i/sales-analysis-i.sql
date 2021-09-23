# Write your MySQL query statement below
SELECT
    seller_id
FROM
    Sales
GROUP BY seller_id
HAVING SUM(price) = 
    (
        SELECT
            SUM(price) AS max_sales
        FROM
            Sales
        GROUP BY
            seller_id
        ORDER BY
            max_sales DESC
        LIMIT 1
    )