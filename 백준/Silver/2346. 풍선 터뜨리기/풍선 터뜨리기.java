import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 풍선 개수
        int[] bal = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {   // 풍선 안에 종이 내용 저장
            bal[i] = Integer.parseInt(st.nextToken());
        }
        Deque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        int ins = bal[0];   // 첫번째 풍선 종이 ins에 저장
        for (int i = 1; i < n; i++) {
            deque.add(new int[] {i+1, bal[i]}); // 풍선순서, 내용
        }
        while(!deque.isEmpty()) {
            if (ins > 0) {  // 종이에 적힌 숫자가 양수인 경우
                for (int i = 1; i < ins; i++) { // 종이에 적힌 수만큼 이동
                    deque.add(deque.poll());    // 해당되는 풍선 뒤로 보내기
                }
                int[] next = deque.poll();  // 종이만큼 이동한 위치에 해당되는 풍선
                ins = next[1];
                sb.append(next[0]+" "); // 풍선 순서
            } else {    // 종이에 적힌 숫자가 음수인 경우
                for (int i = 1; i < -ins; i++) {
                    deque.addFirst(deque.pollLast());
                }
                int[] next = deque.pollLast();
                ins = next[1];
                sb.append(next[0]+" ");
            }
        }
        System.out.println(sb.toString());
    }
}