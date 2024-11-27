import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        result = new int[n];
        backtracking(0);
        System.out.println(sb);
    }

    public static void backtracking(int depth) {
        if (depth == n) {
            for (int i=0; i < n; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
