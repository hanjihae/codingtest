import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, n);
        order(size, 0, 0);
    }

    public static void order(int size, int x, int y) {
        if (size == 1) {
            if (x == r && y == c) {
                System.out.println(cnt);
            }
            cnt++;
            return;
        }
        int newSize = size / 2;
        // 1
        if ( r < x + newSize && c < y + newSize) {  // 해당 사분면에 속하면
            order(newSize, x, y); // 재귀호출
        } else {
            cnt += newSize * newSize;
        }
        // 2
        if (r < x + newSize && c >= y + newSize) {
            order(newSize, x, y + newSize);
        } else {
            cnt += newSize * newSize;
        }
        // 3
        if (r >= x + newSize && c < y + newSize) {
            order(newSize, x + newSize, y);
        } else {
            cnt += newSize * newSize;
        }
        // 4
        if (r >= x + newSize && c >= y + newSize) {
            order(newSize, x + newSize, y + newSize);
        } else {
            cnt += newSize * newSize;
        }
    }
}
