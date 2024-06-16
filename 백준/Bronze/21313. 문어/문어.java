import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ans = "";
        if (n % 2 == 0) {
            for (int i=0; i < n/2; i++) {
                ans += "1 2 ";
            }
        } else {
            for (int i=0; i < (n/2)+1; i++) {
                if (i == n/2) {
                    ans += "3";
                } else {
                    ans += "1 2 ";
                }
            }
        }
        System.out.println(ans);
    }
}