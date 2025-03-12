class Solution {
    // n = 택배 상자 수
    // w = 가로로 놓는 상자 개수
    // num = 꺼내려는 상자의 번호
    public int solution(int n, int w, int num) {
        boolean dir = true;
        int h = n % w == 0 ? n/w : (n/w) + 1;   // 창고 높이 계산
        int x = 0, y = 0;   // 현재 위치
        int numX = 0, numY = 0; // num 상자 위치
        int[][] boxes = new int[h][w];
        for (int i=1; i <= n; i++) {
            boxes[y][x] = i;    // 상자 번호 저장
            if (i == num) { // num 위치 저장
                numX = x;
                numY = y;
            }
            if (dir) {
                if (x == w - 1) {   // x가 가로열 끝이면
                    y++;    // 한칸 올라가기
                    dir = false;    // 방향 전환
                // 오른쪽으로 한 칸씩
                } else x++;
            } else {
                if (x == 0) {   // x가 가로열 첫번째면
                    y++;    // 한칸 올라가기
                    dir = true;     // 방향 전환
                // 왼쪽으로 한 칸씩
                } else x--;
            }
        }
        int ans = 0;
        // num 박스 위에 있는 박스 몇개인지 세기
        while(numY < h) {
            if (boxes[numY][numX] != 0) {
                ans++;
            }
            numY++;
        }
        return ans;
    }
}
