//package left.base.class01;
//
//import left.base.class02.Code03_RadixSort;
//import left.baseCopy.test.Code_05_QuickSort;
//import left.baseCopy.test.Code_06_HeapSort;
//
//
///**
// * @Classname SortTest
// * @Description TODO
// * @Date 2021/8/15 3:01 下午
// * @Created by tangyao
// */
//public class SortTest {
//    public static void main(String[] args) {
//        long l = System.nanoTime();
//        SortlogarithmUtils.sort(Code_00_BubbleSort::bubbleSort);
//        long l1 = System.nanoTime();
//        System.out.println("bubbleSort = " + (l1 - l));
//        SortlogarithmUtils.sort(Code_01_InsertionSort::insertionSort);
//        long l2 = System.nanoTime();
//        System.out.println("insertionSort = " + (l2 - l1));
//        SortlogarithmUtils.sort(Code_02_SelectionSort::selectionSort);
//        long l3 = System.nanoTime();
//        System.out.println("selectionSort= " + (l3 - l2));
//        SortlogarithmUtils.sort(Code_06_HeapSort::heapSort);
//        long l4 = System.nanoTime();
//        System.out.println("heapSort= " + (l4 - l3));
//        SortlogarithmUtils.sort(Code_05_QuickSort::quickSort);
//        long l5 = System.nanoTime();
//        System.out.println("quickSort = " + (l5 - l4));
//        SortlogarithmUtils.sort(Code_03_MergeSort::mergeSort);
//        long l6 = System.nanoTime();
//        System.out.println("mergeSort = " + (l6 - l5));
//        SortlogarithmUtils.sort(Code03_RadixSort::radixSort);
//        long l7 = System.nanoTime();
//        System.out.println("radixSort = " + (l7 - l6));
//
//    }
//}
