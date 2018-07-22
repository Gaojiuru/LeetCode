package ladderLength;
/*leetcode 127
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord toendWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.*/

import java.util.*;

class Solution2{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        Map<String,Integer> map = new HashMap();
        map.put(beginWord,1);
        if(!wordList.contains(endWord)) return 0;
        if(wordList.contains(beginWord)) wordList.remove(beginWord);

        while(!queue.isEmpty()){
            String word = queue.poll();
            int level = map.get(word);
            for(int i = 0;i < word.length(); i ++){
                for(char ch = 'a'; ch <= 'z';ch ++){
                    char[] tempWord = word.toCharArray();
                    tempWord[i] = ch;
                    String cur = new String(tempWord);
                    if(word == cur) continue;
                    if(cur.equals(endWord)) return level + 1;
                    if(wordList.contains(cur)){
                        queue.offer(cur);
                        wordList.remove(cur);
                        map.put(cur,level + 1);
                    }
                }
            }
        }
        return 0;
    }
}

class Solution{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return step + 1;
                        }
                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }
}

public class LadderLength {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordDict = new ArrayList<>();
        //wordDict.add("a");
        //wordDict.add("b");
        //wordDict.add("c");
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("lot");
        wordDict.add("log");
        //wordDict.add("cog");
        System.out.println(new Solution2().ladderLength(beginWord, endWord, wordDict));
    }
}