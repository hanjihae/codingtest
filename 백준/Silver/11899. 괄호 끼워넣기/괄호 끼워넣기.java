import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<Character>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { // ( 이면 스택에 넣기
                stack.push(c);
            } else {    // ) 이면 스택에서 빼기
                if (stack.isEmpty()) {  // 스택이 빈 경우
                    ans++;
                } else {
                    stack.pop();
                }
            }
        }
        ans += stack.size();    // 스택에 남은 짝 없는 괄호 숫자 포함
        System.out.println(ans);
    }
}