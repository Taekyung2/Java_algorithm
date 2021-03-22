package Line;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _mun4 {
    class Node {
        int id, parent;
        String name;
        Node(int id, String name, int parent) {
            this.id = id;
            this.name = name;
            this.parent = parent;
        }
    }
    class Path {
        int id;
        StringBuilder sb;
        Path(int id, StringBuilder sb) {
            this.id = id;
            this.sb = sb;
        }
    }
    public String[] solution(String[] data, String word) {
        int n = data.length;
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        Node[] arr = new Node[n + 1];
        for(int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for(String str : data) {
            String[] s = str.split(" ");
            Node node = new Node(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]));
            arr[node.id] = node;
            adj[node.parent].add(node.id);
        }
        ArrayList<String> ret = new ArrayList<>();
        Queue<Path> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        Path root = new Path(0, new StringBuilder());
        q.add(root);
        visited[0] = true;
        while(!q.isEmpty()) {
            Path cur = q.poll();
            if(adj[cur.id].size() == 0) {
                if(arr[cur.id].name.contains(word)) {
                    ret.add(cur.sb.toString());
                }
            }
            for(int next : adj[cur.id]) {
                if(visited[next]) continue;
                visited[next] = true;
                Path nextPath = new Path(next, new StringBuilder(cur.sb).append(arr[next].name).append("/"));
                q.add(nextPath);
            }
        }
        String[] ans = new String[ret.size()];
        int i = 0;
        for(String s : ret) {
            ans[i++] = s;
        }
        return ans;
    }
}
