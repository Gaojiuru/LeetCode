package isPalidrome;

class Solution{
    public static boolean isPalindrome(int x){
        int convert = 0;
        int a = x;
        if(x < 0)
            return false;
        while(a > 0){
            convert = convert * 10 + a % 10;
            a /= 10;
        }

        return x == convert;
    }
}

public class isPalidrome {
    public static void main(String[] args) {
        int x = 27654;
        System.out.println(Solution.isPalindrome(x));
    }
}
