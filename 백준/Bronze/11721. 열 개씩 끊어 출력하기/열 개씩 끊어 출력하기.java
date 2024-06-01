import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < str.length(); i+=10) {
            if (str.length() - i < 10) {
                sb.append(str.substring(i));
            } else {
                sb.append(str.substring(i, i+10)).append("\n");
            }
        }
        System.out.println(sb);
    }
}