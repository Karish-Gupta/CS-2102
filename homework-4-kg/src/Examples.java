import org.junit.Test;
import javax.xml.crypto.Data;
import static org.junit.Assert.*;


public class Examples {

    public Examples() {
    }

    HeapChecker HT = new HeapChecker();

    //Check for valid heap
    // myheap example1
    IHeap myHeap2 = new DataHeap(6, new MtHeap(), new MtHeap());
    IHeap myHeap1 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap myHeap = new DataHeap(3, myHeap1, myHeap2);


    // myBinTree example1 - valid binary tree
    IBinTree myBinTree = new DataBT(6, new MtBT(), new MtBT());
    IBinTree myBinTree1 = new DataBT(5, myBinTree, new MtBT());
    IBinTree myBinTree2 = new DataBT(4, new MtBT(), new MtBT());

    IBinTree myBinTree3 = new DataBT(3, myBinTree2, myBinTree1);


    @Test
    public void CheckAddedElt() {
        assertTrue(HT.addEltValidator(myHeap, 7, myHeap.addElt(7)));
    }

    @Test
    public void CheckValidHeap_Add() {
        assertTrue(HT.addEltValidator(myHeap, 5, myBinTree3));
    }



    //Check for invalid heap
    // myheap example2
    IHeap myHeap6 = new DataHeap(6, new MtHeap(), new MtHeap());
    IHeap myHeap5 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap myHeap4 = new DataHeap(3, myHeap5, myHeap6);


    // myBinTree example2 - invalid heap
    // invalid because the root node is greater than those below
    IBinTree myBinTree7 = new DataBT(3, new MtBT(), new MtBT());
    IBinTree myBinTree6 = new DataBT(5, myBinTree7, new MtBT());
    IBinTree myBinTree5 = new DataBT(4, new MtBT(), new MtBT());
    IBinTree myBinTree4 = new DataBT(6, myBinTree5, myBinTree6);

    @Test
    public void CheckInvalidTree_Add() {
        assertFalse(HT.addEltValidator(myHeap4, 5, myBinTree4));
    }



    //Check result where added elt is not present in the result
    // myheap example3
    IHeap myHeap9 = new DataHeap(6, new MtHeap(), new MtHeap());
    IHeap myHeap8 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap myHeap7 = new DataHeap(3, myHeap8, myHeap9);


    // myBinTree example3 - invalid heap
    // added elt is missing
    IBinTree myBinTree10 = new DataBT(6, new MtBT(), new MtBT());
    IBinTree myBinTree9 = new DataBT(4, new MtBT(), new MtBT());
    IBinTree myBinTree8 = new DataBT(3, myBinTree9, myBinTree10);

    @Test
    public void CheckAddedEltNotAdded_Add() {
        assertFalse(HT.addEltValidator(myHeap7, 5, myBinTree8));
    }



    //Checks result where (some of the) other elts are not present in the result
    // myheap example4

    IHeap myHeap13 = new DataHeap(7, new MtHeap(), new MtHeap());
    IHeap myHeap12 = new DataHeap(6, myHeap13, new MtHeap());
    IHeap myHeap11 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap myHeap10 = new DataHeap(3, myHeap11, myHeap12);


    // myBinTree example4 - invalid heap
    // some of the other elts are not in result
    IBinTree myBinTree13 = new DataBT(5, new MtBT(), new MtBT());
    IBinTree myBinTree12 = new DataBT(4, new MtBT(), new MtBT());
    IBinTree myBinTree11 = new DataBT(3, myBinTree12, myBinTree13);

    @Test
    public void CheckAddedSomeEltsNotPresent_Add() {
        assertFalse(HT.addEltValidator(myHeap10, 5, myBinTree11));
    }


    //Check result with extraneous elements
    // myheap example5
    IHeap myHeap16 = new DataHeap(12, new MtHeap(), new MtHeap());
    IHeap myHeap15 = new DataHeap(10, new MtHeap(), new MtHeap());
    IHeap myHeap14 = new DataHeap(7, myHeap15, myHeap16);


    // myBinTree example5 - Inlavid heap
    // extraneous elements present
    IBinTree myBinTree18 = new DataBT(16, new MtBT(), new MtBT());
    IBinTree myBinTree17 = new DataBT(15, new MtBT(), new MtBT());
    IBinTree myBinTree16 = new DataBT(12, myBinTree17, myBinTree18);
    IBinTree myBinTree15 = new DataBT(10, new MtBT(), new MtBT());
    IBinTree myBinTree14 = new DataBT(7, myBinTree15, myBinTree16);

    @Test
    public void CheckExtraneousElt_Add() {
        assertFalse(HT.addEltValidator(myHeap14, 15, myBinTree14));
    }



    // Tests for RemoveValidator



    //Check for valid heap
    // heap example1 - valid heap
    IHeap heap2 = new DataHeap(6, new MtHeap(), new MtHeap());
    IHeap heap1 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap heap = new DataHeap(3, heap1, heap2);

    IBinTree binTree0 = new DataBT(6, new MtBT(), new MtBT());
    IBinTree binTree00 = new DataBT(4, binTree0, new MtBT());


    @Test
    public void CheckValidTree_Remove() {
        assertTrue(HT.remMinEltValidator(heap, binTree00));
    }


    //Check for invalid heap
    // heap example2
    IHeap heap5 = new DataHeap(6, new MtHeap(), new MtHeap());
    IHeap heap4 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap heap3 = new DataHeap(3, heap, heap2);

    // binary tree example2 - invalid heap
    // root node is greater than the child node

    IBinTree binTree1 = new DataBT(4, new MtBT(), new MtBT());
    IBinTree binTree = new DataBT(6, binTree1, new MtBT());

    @Test
    public void CheckInvalidTree_Remove() {
        assertFalse(HT.remMinEltValidator(heap, binTree));
    }



    //Check for result where removed elt is present in the result
    // heap example3
    IHeap heap8 = new DataHeap(6, new MtHeap(), new MtHeap());
    IHeap heap7 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap heap6 = new DataHeap(3, heap7, heap8);

    // binary tree example3 - invalid heap
    // removed elt is still present

    IBinTree binTree4 = new DataBT(6, new MtBT(), new MtBT());
    IBinTree binTree3 = new DataBT(4, new MtBT(), new MtBT());
    IBinTree binTree2 = new DataBT(3, binTree3, binTree4);

    @Test
    public void CheckEltStillPresent_Remove() {
        assertFalse(HT.remMinEltValidator(heap6, binTree2));
    }



    //Check for result where (some of the) other elts are not present in the result
    // heap example4
    IHeap heap12 = new DataHeap(7, new MtHeap(), new MtHeap());
    IHeap heap11 = new DataHeap(6, heap12, new MtHeap());
    IHeap heap10 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap heap9 = new DataHeap(3, heap10, heap11);

    // binary tree example4 - invalid heap
    // some of the other elts are not present


    IBinTree binTree6 = new DataBT(6, new MtBT(), new MtBT());
    IBinTree binTree5 = new DataBT(3, new MtBT(), binTree6);

    @Test
    public void CheckSomeOtherEltsNotPresent_Remove() {
        assertFalse(HT.remMinEltValidator(heap9, binTree5));
    }



    //Check for result with extraneous elements
    // heap example5
    IHeap heap15 = new DataHeap(6, new MtHeap(), new MtHeap());
    IHeap heap14 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap heap13 = new DataHeap(3, heap14, heap15);

    // binary tree example5 - invalid heap
    // result has extraneous elements

    IBinTree binTree10 = new DataBT(10, new MtBT(), new MtBT());

    IBinTree binTree9 = new DataBT(8, binTree10, new MtBT());
    IBinTree binTree8 = new DataBT(6, new MtBT(), new MtBT());
    IBinTree binTree7 = new DataBT(3, binTree8, binTree9);

    @Test
    public void CheckExtraneousElts_Remove() {
        assertFalse(HT.remMinEltValidator(heap13, binTree7));

    }



}