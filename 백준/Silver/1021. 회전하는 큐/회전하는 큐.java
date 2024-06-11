import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 큐의 크기
        int m = Integer.parseInt(st.nextToken());   // 뽑아내려고 하는 수의 개수
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int cnt = 0;    // 회전 횟수 카운트
        for (int i = 1; i <= n; i++) {   // 큐에 1~n 숫자 추가
            deque.offer(i);
        }
        int[] seq = new int[m];
        StringTokenizer jimin = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {   // 뽑아내려는 수 배열에 저장
            seq[i] = Integer.parseInt(jimin.nextToken());
        }
        for (int i = 0; i < m; i++) {
            int target = deque.indexOf(seq[i]); // 데크에서 뽑아내려는 수 위치
            int half = deque.size() % 2 == 0 ? (deque.size()/2)-1 : deque.size()/2; // 데크의 중간 인덱스 계산
            if (target <= half) {   // 뽑아내려는 수가 앞쪽에 있는 경우
                for (int j = 0; j < target; j++) {
                    int now = deque.pollFirst();    // 첫번째 요소 제거하고
                    deque.offerLast(now);   // 마지막에 추가
                    cnt++;
                }
            } else {
                for (int j = 0; j < deque.size() - target; j++) {   // 뽑아내려는 수가 뒷쪽에 있는 경우
                    int now = deque.pollLast(); // 마지막 요소 제거하고
                    deque.offerFirst(now);  // 앞에 추가
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}