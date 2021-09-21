# Write your MySQL query statement below
SELECT weather.id
FROM Weather JOIN Weather w ON DATEDIFF(weather.recordDate, w.recordDate) = 1
AND weather.Temperature > w.Temperature
