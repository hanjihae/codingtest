import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int sum = 0;
        for (int i=1; i <= n; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }
        StringBuilder sb = new StringBuilder();
        for (int num=0; num < m; num++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken());
            sb.append(arr[j]-arr[i]+"\n");
        }
        System.out.println(sb);
    }
}
