import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = "";
        for (String s : str.split("-")) {
            ans += s.substring(0,1);
        }
        System.out.println(ans);
    }
}