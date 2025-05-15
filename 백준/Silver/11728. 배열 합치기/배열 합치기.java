import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        String arr1 = br.readLine();
        String arr2 = br.readLine();
        st = new StringTokenizer(arr1);
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(arr2);
        for (int i = 0; i < m; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb);
    }
}
