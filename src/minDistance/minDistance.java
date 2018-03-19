package minDistance;

class Solution{
    public static int minDistance(String word1, String word2){
        if(word1.length() == 0 && word2.length() == 0)
            return 0;
        if(word1.length() == 0  && word2.length() > 0)
            return word2.length();
        if(word1.length() > 0 && word2.length() == 0)
            return word1.length();

        int[][] cost = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1; i <= word1.length(); i ++)
            cost[i][0] = i;
        for(int i = 1; i <= word2.length(); i ++)
            cost[0][i] = i;
        for(int i = 1; i <= word1.length(); i ++)
            for(int j = 1; j <= word2.length(); j ++)
                cost[i][j] = Math.min(Math.min(cost[i - 1][j] + 1, cost[i][j - 1] + 1), word1.charAt(i - 1) == word2.charAt(j - 1) ? cost[i - 1][j - 1] : cost[i - 1][j - 1] + 1);
        return cost[word1.length()][word2.length()];
    }
}

public class minDistance {
    public static void main(String[] args){
        String word1 = "pneumonoultramicroscopicsilicovolcanoconiosis";
        String word2 = "ultramicroscopically";
        System.out.println(Solution.minDistance(word1, word2));
    }
}
