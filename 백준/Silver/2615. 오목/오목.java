import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] ohmok = new char[19][19];
        // 오목판 오른쪽, 아래, 우측아래대각선, 우측위대각선
        int[][] direction = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
        for (int i = 0; i < 19; i++) {
            String input = br.readLine();
            // 주어진 문자열에 공백이 있기 때문에 index+=2
            for (int j = 0, index = 0; j < 19; index+=2, j++) {
                ohmok[i][j] = input.charAt(index);
            }
        }
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (ohmok[i][j] == '1' || ohmok[i][j] == '2') {
                    for (int k = 0; k < 4; k++) {   // 사방찾기
                        // 현재 방향에서 연속된 돌 개수
                        int cnt = 1;
                        // 현재 위치
                        int dx = i;
                        int dy = j;
                        while(true) {
                            dx += direction[k][0];
                            dy += direction[k][1];
                            if (dx >= 0 && dx < 19 && dy >= 0 && dy < 19) { // 오목판 범위 벗어나면 break;
                                // 현재 위치의 돌과 새로운 위치의 돌이 같으면 cnt++;
                                if (ohmok[i][j] == ohmok[dx][dy]) {
                                    cnt++;
                                } else break;
                            } else break;
                        }
                        // 반대방향에서 연속된 돌 개수
                        dx = i;
                        dy = j;
                        while(true) {
                            dx -= direction[k][0];
                            dy -= direction[k][1];
                            if (dx >= 0 && dx < 19 && dy >= 0 && dy < 19) {
                                if (ohmok[i][j] == ohmok[dx][dy]) {
                                    cnt++;
                                } else break;
                            } else break;
                        }
                        // 연속된 돌 개수가 5개일 때
                        if (cnt == 5) {
                            System.out.println(ohmok[i][j]);
                            System.out.println((i+1) + " " + (j+1));
                            return;
                        }
                    }
                }
            }
        }
        // 둘 다 없는 경우
        System.out.println(0);
    }
}