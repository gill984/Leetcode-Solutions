import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    
    // This time, our stack will hold list iterators instead of just lists.
    private Deque<ListIterator<NestedInteger>> stackOfIterators = new ArrayDeque();
    private Integer peeked = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        // Make an iterator with the input and put it on the stack. 
        // Note that creating a list iterator is an O(1) operation.
        stackOfIterators.addFirst(nestedList.listIterator());
    }

    private void setPeeked() {
        
        // If peeked is already set, there's nothing to do.
        if (peeked != null) return;
        
        while (!stackOfIterators.isEmpty()) {
            
            // If the iterator at the top of the stack doesn't have a next,
            // remove that iterator and continue on.
            if (!stackOfIterators.peekFirst().hasNext()) {
                stackOfIterators.removeFirst();
                continue;
            }
            
            // Otherwise, we need to check whether that next is a list or 
            // an integer.
            NestedInteger next = stackOfIterators.peekFirst().next();
            
            // If it's an integer, set peeked to it and return as we're done.
            if (next.isInteger()) {
                peeked = next.getInteger();
                return;
            }
            
            // Otherwise, it's a list. Create a new iterator with it, and put
            // the new iterator on the top of the stack.
            stackOfIterators.addFirst(next.getList().listIterator());
        }        
    }
    

    @Override
    public Integer next() {
        
        // As per Java specs, throw an exception if there are no further elements.
        if (!hasNext()) throw new NoSuchElementException();
        
        // hasNext() called setPeeked(), which ensures peeked has the next integer 
        // in it. We need to clear the peeked field so that the element is returned
        // again.
        Integer result = peeked;
        peeked = null;
        return result;
    }

    @Override
    public boolean hasNext() {

        // Try to set the peeked field. If any integers are remaining, it will
        // contain the next one to be returned after this call.
        setPeeked();
        
        // There are elements remaining iff peeked contains a value.
        return peeked != null;
    }
}