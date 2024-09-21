import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int white;
    static int blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dividePaper(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void dividePaper(int size, int x, int y) {
        if (checkColor(size, x, y)) {
            if (arr[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int newSize = size / 2;
        dividePaper(newSize, x, y); // arr[0, 0]
        dividePaper(newSize, x, y + newSize);   // arr[0, newSize]
        dividePaper(newSize, x + newSize, y);   // arr[newSize, 0]
        dividePaper(newSize, x + newSize, y + newSize); // arr[newSize, newSize]
    }

    public static boolean checkColor(int size, int x, int y) {
        int color = arr[x][y];
        for (int i=x; i < x + size; i++) {
            for (int j=y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
