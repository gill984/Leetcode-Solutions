# Write your MySQL query statement below
SELECT Email from
(
    SELECT Email, count(Email) as num
    FROM Person
    GROUP BY Email
) AS statistic
WHERE num > 1