/**
 * A specialized binary tree where the root node is always less than the child nodes.
 * An empty heap contains no data.
 */
public class MtHeap extends MtBT implements IHeap {
    MtHeap(){}
    @Override
    // If you add an element to a MtHeap, you create a new DataHeap
    public IHeap addElt(int e) {
        return new DataHeap(e, new MtHeap(), new MtHeap());
    }
    @Override
    // The min element of an empty heap returns an empty heap.
    public IHeap remMinElt() {
        return new MtHeap();
    }
    @Override
    // An empty heap should always lose a competition for which root is smaller (for the merge function)
    public boolean isBigger(int e) {
        return true;
    }
    @Override
    // An empty heap merged with another heap is the other heap (identity).
    public IHeap merge(IHeap withHeap) {
        return withHeap;
    }


    /**
     * Checks to see if the size of the original heap and output heap are the same.
     * Empty heaps will not have the same size
     * @param elt
     * @param hAdded
     * @return boolean
     */
    @Override
    public boolean addedSameSize(int elt, IBinTree hAdded) {
        return false;
    }

    /**
     * Checks to see if the size of the original heap and the output heap are the same.
     * Empty heaps will not have the same size.
     * @param hRemoved
     * @return boolean
     */
    @Override
    public boolean removedSameSize(IBinTree hRemoved) {
        return false;
    }


}