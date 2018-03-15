package fullJustify;

import java.util.LinkedList;
import java.util.List;

class Solution{
    public static List<String> fullJustify(String[] words, int maxWidth){
        List<String> result = new LinkedList<>();
        for(int i = 0, w; i <words.length; i = w){
            int len = -1;
            for(w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w ++)
                len += words[w].length() + 1;
            StringBuilder sb = new StringBuilder(words[i]);
            int space = 1;
            int extra = 0;
            if(w != i + 1 && w != words.length){
                space = (maxWidth - len) / (w - i - 1) + 1;
                extra = (maxWidth - len) % (w - i - 1);
            }
            for(int j = i + 1; j < w; j ++){
                for(int s = space; s > 0; s --)
                    sb.append(' ');
                if(extra-- > 0)
                    sb.append(' ');
                sb.append(words[j]);
            }
            int strLen = maxWidth - sb.length();
            while(strLen -- > 0)
                sb.append(' ');
            result.add(sb.toString());
        }
        return result;
    }
}

public class fullJustify {
    public static void main(String[] args){
        String[] words = {"This", "is", "an", "example", "of", "text", "justification"};
        System.out.print(Solution.fullJustify(words, 16));
    }
}
