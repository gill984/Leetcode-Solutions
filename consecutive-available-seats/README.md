<h2>603. Consecutive Available Seats</h2><h3>Easy</h3><hr><div class="sql-schema-wrapper__3VBi"><a class="sql-schema-link__3cEg">SQL Schema<svg viewBox="0 0 24 24" width="1em" height="1em" class="icon__1Md2"><path fill-rule="evenodd" d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"></path></svg></a></div><div>Several friends at a cinema ticket office would like to reserve consecutive available seats.<br>
Can you help to query all the consecutive available seats order by the seat_id using the following <code>cinema</code> table?
<pre>| seat_id | free |
|---------|------|
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |
</pre>

<p>&nbsp;</p>
Your query should return the following result for the sample case above.

<p>&nbsp;</p>

<pre>| seat_id |
|---------|
| 3       |
| 4       |
| 5       |
</pre>
<b>Note</b>:

<ul>
	<li>The seat_id is an auto increment int, and free is bool ('1' means free, and '0' means occupied.).</li>
	<li>Consecutive available seats are more than 2(inclusive) seats consecutively available.</li>
</ul>
</div>