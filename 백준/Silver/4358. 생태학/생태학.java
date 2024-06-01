import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();
        int cnt = 0;
        String tree = br.readLine();
        while (tree != null) {   // 새로 들어오는 문자열이 없을 때까지
            map.put(tree, map.getOrDefault(tree, 0) + 1);   // 있으면 value+1 없으면 key에 저장
            cnt++;  // 전체 개수
            tree = br.readLine();   // 문자열 다시 받아오기
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double d = (entry.getValue() / (double) cnt) * 100; // 해당 문자열 개수 / 전체 개수 * 100
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", d)).append("\n");
        }
        System.out.println(sb);
    }
}