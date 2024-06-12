import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(c.nextToken());
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < cards.length-2; i++) {
            for (int j = i+1; j < cards.length-1; j++) {
                for (int k = j+1; k < cards.length; k++) {
                    if (cards[i] + cards[j] + cards[k] <= m) {
                        ans = Math.max(ans, cards[i] + cards[j] + cards[k]);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}