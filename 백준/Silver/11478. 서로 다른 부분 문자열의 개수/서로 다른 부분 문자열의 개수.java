import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashSet<String> set = new HashSet<>();
        for (int i=0; i < input.length(); i++) {
            for (int j=i+1; j <= input.length(); j++) {
                set.add(input.substring(i, j));
            }
        }
        int ans = set.size();
        System.out.println(ans);
    }
}