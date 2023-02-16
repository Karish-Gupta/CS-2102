import java.util.Random;

/**
 * Handles methods for all heaps, a specialized binary tree.
 * Extends IBinTree.
 */
interface IHeap extends IBinTree {
    // adds given element to the heap without removing other elements
    IHeap addElt(int e);

    // removes one occurrence of the smallest element from the heap
    IHeap remMinElt();

    // merge the current heap with another heap
    IHeap merge(IHeap withHeap);

    // determines if the root of this heap is bigger than the given element
    boolean isBigger(int e);

    // check that no elements in the result that were not in the original for added value
    boolean addedSameSize(int elt, IBinTree hAdded);

    // check that no elements in the result that were not in the original for removed value
    boolean removedSameSize(IBinTree hRemoved);

}

