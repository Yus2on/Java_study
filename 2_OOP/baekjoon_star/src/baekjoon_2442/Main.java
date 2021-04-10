package baekjoon_2442;

import java.io.*;

// 첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제
// 별은 가운데를 기준으로 대칭이어야 한다.
// 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
// 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < 2 * n; j ++) {
                if (j >= n - i && j <= n + i) { // 중앙을 기준으로 +-i 범위에서는 별 찍기
                    bw.write("*");
                } else { // 아닌 경우는 앞 자리에 공백을 채우기
                    bw.write(" ");
                }

                if (j > n + i) { // j 가 별의 범위를 벗어나면 반복문 탈출
                    break;
                }
            } // end for
            bw.newLine();
        } // end for

        br.close();
        bw.flush();
        bw.close();
    }
}

