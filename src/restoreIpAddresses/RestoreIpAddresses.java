package restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12)
            return res;
        IpAddresses(s.toCharArray(), 0, 0, new char[s.length() + 3], 0, 0, res);
        return res;
    }

    private void IpAddresses(char[] ch, int prev, int pos, char[] ip, int ip_pos, int dot, List<String> ls){
        if(pos >= ch.length)
            return;
        if(dot == 3) {
            if (ch[pos] == '0' && pos < ch.length - 1)
                return;
            for (int i = pos; i < ch.length; i++)
                prev = prev * 10 + ch[i] - '0';
            if (prev < 256)
                ls.add(new String(ip, 0, ip_pos) + Integer.toString(prev));
            return;
        }

        int num = ch[pos] - '0';
        int cur = prev * 10 + num;
        if(cur == 0){
            ip[ip_pos ++] = ch[pos];
            ip[ip_pos ++] = '.';
            dot ++;
            IpAddresses(ch, 0, pos + 1, ip, ip_pos, dot, ls);
        } else{
            if(cur < 256){
                ip[ip_pos ++] = ch[pos];
                IpAddresses(ch, cur, pos + 1, ip, ip_pos, dot, ls);
                ip_pos --;
            }
            if(prev > 0){
                ip[ip_pos ++] = '.';
                dot ++;
                IpAddresses(ch, 0, pos, ip, ip_pos, dot, ls);
            }
        }
    }
}

public class RestoreIpAddresses {
    public static void main(String[] args){
        String s = "25525511135";
        System.out.println(new Solution().restoreIpAddresses(s));
    }
}
