<h2>584. Find Customer Referee</h2><h3>Easy</h3><hr><div class="sql-schema-wrapper__3VBi"><a class="sql-schema-link__3cEg">SQL Schema<svg viewBox="0 0 24 24" width="1em" height="1em" class="icon__1Md2"><path fill-rule="evenodd" d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"></path></svg></a></div><div><p>Given a table <code>customer</code> holding customers information and the referee.</p>

<pre>+------+------+-----------+
| id   | name | referee_id|
+------+------+-----------+
|    1 | Will |      NULL |
|    2 | Jane |      NULL |
|    3 | Alex |         2 |
|    4 | Bill |      NULL |
|    5 | Zack |         1 |
|    6 | Mark |         2 |
+------+------+-----------+
</pre>

<p>Write a query to return the list of customers <b>NOT</b> referred by the person with id '2'.</p>

<p>For the sample data above, the result is:</p>

<pre>+------+
| name |
+------+
| Will |
| Jane |
| Bill |
| Zack |
+------+
</pre>
</div>