import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String[] cards = new String[n];
        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }
        boolean[] visited = new boolean[n];
        comb(cards, visited, k, new StringBuilder());
        System.out.println(set.size());
    }

    public static void comb (String[] cards, boolean[] visited, int k, StringBuilder sb) {
        if (k == 0) {
            set.add(Integer.parseInt(sb.toString()));   // 만들어진 수 set에 넣기 + 중복 제거
        } else {
            for (int i = 0; i < cards.length; i++) {
                if (!visited[i]) {  // 아직 카드가 선택되지 않았다면
                    visited[i] = true;  // 현재 카드 선택 표시
                    sb.append(cards[i]);    // StringBuilder로 숫자카드 조합
                    comb(cards, visited, k - 1, sb);    // 선택할 카드 수 1씩 줄이면서 다음 카드 선택
                    visited[i] = false; // 재귀 호출 종료 후 현재 카드를 선택되지 않은 상태로 복구
                    sb.setLength(sb.length() - cards[i].length());  // StringBuilder 초기화
                }
            }
        }
    }
}