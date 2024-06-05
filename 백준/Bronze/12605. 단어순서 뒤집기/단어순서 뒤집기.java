import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                stack.push(str[j]);
            }
            String ans = "Case #" + (i + 1) + ": ";
            for (int j = 0; j < str.length; j++) {
                ans += stack.pop() + " ";
            }
            System.out.println(ans);
        }
    }
}