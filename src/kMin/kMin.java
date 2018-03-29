package kMin;
//求无序数组中前k个小的数，时间复杂度O(n)
public class kMin {
    public static void main(String[] args){
        int[] num = {1, 3, 8 ,-2, 45, 8, 7};
        int k = 4;
        int left = 0;
        int right = num.length - 1;
        int index = -1;
        while(index != k - 1){
            index = partition(num, left, right);
            if(index > k - 1)
                right = index - 1;
            if(index < k - 1)
                left = index + 1;
            else break;
        }
        for(int i = 0; i < k; i ++)
            System.out.print(num[i] + "\t");
    }

    private static int partition(int[] num,int left, int right){
        int pos = right;
        right --;
        while(left < right){
            while(left < pos && num[left] <= num[pos])
                left ++;
            while(right > left && num[right] > num[pos])
                right --;
            if(left >= right)
                break;
            swap(num, left, right);
        }
        swap(num, left, pos);
        return left;
    }

    private static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

}
