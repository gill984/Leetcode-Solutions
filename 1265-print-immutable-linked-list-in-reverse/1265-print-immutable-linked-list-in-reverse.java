/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode node) {
        if (node == null)
        {
            return;
        }
        else
        {
            printLinkedListInReverse(node.getNext());
            node.printValue();
        }
    }
}