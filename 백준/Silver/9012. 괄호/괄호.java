import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            System.out.println(solve(str) ? "YES" : "NO");
        }
    }

    private static boolean solve(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') { // ( 여는 괄호면 스택에 push
                stack.push(c);
            } else {    // ) 닫는 괄호면 스택에서 pop
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        // () 가 맞다면 스택이 비어야
        return stack.isEmpty();
    }
}