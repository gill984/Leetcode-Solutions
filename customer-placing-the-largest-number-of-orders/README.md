<h2>586. Customer Placing the Largest Number of Orders</h2><h3>Easy</h3><hr><div class="sql-schema-wrapper__3VBi"><a class="sql-schema-link__3cEg">SQL Schema<svg viewBox="0 0 24 24" width="1em" height="1em" class="icon__1Md2"><path fill-rule="evenodd" d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"></path></svg></a></div><div><p>Table: <code>Orders</code></p>

<pre>+-----------------+----------+
| Column Name     | Type     |
+-----------------+----------+
| order_number    | int      |
| customer_number | int      |
+-----------------+----------+
order_number is the primary key for this table.
This table contains information about the order ID and the customer ID.
</pre>

<p>&nbsp;</p>

<p>Write an SQL query to find the <code>customer_number</code> for the customer who has placed <strong>the largest number of orders</strong>.</p>

<p>It is <strong>guaranteed</strong> that exactly one customer will have placed more orders than any other customer.</p>

<p>The query result format is in the following example:</p>

<p>&nbsp;</p>

<pre>Orders table:
+--------------+-----------------+
| order_number | customer_number |
+--------------+-----------------+
| 1            | 1               |
| 2            | 2               |
| 3            | 3               |
| 4            | 3               |
+--------------+-----------------+

Result table:
+-----------------+
| customer_number |
+-----------------+
| 3               |
+-----------------+
The customer with number 3 has two orders, which is greater than either customer 1 or 2 because each of them only has one order. 
So the result is customer_number 3.
</pre>

<p>&nbsp;</p>
<strong>Follow up:</strong> What if more than one customer have the largest number of orders, can you find all the <code>customer_number</code> in this case?</div>