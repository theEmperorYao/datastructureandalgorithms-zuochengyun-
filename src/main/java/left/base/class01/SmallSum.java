package left.base.class01;

import java.util.Arrays;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月23日 15:42:00
 */
public class SmallSum {

    public static int smallSum(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return mergesort(arr,0,arr.length-1);

    }
    public static int mergesort(int[] arr,int left,int right){
        if (left==right){
            return 0;
        }

        int mid =left+((right-left)>>1);
        return mergesort(arr,left,mid)+
                mergesort(arr,mid+1,right)+
                merge(arr,left,mid,right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {

        int p1=left;
        int p2=mid+1;
        int[] help=new int[right-left+1];
        int i=0;
        int smallSum=0;
        while (p1<=mid&&p2<=right){
            smallSum+=arr[p1]<arr[p2]?arr[p1]*(right-p2+1):0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
//            if (arr[p1]<arr[p2]){
//                smallSum+=arr[p1]*(right-p2+1);
//                help[i++]=arr[p1++];
//            }else {
//                help[i++]=arr[p2++];
//            }
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=right){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left+j]=help[j];
        }
        return smallSum;
    }


//    public static void main(String[] args) {
//        int[] arr={3,6,7,2,1,5,8};
//        int mergesort = mergesort(arr);
//        System.out.println("mergesort = " + mergesort);
//        Arrays.stream(arr).forEach(x-> System.out.print(x+","));
//
//    }
// for test
public static int comparator(int[] arr) {
    if (arr == null || arr.length < 2) {
        return 0;
    }
    int res = 0;
    for (int i = 1; i < arr.length; i++) {
        for (int j = 0; j < i; j++) {
            res += arr[j] < arr[i] ? arr[j] : 0;
        }
    }
    return res;
}

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
