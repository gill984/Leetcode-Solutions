SELECT
    DISTINCT(c.seat_id)
FROM
    cinema c JOIN cinema d
ON
    c.free = 1 AND d.free = 1 AND (c.seat_id - d.seat_id = 1 OR c.seat_id - d.seat_id = -1)
ORDER BY
    seat_id

    