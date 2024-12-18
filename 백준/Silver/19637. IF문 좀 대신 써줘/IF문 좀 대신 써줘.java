import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m, max;
    static String[] names;
    static int[] standards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 칭호 개수
        m = Integer.parseInt(st.nextToken());   // 캐릭터 수
        names = new String[n];
        standards = new int[n];
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            standards[i] = Integer.parseInt(st.nextToken());

        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < m; i++) {
            int character = Integer.parseInt(br.readLine());
            String ans = binarySearch(character);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static String binarySearch(int target) {
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (standards[mid] >= target) { // 타겟이 현재 기준보다 작거나 같다면
                end = mid - 1;
            } else {    // 타겟이 현재 기준보다 크다면
                start = mid + 1;
            }
        }
        return names[start];
    }
}
