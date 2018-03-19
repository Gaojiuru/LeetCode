package simplifyPath;

import java.util.LinkedList;

class Solution{
    public static String simplifyPath(String path){
        LinkedList<String> stack = new LinkedList<String>();
        StringBuilder sb = new StringBuilder("/");
        for(String p : path.split("/")){
            if(p.equals("..")) {
                if (!stack.isEmpty())
                    stack.removeLast();
            }
            else if(!p.equals("") && !p.equals("."))
                stack.add(p);
        }
        for(String s: stack)
            sb.append(s + "/");
        if(!stack.isEmpty()) sb.setLength(sb.length()-1);
        return sb.toString();
    }
}

public class simplifyPath {
    public static void main(String[] args){
        System.out.println(Solution.simplifyPath("/.."));
    }
}
