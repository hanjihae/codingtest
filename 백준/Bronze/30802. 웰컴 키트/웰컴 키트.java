import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 참가자 수
        int n = Integer.parseInt(br.readLine());
        // 티셔츠 사이즈별 신청자 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer tp = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tp.nextToken());   // 정수 티셔츠
        int p = Integer.parseInt(tp.nextToken());   // 펜 한 묶음에 몇개 있는지 개수

        int tshirts = 0;    // t장씩 최소 몇 묶음
        for (int i = 0; i < 6; i++) {
            int size = Integer.parseInt(st.nextToken());
            if (size > 0 && size <= t) {
                tshirts++;
            } else {
                tshirts += size/t;
                size = size % t;
                if (size >0 && size <= t) {
                    tshirts++;
                }
            }
        }
        String pens = n/p + " " + n%p;
        System.out.print(tshirts + "\n" + pens);
    }
}