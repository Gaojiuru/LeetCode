package searchMatrix;

class Solution{
    public static boolean searchMtrix(int[][] matrix, int target){
        if(matrix.length == 0)
            return false;
        if(matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while(l != r){
            int mid = (l + r - 1) / 2;
            if (matrix[mid / n][mid % n] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return matrix[r / n][r % n] == target;
    }
}

public class searchMatrix {
    public static void main(String[] args){
        int[][] matrix = {{}};
        System.out.println(Solution.searchMtrix(matrix, 22));
    }
}
