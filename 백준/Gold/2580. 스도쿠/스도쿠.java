import java.io.*;
import java.util.Arrays;

public class Main {
   static int[][] table = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 0);
    }

    public static void dfs(int row, int col){
        if(col == 9){
            dfs(row+1, 0);
            return;
        }
        if (row == 9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(table[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(table[row][col] == 0){
            for (int i = 1; i <= 9; i++) {
                if (checkValidation(row,col,i)){
                    table[row][col] = i;
                    dfs(row, col+1);
                }
            }
            table[row][col] = 0;
            return;
        }
        dfs(row, col+1);
    }

    public static boolean checkValidation(int row, int col, int value){
        for (int i = 0; i < 9; i++) {
            if(table[row][i] == value){
                return false;
            }
            if(table[i][col] == value){
                return false;
            }
        }

        int rowThree = ((row/3)) * 3;
        int colThree = ((col/3)) * 3;
        for (int i = rowThree; i < rowThree + 3; i++) {
            for (int j = colThree; j < colThree + 3; j++) {
                if(table[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }
}