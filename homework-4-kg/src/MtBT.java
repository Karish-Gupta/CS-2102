/**
 * A binary tree that does not contain any values.
 * An empty tree.
 */
public class MtBT implements IBinTree {
    MtBT(){}
    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }
    // returns 0 since enpty tree has no elements
    public int size() {
        return 0;
    }
    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    /**
     * Checks if binary tree is heap for empty binary tree.
     * An empty bineary tree is a heap.
     * @return boolean
     */
    @Override
    public boolean isHeap() {
        return true;
    }

    /**
     * Checks if binary tree is heap for empty binary tree.
     * An empty bineary tree is a heap.
     * @param min
     * @return boolean
     */
    @Override
    public boolean isHeap(int min) {
        return true;
    }

    /**
     * Checks if the result contains all the elements in an empty heap.
     * @param aTree
     * @return boolean
     */
    @Override
    public boolean hasAllElt(IBinTree aTree) {
        return true;
    }

    /**
     * Checks if new added element is in the empty binary tree.
     * @param elt
     * @return boolean
     */
    @Override
    public boolean hasNewEltAdded(int elt) {
        return false;
    }

    /**
     * Checks if removed element is in the empty binary tree.
     * @return boolean
     */
    @Override
    public boolean hasMinEltRemoved(IBinTree hRemoved) {
        return false;
    }

    public boolean hasAllEltRemHelper(IBinTree aTree) {
        return true;
    }

    public boolean hasAllEltRem(IBinTree aTree) {
        return true;
    }

}