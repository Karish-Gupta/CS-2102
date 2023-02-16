import java.util.Random;

/**
 * A specialized binary tree where the root node is always less than the child nodes.
 * DataHeap contains data in the form of integer values.
 */
public class DataHeap extends DataBT implements IHeap {
    IHeap left;
    IHeap right;

    DataHeap(int data, IHeap left, IHeap right) {
        super(data, left, right);
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subheaps are empty
    DataHeap(int data) {
        super(data);
        this.left = new MtHeap();
        this.right = new MtHeap();
    }

    public IHeap merge(IHeap withHeap) {
        int newRoot;
        IHeap H1, H2, H3;
        // make sure withHeap isn't empty
        // we'd rather not use instanceOf here, but it makes the merge algorithm easier to see
        if (withHeap instanceof MtHeap) {
            return this;
        }
        // determine the new root value and the three subtrees to consider merging
        else if (withHeap.isBigger(this.data)) {
            newRoot = this.data;
            H1 = this.left;
            H2 = this.right;
            H3 = withHeap;
        } else {
            // Since a MtHeap will always return true on isBigger, satisfying
            //  the first condition, we know that withHeap is a DataHeap.
            //  Therefore, we can cast it.
            newRoot = ((DataHeap) withHeap).data;
            H1 = ((DataHeap) withHeap).left;
            H2 = ((DataHeap) withHeap).right;
            H3 = this;
        }

        // choose which trees to merge and construct the new tree
        if (H1.height() > H2.height() && H1.height() > H3.height()) {
            return new DataHeap(newRoot, H1, H2.merge(H3));
        } else if (H2.height() > H1.height() && H2.height() > H3.height()) {
            return new DataHeap(newRoot, H2, H1.merge(H3));
        } else if (H3.height() > H1.height() && H3.height() > H2.height()) {
            return new DataHeap(newRoot, H3, H1.merge(H2));
        } else {
            // If the two bigger heaps are of the same size, choose one at random.
            Random coinFlip = new Random();
            if (H1.height() == H2.height()) {
                if (coinFlip.nextInt() % 2 == 1) {
                    return new DataHeap(newRoot, H1, H2.merge(H3));
                } else {
                    return new DataHeap(newRoot, H2, H1.merge(H3));
                }
            } else if (H2.height() == H3.height()) {
                if (coinFlip.nextInt() % 2 == 1) {
                    return new DataHeap(newRoot, H2, H3.merge(H1));
                } else {
                    return new DataHeap(newRoot, H3, H2.merge(H1));
                }
            } else {
                if (coinFlip.nextInt() % 2 == 1) {
                    return new DataHeap(newRoot, H3, H1.merge(H2));
                } else {
                    return new DataHeap(newRoot, H1, H3.merge(H2));
                }
            }
        }
    }

    @Override
    public IHeap addElt(int e) {
        return this.merge(new DataHeap(e, new MtHeap(), new MtHeap()));
    }

    @Override
    public IHeap remMinElt() {
        return this.right.merge(this.left);
    }
    @Override
    public boolean isBigger(int e) {
        return (this.data >= e);
    }

    /**
     * Checks to see if the size of the original heap and the output heap are the same.
     * Adds one to size of original heap to check if that is equal to output heap.
     * @param elt
     * @param hAdded
     * @return boolean
     */
    @Override
    public boolean addedSameSize(int elt, IBinTree hAdded) {
        return this.size() + 1 == hAdded.size();
    }

    /**
     * Checks to see if the size of the original heap and the output heap are the same.
     * Subtracts one from size of original heap to check if that is equal to output heap.
     * @param hRemoved
     * @return boolean
     */
    @Override
    public boolean removedSameSize(IBinTree hRemoved) {
        return this.size() - 1 == hRemoved.size();
    }

}