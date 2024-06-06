import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정환이가 음을 아는 노래 개수
        int M = Integer.parseInt(st.nextToken());   // 정환이 맞히기 시도할 노래 개수
        Map<String, String> song = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            String title = str[1];
            String code = str[2] + " " + str[3] + " " + str[4];
            song.put(title, code);  // 해시맵에 노래제목, 첫 세음 코드 저장
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            int cnt = 0;
            String name = "";
            for (Map.Entry<String, String> entry : song.entrySet()) {
                if (s.equals(entry.getValue())) {   // song에 저장된 첫 세음과 일치할 때
                    cnt++;  // 일치하는 노래 개수 세기
                    name = entry.getKey();  // 일치하는 노래 제목 저장
                }
            }
            if (cnt == 0) { // 일치하는 노래가 없다면 ! 출력
                System.out.println("!");
            } else if (cnt == 1) {  // 일치하는 노래가 하나라면 노래 제목 출력
                System.out.println(name);
            } else {    // 일치하는 노래가 두 개 이상이면 ? 출력
                System.out.println("?");
            }
        }
    }
}