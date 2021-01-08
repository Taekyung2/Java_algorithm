package ssafy_repeat;

import java.util.Arrays;
import java.util.Scanner;

public class Prim_repeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adj = new int[V][V];

        for(int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a][b] = c;
            adj[b][a] = c;
        }
        boolean[] check = new boolean[V];
        int[] key = new int[V]; // 현재 선택된 정점들로부터 도달할 수 있는 최소 거리
        int[] p = new int[V]; // 최소 신장 트리의 구조를 저장할 배열

        Arrays.fill(key, Integer.MAX_VALUE);

        // 아무거나 하나 선택
        p[0] = -1;
        key[0] = 0;

        // 이미 하나 골랐으니 나머지 V - 1개를 골라보자
        for(int i = 0; i < V - 1; i++) {
            int min = Integer.MAX_VALUE;
            // 안골라진 친구들 중에서 key가 가장 작은 친구를 뽑자
            int index = -1;
            for(int j = 0; j < V; j++) {
                if(!check[j] && key[j] < min) {
                    index = j;
                    min = key[j];
                }
            }
            // index : 선택이 안된 정점 중 key가 젤 작은 친구가 들어있겠지
            check[index] = true;
            // index 정점에서 출발하는 모든 간선에 대해서 key를 업데이트
            for(int j = 0; j < V; j++) {
                // check가 안되있으면서, 간선은 존재하고, 그 간선이 key값보다 작다면, key값을 업데이트
                if(!check[j] && adj[index][j] != 0 && key[j] > adj[index][j]) {
                    p[j] = index;
                    key[j] = adj[index][j];
                }
            }
        }
        int result = 0;
        for(int i = 0; i < V; i++)
            result += key[i];
        System.out.println(result);
        System.out.println(Arrays.toString(p));
    }
}