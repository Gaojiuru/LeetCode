package wordSearch;

class Solution{
    public boolean exist(char[][] board, String word){
        char[] w = word.toCharArray();
        for(int x = 0; x < board.length; x ++){
            for(int y = 0; y < board[x].length; y ++){
                if(exist(board, x, y, w, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, char[] w, int i){
        if(i == w.length)
            return true;
        if(x < 0 || y < 0 || x == board.length || y == board[x].length)
            return false;
        if(board[x][y] != w[i])
            return false;
        board[x][y] ^= 256;
        boolean exist = exist(board, x + 1, y, w, i + 1) ||
                exist(board, x - 1, y, w, i + 1) ||
                exist(board, x, y + 1, w, i + 1) ||
                exist(board, x, y - 1, w, i + 1);
        board[x][y] ^= 256;
        return exist;
    }
}

public class wordSearch {
    public static void main(String[] args){
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        //char[][] board = {{'b'}, {'a'}, {'b'}};
        String word = "ABCCED";
        System.out.println(new Solution().exist(board, word));
    }
}
