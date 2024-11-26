import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i < t; i++) {
            String str = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (char c : str.toCharArray()) {
                // 커서 위치 이동
                if (c == '<') { // 커서 왼쪽으로 이동
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (c == '>') {  // 커서 오른쪽으로 이동
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else if (c == '-') { // Backspace
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.push(c);
                }
            }
            while(!left.isEmpty()) {    // 왼쪽 스택 문자 모두 오른쪽 스택에 옮긴 후 출력
                right.push(left.pop());
            }
            StringBuilder sb = new StringBuilder();
            while(!right.isEmpty()) {
                sb.append(right.pop());
            }
            System.out.println(sb);
        }
    }
}
