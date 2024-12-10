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
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i < n; i++) {
            String str = br.readLine();
            if (str.length() >= m) {    // 길이가 m 이상인 단어만 외움
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            int freq1 = map.get(o1);
            int freq2 = map.get(o2);
            // 1. 자주 나오는 단어일수록 앞에 배치한다.
            if (freq1 != freq2) {
                return freq2 - freq1;
            }
            // 2. 해당 단어의 길이가 길수록 앞에 배치한다.
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.
            return o1.compareTo(o2);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
