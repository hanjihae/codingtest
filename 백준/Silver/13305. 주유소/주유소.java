import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[n - 1];
        for (int i=0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] oil = new int[n];
        for (int i=0; i < n; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }
        long total = 0;
        long minPrice = oil[0]; // 가장 싼 기름값
        for (int i=0; i < n - 1; i++) {
            minPrice = Math.min(oil[i], minPrice);
            total += minPrice * dist[i];
        }
        System.out.println(total);
    }
}
