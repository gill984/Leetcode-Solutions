<h2>619. Biggest Single Number</h2><h3>Easy</h3><hr><div class="sql-schema-wrapper__3VBi"><a class="sql-schema-link__3cEg">SQL Schema<svg viewBox="0 0 24 24" width="1em" height="1em" class="icon__1Md2"><path fill-rule="evenodd" d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"></path></svg></a></div><div><p>Table <code>my_numbers</code> contains many numbers in column <b>num</b> including duplicated ones.<br>
Can you write a SQL query to find the biggest number, which only appears once.</p>

<pre>+---+
|num|
+---+
| 8 |
| 8 |
| 3 |
| 3 |
| 1 |
| 4 |
| 5 |
| 6 | 
</pre>
For the sample data above, your query should return the following result:

<pre>+---+
|num|
+---+
| 6 |
</pre>
<b>Note:</b><br>
If there is no such number, just output <b>null</b>.

<p>&nbsp;</p>
</div>