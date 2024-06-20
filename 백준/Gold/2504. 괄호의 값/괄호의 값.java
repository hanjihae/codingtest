import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int tmp = 1;
        boolean flag = true;    // 올바른 괄호인지 확인
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') { // ( 일때
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {  // [ 일때
                stack.push(c);
                tmp *= 3;
            } else {
                if (c == ')') { // ( 일 때
                    // 스택이 비어 있거나 스택의 제일 위 값이 ( 이 아닌 경우
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;   // 올바르지 않은 괄호
                        break;
                    }
                    // 바로 앞의 문자가 ( 인 경우
                    // 중첩된 괄호일 경우 그 안의 값끼리는 +
                    if (str.charAt(i-1) == '(') {
                        ans += tmp;
                    }
                    stack.pop();
                    tmp /= 2;
                } else if (c == ']') {  // [ 일 때
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    if (str.charAt(i-1) == '[') {
                        ans += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                } else {    // 그 외 문자일 경우
                    flag = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty() || !flag) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}