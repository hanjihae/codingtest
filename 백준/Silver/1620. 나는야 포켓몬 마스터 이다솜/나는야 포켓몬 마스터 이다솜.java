import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> poketmon = new HashMap<>();
        String[] arr = new String[n+1];
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            poketmon.put(name, i);
            arr[i] = name;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < m; i++) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                int x = Integer.parseInt(input);
                sb.append(arr[x] + "\n");
            } else {
                sb.append(poketmon.get(input) + "\n");
            }
        }
        System.out.println(sb);
    }
}
