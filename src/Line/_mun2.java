package Line;

import java.util.ArrayList;
import java.util.HashMap;

public class _mun2 {
    boolean[] cnt = new boolean[4];
    public int[] solution(String inp_str) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(!chk1(inp_str)) ret.add(1);
        if(!chk2(inp_str)) ret.add(2);
        if(!chk3()) ret.add(3);
        if(!chk4(inp_str)) ret.add(4);
        if(!chk5(inp_str)) ret.add(5);
        if(ret.size() == 0) ret.add(0);
        int[] ans = new int[ret.size()];
        int i = 0;
        for(int n : ret)
            ans[i++] = n;
        return ans;
    }

    boolean chk1(String s) {
        return s.length() >= 8 && s.length() <= 15;
    }

    boolean chk2(String s) {
        String special = "~!@#$%^&*";
        boolean ret = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'A' && c <= 'Z')) cnt[0] = true;
            else if((c >= 'a' && c <= 'z')) cnt[1] = true;
            else if(Character.isDigit(c)) cnt[2] = true;
            else {
                boolean flag = false;
                for (int j = 0; j < special.length(); j++)
                    if (special.charAt(j) == c) {
                        cnt[3] = true;
                        flag = true;
                        break;
                    }
                if(!flag) ret = false;
            }
        }
        return ret;
    }

    boolean chk3() {
        int sum = 0;
        for(int i = 0; i < 4; i++)
            if(cnt[i]) sum++;
        return sum >= 3;
    }

    boolean chk4(String s) {
        int cnt = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            if(cnt == 4) return false;
            if(s.charAt(i) == s.charAt(i + 1))
                cnt++;
            else {
                cnt = 1;
            }
        }
        return true;
    }

    boolean chk5(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int n : hm.values())
            if(n >= 5) return false;
        return true;
    }
}
