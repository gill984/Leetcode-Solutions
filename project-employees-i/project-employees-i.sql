SELECT
    project_id, round(AVG(experience_years), 2) AS average_years
FROM
    Project AS p JOIN Employee AS e
    ON e.employee_id = p.employee_id
GROUP BY
    p.project_id