import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;    // 현재 비교할 배열 인덱스
        int num = 1;    // 스택에 넣을 수
        while(cnt < n) {
            if (!stack.isEmpty() && stack.peek() == arr[cnt]) {
                stack.pop();
                sb.append("-\n");
                cnt++;
            // 스택이 비어있거나 스택의 최상단이 arr[cnt]와 다를 경우 push
            } else if (num <= n){
                stack.push(num);
                sb.append("+\n");
                num++;
            } else { // 스택에 push할 수 없고 스택의 최상단과 현재 배열값이 다르다면 수열을 만들 수 없는 것이므로
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
