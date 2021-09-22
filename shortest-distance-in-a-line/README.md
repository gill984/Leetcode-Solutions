<h2>613. Shortest Distance in a Line</h2><h3>Easy</h3><hr><div class="sql-schema-wrapper__3VBi"><a class="sql-schema-link__3cEg">SQL Schema<svg viewBox="0 0 24 24" width="1em" height="1em" class="icon__1Md2"><path fill-rule="evenodd" d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"></path></svg></a></div><div>Table <code>point</code> holds the x coordinate of some points on x-axis in a plane, which are all integers.
<p>&nbsp;</p>
Write a query to find the shortest distance between two points in these points.

<p>&nbsp;</p>

<pre>| x   |
|-----|
| -1  |
| 0   |
| 2   |
</pre>

<p>&nbsp;</p>
The shortest distance is '1' obviously, which is from point '-1' to '0'. So the output is as below:

<p>&nbsp;</p>

<pre>| shortest|
|---------|
| 1       |
</pre>

<p>&nbsp;</p>
<b>Note:</b> Every point is unique, which means there is no duplicates in table <code>point</code>.

<p>&nbsp;</p>
<b>Follow-up:</b> What if all these points have an id and are arranged from the left most to the right most of x axis?

<p>&nbsp;</p>
</div>