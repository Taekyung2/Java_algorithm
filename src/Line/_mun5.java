package Line;

import java.util.HashMap;

public class _mun5 {
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];
        int idx = 0;
        HashMap<String, String> hm = new HashMap<>();
        for(String s : flag_rules) {
            String[] rule = s.split(" ");
            hm.put(rule[0].substring(1), rule[1]);
        }

        for(String s : commands) {
            String[] command = s.split("-");
            String prog = command[0].trim();
            boolean chk = true;
            if(!prog.equals(program)) chk = false;
            for(int i = 1; i < command.length; i++) {
                String[] tmp = command[i].split(" ");
                switch(hm.get(tmp[0])) {
                    case "STRING" : {
                        for(int j = 0; j < tmp[1].length(); j++)
                            if (!(tmp[1].charAt(j) >= 'A' && tmp[1].charAt(j) <= 'Z')) {
                                chk = false;
                            }
                        break;
                    }
                    case "NUMBER" : {
                        for(int j = 0; j < tmp[1].length(); j++)
                            if (!Character.isDigit(tmp[1].charAt(j))) {
                                chk = false;
                            }
                        break;
                    }
                    case "NULL" : {
                        chk = tmp.length == 1;
                        break;
                    }
                }
            }
            answer[idx++] = chk;
        }
        return answer;
    }
}
