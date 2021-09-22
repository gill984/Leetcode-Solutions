SELECT
    *,
    IF (x + y > z AND x + z > y AND z + y > x, 'Yes', 'No') as triangle
    FROM triangle