import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer a = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(a.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (set.contains(Integer.parseInt(b.nextToken()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}