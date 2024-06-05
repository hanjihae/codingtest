import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = 0;
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 97 && input.charAt(i) <= 122) {  // 소문자일때
                num += input.charAt(i) - 'a' + 1;
            } else if (input.charAt(i) >= 65 && input.charAt(i) <= 90) { // 대문자일 때
                num += input.charAt(i) - 'A' + 27;
            }
        }
        boolean primeOrNot= true;
        for (int i=2; i < num; i++) {
            if (num % i == 0) { // 1과 num을 제외한 i로 나눠지면 소수가 아님
                primeOrNot = false;
            }
        }
        System.out.println(primeOrNot ? "It is a prime word." : "It is not a prime word.");
    }
}