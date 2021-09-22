SELECT
    name
FROM
    salesperson LEFT JOIN 
       (SELECT
            orders.sales_id, orders.order_id
        FROM
            orders LEFT JOIN company
        ON
            company.com_id = orders.com_id
        WHERE
            name = 'RED') AS red_sales
ON
    salesperson.sales_id = red_sales.sales_id
WHERE
    red_sales.order_id IS NULL



