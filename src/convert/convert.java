package convert;

class Solution{
    public static String convert(String s, int numRows){
        if(s.length() == 0 || numRows < 2)
            return s;
        String str = "";
        int add = 2 * numRows - 2;
        for(int i = 0; i < numRows; i ++)
            for (int j = i; j < s.length(); j += add){
                str += s.charAt(j);

                if (i > 0 && i < numRows - 1) {
                    int k = j + add - 2 * i;
                    if(k < s.length())
                        str += s.charAt(k);
                }
            }
        return str;
    }
}

public class convert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int n = 3;
        String str = Solution.convert(s, n);
        System.out.println(str);
    }
}
