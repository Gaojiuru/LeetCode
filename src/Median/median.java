package Median;
//无序数组的中位数


import java.util.PriorityQueue;

//快速中位数
class Solution1{
    public static int median(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int start = 0;
        int end = array.length - 1;
        int midIndex = end / 2;
        int index = -1;
        while(index != midIndex){
            index = Partition(array, start, end);
            if(index < midIndex)
                start = index + 1;
            else if(index > midIndex)
                end = index - 1;
            else break;
        }
        return array[index];
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int Partition(int[] array, int start, int end){
        if(start > end)
            return -1;
        int pos = end;
        end --;
        while(start <= end){
            while(start < pos && array[start] <= array[pos])
                start ++;
            while(end > start && array[end] >= array[pos])
                end --;
            if(start >= end)
               break;
            swap(array, start, end);
        }
        swap(array, start, pos);
        return start;

    }
}

//构建最小堆
class Solution2{
    public static double median(int[] array){
        int heapSize = array.length / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for(int i = 0; i < heapSize; i ++)
            heap.add(array[i]);
        for(int i = heapSize; i < array.length; i ++){
            if(heap.peek() < array[i]){
                heap.poll();
                heap.add(array[i]);
            }
        }
        if(array.length % 2 == 1)
            return (double)heap.peek();
        else
            return (double)(heap.poll() + heap.peek()) / 2.0;
    }
}

public class median {
    public static void main(String[] args){
        int[] array = {5, 3, 10, 7, 9, 2, 7};
        System.out.println(Solution1.median(array));
        System.out.println(Solution2.median(array));
    }
}
