import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* D : 2n / 2n > 9999, n = 2n % 10000
* S : n - 1 / n == 0, 9999
* L : n의 각 자릿수를 왼편으로 회전, 예) 1234 > 2341
* R : n의 각 자릿수를 오른편으로 회전, 예) 1234 > 4123
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());    // 초기값
            int b = Integer.parseInt(st.nextToken());    // 최종값
            String ans = bfs(a, b);
            System.out.println(ans);
        }
    }

    public static String bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] commands = new String[10000];
        queue.add(a);
        visited[a] = true;
        commands[a] = "";
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == b) {
                return commands[num];
            }
            // D, S, L, R에 맞는 수를 만들어 인덱스로 사용해서 만들어진 명령어 저장
            // D
            int d = (2 * num) % 10000;  
            if (!visited[d]) {
                visited[d] = true;
                queue.add(d);
                commands[d] = commands[num] + "D";
            }
            // S
            int s = num == 0 ? 9999 : num - 1;
            if (!visited[s]) {
                visited[s] = true;
                queue.add(s);
                commands[s] = commands[num] + "S";
            }
            // L
            int l = (num % 1000) * 10 + num / 1000;
            if (!visited[l]) {
                visited[l] = true;
                queue.add(l);
                commands[l] = commands[num] + "L";
            }
            // R
            int r = (num % 10) * 1000 + num / 10;
            if (!visited[r]) {
                visited[r] = true;
                queue.add(r);
                commands[r] = commands[num] + "R";
            }
        }
        return "";
    }
}
