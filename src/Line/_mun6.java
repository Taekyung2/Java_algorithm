package Line;

import java.util.HashMap;

public class _mun6 {
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
                        if(tmp.length != 2) chk = false;
                        for(int j = 0; j < tmp[1].length(); j++)
                            if (!(tmp[1].charAt(j) >= 'A' && tmp[1].charAt(j) <= 'Z') && !(tmp[1].charAt(j) >= 'a' && tmp[1].charAt(j) <= 'z')) {
                                chk = false;
                            }
                        break;
                    }
                    case "NUMBER" : {
                        if(tmp.length != 2) chk = false;
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
                    case "NUMBERS" : {
                        for(int c = 1; c < tmp.length; c++) {
                            for(int j = 0; j < tmp[c].length(); j++) {
                                if (!Character.isDigit(tmp[c].charAt(j))) {
                                    chk = false;
                                }
                            }
                        }
                        break;
                    }
                    case "STRINGS" : {
                        for(int c = 1; c < tmp.length; c++) {
                            for(int j = 0; j < tmp[c].length(); j++)
                                if (!(tmp[c].charAt(j) >= 'A' && tmp[c].charAt(j) <= 'Z') && !(tmp[c].charAt(j) >= 'a' && tmp[c].charAt(j) <= 'z')) {
                                    chk = false;
                                }
                        }
                        break;
                    }
                }
            }
            answer[idx++] = chk;
        }
        return answer;
    }
}
