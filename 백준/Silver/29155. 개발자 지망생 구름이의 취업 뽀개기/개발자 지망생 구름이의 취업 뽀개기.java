import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 난이도가 동일할 경우, 휴식시간 = 두 문제를 푸는데 걸리는 시간의 차이
// 난이도가 증가할 경우, 휴식시간 = 60분
// 문제 풀이 시간 = 푼 문제 예상 시간 합 + 문제 사이 휴식 시간 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] level = new int[6];
        for (int i=1; i <= 5; i++) {    //  난이도별 풀어야 하는 문제 수
            level[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer>[] times = new ArrayList[6];
        for (int i=1; i <= 5; i++) {
            times[i] = new ArrayList<>();
        }
        // 난이도별 문제 풀이 시간 저장 및 정렬
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            times[k].add(t);
        }
        for (int i=1; i <= 5; i++) {
            Collections.sort(times[i]);
        }
        // 문제 선택
        List<Integer> selected = new ArrayList<>();
        for (int i=1; i <= 5; i++) {
            for (int j=0; j < level[i]; j++) {  // 닌이도별 정해진 문제 개수만큼 선택
                if (j < times[i].size()) {
                    selected.add(times[i].get(j));
                }
            }
        }
        int total = 0;
        int prev = selected.get(0); // 이전 문제 풀이 소요시간
        int prevLevel = 1;   // 이전 문제 난이도
        for (int i=0; i < selected.size(); i++) {
            int current = selected.get(i); // 현재 문제를 푸는 데 걸리는 시간
            int currentLevel;
            // 현재 문제 난이도 계산
            if (i < level[1]) {
                currentLevel = 1;
            } else if (i < level[1] + level[2]) {
                currentLevel = 2;
            } else if (i < level[1] + level[2] + level[3]) {
                currentLevel = 3;
            } else if (i < level[1] + level[2] + level[3] + level[4]) {
                currentLevel = 4;
            } else {
                currentLevel = 5;
            }
            // 문제 풀이 시간 추가
            total += current;
            // 휴식시간 계산
            if (i > 0) {
                if (currentLevel == prevLevel){  // 난이도가 이전과 동일한 경우
                    total += Math.abs(current - prev);  // + 현재 문제 소요시간 - 이전 문제 소요 시간
                } else {    // 난이도가 증가한 경우
                    total += 60;
                }
            }
            prevLevel = currentLevel;
            prev = current;
        }
        System.out.println(total);
    }
}
