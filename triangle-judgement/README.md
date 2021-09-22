<h2>610. Triangle Judgement</h2><h3>Easy</h3><hr><div class="sql-schema-wrapper__3VBi"><a class="sql-schema-link__3cEg">SQL Schema<svg viewBox="0 0 24 24" width="1em" height="1em" class="icon__1Md2"><path fill-rule="evenodd" d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"></path></svg></a></div><div>A pupil Tim gets homework to identify whether three line segments could possibly form a triangle.
<p>&nbsp;</p>
However, this assignment is very heavy because there are hundreds of records to calculate.

<p>&nbsp;</p>
Could you help Tim by writing a query to judge whether these three sides can form a triangle, assuming table <code>triangle</code> holds the length of the three sides x, y and z.

<p>&nbsp;</p>

<pre>| x  | y  | z  |
|----|----|----|
| 13 | 15 | 30 |
| 10 | 20 | 15 |
</pre>
For the sample data above, your query should return the follow result:

<pre>| x  | y  | z  | triangle |
|----|----|----|----------|
| 13 | 15 | 30 | No       |
| 10 | 20 | 15 | Yes      |
</pre>
</div>