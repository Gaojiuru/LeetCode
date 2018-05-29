package maxRectangle;

class Solution{
    public int maximalRectangle(char[][] matrix){
        int result = 0;
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] heights = new int[n];
        for(int i = 0; i < n; i ++){
            left[i] = 0;
            right[i] = n;
            heights[i] = 0;
        }

        for(int i = 0; i < matrix.length; i ++){
            int cur_left = 0;
            int cur_right = n;
            for(int j = 0; j < n; j ++){
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                    heights[j]++;
                }
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                    heights[j] = 0;
                }
            }

            for(int j = n - 1; j >=0; j --){
                if(matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else{
                    right[j] = n;
                    cur_right = j;
                }
            }

            for(int j = 0; j < n; j ++)
                result = Math.max(result, (right[j] - left[j]) * heights[j]);
        }
        return result;
    }
}

public class MaximalRectangle {
    public static void main(String[] args){
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}
