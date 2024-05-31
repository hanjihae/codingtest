import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(new StringBuilder(input[0]).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(input[1]).reverse().toString());
        int ans = a > b ? a : b;
        System.out.println(ans);
    }
}