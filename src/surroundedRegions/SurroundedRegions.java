package surroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/*leetcode 130
Given a 2D board conta-ining 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
*/

class Node{
    int row;
    int col;
    Node(int i, int j){
        row = i;
        col = j;
    }
}

class Solution{
    public void solve(char[][] board){
        if(board.length <= 0)
            return;
        if(board[0].length <= 0)
            return;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queque = new LinkedList<>();
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                visited[i][j] = false;
        //第一行和最后一行
        for(int col = 0; col < n; col ++) {
            if (board[0][col] == 'O')
                queque.offer(new Node(0, col));
            if (board[m - 1][col] == 'O')
                queque.offer(new Node(m - 1, col));
        }
        //第一列和最后一列
        for(int row = 0; row < m; row ++){
            if(board[row][0] == 'O')
                queque.offer(new Node(row, 0));
            if(board[row][n - 1] == 'O')
                queque.offer(new Node(row, n - 1));
        }

        while(!queque.isEmpty()){
            Node temp = queque.poll();
            int row = temp.row;
            int col = temp.col;
            if(visited[row][col] == true)
                continue;
            visited[row][col] = true;
            if(row + 1 < m && board[row + 1][col] == 'O' && visited[row + 1][col] == false)
                queque.offer(new Node(row + 1, col));
            if(row - 1 >= 0 && board[row - 1][col] == 'O' && visited[row - 1][col] == false)
                queque.offer(new Node(row - 1, col));
            if(col + 1 < n && board[row][col + 1] == 'O' && visited[row][col + 1] == false)
                queque.offer(new Node(row, col + 1));
            if(col - 1 >= 0 && board[row][col - 1] == 'O' && visited[row][col - 1] == false)
                queque.offer(new Node(row, col - 1));
        }

        for(int row = 0; row < m; row ++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'O' && visited[row][col] == false)
                    board[row][col] = 'X';
            }
        }

        for(int row = 0; row < m; row ++){
            for(int col = 0; col < n; col ++)
                System.out.print(board[row][col] + " ");
            System.out.println();
        }
    }
}
public class SurroundedRegions {
    public static void main(String[] args){
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        new Solution().solve(board);
    }
}