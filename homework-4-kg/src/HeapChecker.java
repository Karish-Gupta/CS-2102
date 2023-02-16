/**
 * Class that contains methods to check if output binary trees are valid heaps.
 */
public class HeapChecker {

    /**
     * Takes in a heap, an integer, and an output heap, and returns true if the output heap has added
     * the given integer value and is a heap.
     *
     * @param hOrig
     * @param elt
     * @param hAdded
     * @return boolean
     */
    public boolean addEltValidator(IHeap hOrig, int elt, IBinTree hAdded) {

        //Is this a heap
        //Is root smaller than the rest of the heap
        //Is each subtree also a heap
        if (!hAdded.isHeap()) {
            return false;
        }

        //Does the result contain all the elements from the original heap
        if (!hOrig.hasAllElt(hAdded)) {
            return false;
        }

        //Has the new element been added
        if (!hAdded.hasNewEltAdded(elt)) {
            return false;
        }

        //No elements in the result were not in the original
        //By testing that the size is the same, we are ensuring that more than 1 value is not added into the new binary tree
        if (!hOrig.addedSameSize(elt, hAdded)) {
            return false;
        }

        return true;
    }

    /**
     * Takes in a heap, an integer, and an output heap, and returns true if the output heap has removed
     * the given integer value and is a heap.
     *
     * @param hOrig
     * @param hRemoved
     * @return boolean
     */
    public boolean remMinEltValidator(IHeap hOrig, IBinTree hRemoved) {

        //Is this a heap
        //Is root smaller than the rest of the heap
        //Is each subtree also a heap
        if (!hRemoved.isHeap()) {
            return false;
        }


        //Does the result contain all the elements from the original heap
        if (!hOrig.hasAllEltRem(hRemoved)) {
            return false;
        }



        //Has the element been removed
        if (!hOrig.hasMinEltRemoved(hRemoved)) {
            return false;
        }


        //No elements in the result that were not in original
        //By testing that the size is the same, we are ensuring that more than 1 value is not added into the new binary tree
        if (!hOrig.removedSameSize(hRemoved)) {
            return false;
        }
        return true;
    }


}

