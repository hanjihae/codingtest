import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> heardX = new HashSet<>();
        for (int i=0; i < n; i++) { // 듣도 못한 사람
            heardX.add(br.readLine());
        }
        Set<String> xx = new TreeSet<>();   // 사전순 정렬
        for (int i=0; i < m; i++) { // 보도 못한 사람
            String input = br.readLine();
            if (heardX.contains(input)) {   // 듣도 못한 사람과 동일하면
                xx.add(input);
            }
        }
        System.out.println(xx.size());
        for (String s : xx) {
            System.out.println(s);
        }
    }
}
