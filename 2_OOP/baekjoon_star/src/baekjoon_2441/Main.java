package baekjoon_2441;

import java.io.*;

// 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제
// 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
// 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
// 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = n; i >= 1; i --) { // n부터 0까지 반복
            for(int j = 0; j < n; j ++) {
                if (j < n - i) {
                    bw.write(" ");
                } else {
                    bw.write("*");
                }
            } // end for
            bw.newLine();
        } // end for

        br.close();
        bw.flush();
        bw.close();
    }
}

