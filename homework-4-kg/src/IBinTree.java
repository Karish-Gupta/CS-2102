import com.sun.org.glassfish.gmbal.ManagedObject;
import java.lang.Math;

/**
 * Handles methods for all binary trees.
 */
interface IBinTree {
    // determines whether element is in the tree
    boolean hasElt(int e);
    // returns number of nodes in the tree; counts duplicate elements as separate items
    int size();
    // returns depth of longest branch in the tree
    int height();
    // checks if this binary tree is a heap
    boolean isHeap();
    boolean isHeap(int data);
    // checks if an added elt is new binary tree
    boolean hasNewEltAdded(int elt);
    // determines if result contains all the elements from the original heap
    boolean hasAllElt(IBinTree aTree);
    // determines if the removed value has been removed from the original heap
    boolean hasMinEltRemoved(IBinTree hRemoved);
    // determines if result contains all the values from original heap except for the minimum value
    boolean hasAllEltRem(IBinTree aTree);
    // Helps in recursion for hasAllEltRem
    boolean hasAllEltRemHelper(IBinTree aTree);


}
