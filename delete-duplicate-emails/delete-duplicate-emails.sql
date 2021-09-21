DELETE p1
FROM Person AS p1 JOIN Person AS p2
WHERE p1.Email = p2.Email AND p1.ID > p2.ID