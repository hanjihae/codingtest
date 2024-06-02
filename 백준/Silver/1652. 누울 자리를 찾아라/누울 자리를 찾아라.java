import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = input.charAt(j);
            }
        }
        int row = 0, col = 0;   // 각각 가로, 세로 누울 수 있는 자리의 수
        for (int i = 0; i < N; i++) {
            int cnt1 = 0, cnt2 = 0;
            for (int j = 0; j < N; j++) {
                // 가로 2이상 체크
                if (room[i][j] == '.') cnt1++;
                // 짐칸 X 이거나 마지막 칸일 때
                if (room[i][j] == 'X' || j == N - 1 ) {
                    if (cnt1 >= 2) row++;   // 빈 칸 .이 2개 이상이면 잘 수 있는 공간 +1
                    cnt1 = 0;   // 빈 칸 세는 수 리셋
                }
                // 세로 2이상 체크, 이하 원리 동일
                if (room[j][i] == '.') cnt2++;
                if (room[j][i] == 'X' || j == N - 1 ) {
                    if (cnt2 >= 2) col++;
                    cnt2 = 0;
                }
            }
        }
        System.out.println(row + " " + col);
    }
}