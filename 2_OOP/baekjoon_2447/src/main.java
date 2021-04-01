import java.io.*;

// N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양
// 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴
// N이 3보다 클 경우, 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태
// N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k

class Main {
    static char[][] arr;

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        star (0, 0, n, false);

        for (int i = 0; i < n; i ++) {
            bw.write(arr[i]);
            bw.write("\n");
        } // end for

        bw.flush();
        bw.close();
    }

    static void star (int x, int y, int n, boolean flag) {
        if (flag) { // 공백일 때 
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                } // end for
            } // end for
            return;
        }

        if (n == 1) {
            arr[x][y] = '*'; // 별 찍고
            return; // 종료
        }

        int size = n / 3; // 입력받은 n 값을 계속 3씩 나눠줌
        int cnt = 0;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                cnt ++;
                if (cnt == 5) { // 공백일 때
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            } // end for
        } // end for

    }
}