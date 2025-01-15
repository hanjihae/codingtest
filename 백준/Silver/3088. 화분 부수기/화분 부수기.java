import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        StringTokenizer st;
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 이미 있는 번호와 다른 번호만 들어온다 == 직접 깨야하는 화분 개수 증가
            if (!set.contains(a) && !set.contains(b) && !set.contains(c)) {
                cnt++;
            }
            set.add(a);
            set.add(b);
            set.add(c);
        }
        System.out.println(cnt);
    }
}
