import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine().replace("[", "").replace("]", "");
            Deque<Integer> deque = new ArrayDeque<>();
            if (!input.isEmpty()) {
                StringTokenizer st = new StringTokenizer(input, ",");
                while(st.hasMoreTokens()) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }
            }
            boolean isReversed = false; // R
            boolean isError = false;    // D
            for(int j=0; j < p.length(); j++) {
                char c = p.charAt(j);
                if (c == 'R') {
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {  // 데크가 비어있는 데 D를 사용하면 에러 발생
                        isError = true;
                        break;
                    }
                    if(isReversed) {    // 배열이 뒤집힌 상태면 데크 마지막 숫자 제거
                        deque.removeLast();
                    } else {    // 배열이 뒤집히지 않았다면 데크 첫번째 숫자 제거
                        deque.removeFirst();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if(isError) {   // 에러가 발생한 상태면 error 출력
                sb.append("error");
            } else {
                sb.append("[");
                while(!deque.isEmpty()) {
                    // 배열이 뒤집혔다면 뒤부터 출력, 아니면 앞부터 출력
                    sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if(!deque.isEmpty()) {  // 마지막 수에는 , 안 붙게
                        sb.append(",");
                    }
                }
                sb.append("]");
            }
            System.out.println(sb.toString());
        }
    }
}
