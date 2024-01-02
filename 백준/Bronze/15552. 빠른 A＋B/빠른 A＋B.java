import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int questionCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < questionCnt; i++) {
            String[] num = br.readLine().split(" ");
            bw.write(String.valueOf(Integer.parseInt(num[0]) + Integer.parseInt(num[1])));
            bw.newLine();
        }
        bw.close();
    }
}