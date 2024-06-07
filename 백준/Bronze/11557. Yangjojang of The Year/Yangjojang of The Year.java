import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트케이스 수
        Map<String, Long> alcohol = new HashMap<>();
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());    // 학교 수
            for (int j=0; j<N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();   // 학교 이름
                Long alc = Long.parseLong(st.nextToken());  // 지난 한 해동안 소비한 술의 양
                alcohol.put(name, alc);
            }
            long max = Long.MIN_VALUE;
            String uni = "";
            for (Map.Entry<String, Long> entry : alcohol.entrySet()) {
                if (entry.getValue() > max) {   // 지난 한 해 동안 소비한 술의 양 중 최댓값
                    max = entry.getValue();
                    uni = entry.getKey();   // 최댓값에 해당하는 학교 이름
                }
            }
            System.out.println(uni);
        }
    }
}