package Line;

import java.util.HashMap;

public class _mun7 {
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];
        int idx = 0;
        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, String> alias = new HashMap<>();
        for(String s : flag_rules) {
            String[] rule = s.split(" ");
            if(rule[1].equals("ALIAS")) {
                alias.put(rule[0].substring(1), rule[2].substring(1));
                alias.put(rule[2].substring(1), rule[0].substring(1));
            } else {
                hm.put(rule[0].substring(1), rule[1]);
            }
        }

        for(String s : commands) {
            HashMap<String, Boolean> overlap = new HashMap<>();
            String[] command = s.split("-");
            String prog = command[0].trim();
            boolean chk = true;
            if(!prog.equals(program)) chk = false;
            for(int i = 1; i < command.length; i++) {
                String[] tmp = command[i].split(" ");
                String con;
                if(hm.containsKey(tmp[0])) {
                    con = hm.get(tmp[0]);
                } else {
                    con = hm.get(alias.get(tmp[0]));
                }
                overlap.put(tmp[0], true);
                if(overlap.containsKey(alias.get(tmp[0])) && overlap.get(alias.get(tmp[0])))
                    chk = false;
                switch(con) {
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
