import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int ans = 10;
        for (int i=1; i<input.length(); i++) {
            if (input.charAt(i-1) == input.charAt(i)) {
                ans += 5;
            } else {
                ans += 10;
            }
        }
        System.out.println(ans);
    }
}