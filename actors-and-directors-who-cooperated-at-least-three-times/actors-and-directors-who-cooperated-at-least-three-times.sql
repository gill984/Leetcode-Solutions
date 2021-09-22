# actor_id, director_id which have cooperated at least 3 times
SELECT
    DISTINCT actor_id AS ACTOR_ID, director_id AS DIRECTOR_ID
FROM
    ActorDirector
GROUP BY
    actor_id, director_id
HAVING
    COUNT(*) >= 3