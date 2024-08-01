import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if (str.charAt(0) == '0') break;
            StringBuilder reverse = new StringBuilder(str).reverse();
            if (reverse.toString().equals(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}