<h2>607. Sales Person</h2><h3>Easy</h3><hr><div class="sql-schema-wrapper__3VBi"><a class="sql-schema-link__3cEg">SQL Schema<svg viewBox="0 0 24 24" width="1em" height="1em" class="icon__1Md2"><path fill-rule="evenodd" d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"></path></svg></a></div><div><p><b>Description</b></p>

<p>Given three tables: <code>salesperson</code>, <code>company</code>, <code>orders</code>.<br>
Output all the <b>names</b> in the table <code>salesperson</code>, who didn’t have sales to company 'RED'.</p>

<p><b>Example</b><br>
<b>Input</b></p>

<p>Table: <code>salesperson</code></p>

<pre>+----------+------+--------+-----------------+-----------+
| sales_id | name | salary | commission_rate | hire_date |
+----------+------+--------+-----------------+-----------+
|   1      | John | 100000 |     6           | 4/1/2006  |
|   2      | Amy  | 120000 |     5           | 5/1/2010  |
|   3      | Mark | 65000  |     12          | 12/25/2008|
|   4      | Pam  | 25000  |     25          | 1/1/2005  |
|   5      | Alex | 50000  |     10          | 2/3/2007  |
+----------+------+--------+-----------------+-----------+
</pre>
The table <code>salesperson</code> holds the salesperson information. Every salesperson has a <b>sales_id</b> and a <b>name</b>.

<p>Table: <code>company</code></p>

<pre>+---------+--------+------------+
| com_id  |  name  |    city    |
+---------+--------+------------+
|   1     |  RED   |   Boston   |
|   2     | ORANGE |   New York |
|   3     | YELLOW |   Boston   |
|   4     | GREEN  |   Austin   |
+---------+--------+------------+
</pre>
The table <code>company</code> holds the company information. Every company has a <b>com_id</b> and a <b>name</b>.

<p>Table: <code>orders</code></p>

<pre>+----------+------------+---------+----------+--------+
| order_id | order_date | com_id  | sales_id | amount |
+----------+------------+---------+----------+--------+
| 1        |   1/1/2014 |    3    |    4     | 100000 |
| 2        |   2/1/2014 |    4    |    5     | 5000   |
| 3        |   3/1/2014 |    1    |    1     | 50000  |
| 4        |   4/1/2014 |    1    |    4     | 25000  |
+----------+----------+---------+----------+--------+
</pre>
The table <code>orders</code> holds the sales record information, salesperson and customer company are represented by <b>sales_id</b> and <b>com_id</b>.

<p><b>output</b></p>

<pre>+------+
| name | 
+------+
| Amy  | 
| Mark | 
| Alex |
+------+
</pre>

<p><b>Explanation</b></p>

<p>According to order '3' and '4' in table <code>orders</code>, it is easy to tell only salesperson 'John' and 'Pam' have sales to company 'RED',<br>
so we need to output all the other <b>names</b> in the table <code>salesperson</code>.</p>
</div>