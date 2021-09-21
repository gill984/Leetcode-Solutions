# Write our MySQL query statement below
SELECT Name as 'Customers'
FROM Orders AS o RIGHT JOIN Customers AS c
ON o.CustomerId = c.Id
WHERE CustomerId is null