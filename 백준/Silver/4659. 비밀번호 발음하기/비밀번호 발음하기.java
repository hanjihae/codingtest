import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String input = br.readLine();
            if (input.equals("end")) break;
            
            if (isAcceptable(input)) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }

    static boolean isAcceptable(String input) {
        int vowelCnt = 0;   // 모음 개수
        int vowelSeq = 0;   // 연속된 모음 카운트
        int consonantSeq = 0;   // 연속된 자음 카운트
        char prev = ' ';    // 이전 글자
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isVowel(c)) {   // 모음이면
                vowelCnt++;
                vowelSeq++;
                consonantSeq = 0;
            } else {    // 자음이면
                consonantSeq++;
                vowelSeq = 0;
            }
            
            // 2. 모음 or 자음 3개 연속 X
            if (vowelSeq >= 3 || consonantSeq >= 3) {
                return false;
            }
            
            // 3. 같은 글자 연속 X, but ee/oo 가능
            if (i >= 1 && prev == c && !(c == 'e' || c == 'o')) {
                return false;
            }
            
            prev = c;
        }
        
        // 1. 모음 무조건 포함
        if (vowelCnt == 0) {
            return false;
        }
        
        return true;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}