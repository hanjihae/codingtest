import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] num;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        visited = new boolean[n];
        dfs(0, visited);
        System.out.println(sb);
    }

    public static void dfs(int index, boolean[] visited) {
        if(index == m) {
            for(int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i < n; i++) {
            if(visited[i]) continue;    // 중복되는 경우 제외
            arr[index] = num[i];
            visited[i] = true;
            dfs(index+1, visited);
            visited[i] = false;
        }
    }
}
