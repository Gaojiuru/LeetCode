package largestRectangleArea;

import java.util.Stack;

class Solution{
    public int largestRectangleArea(int[] heights){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i ++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int res = height * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                result = Math.max(result, res);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int res = height * (stack.isEmpty() ? heights.length : (heights.length - stack.peek() - 1));
            result = Math.max(result, res);
        }
        return result;
    }
}

public class LargestRectangleArea {
    public static void main(String[] args){
        //int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {2, 3};
        //int[] heights = {1, 2, 3, 4, 5, 6};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}
