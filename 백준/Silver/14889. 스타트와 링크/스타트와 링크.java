import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int memberCount;
    private static int[][] memberMap;
    private static boolean[] visitedList;

    private static int minAbility = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memberCount = Integer.parseInt(br.readLine());

        memberMap = new int[memberCount][memberCount];
        visitedList = new boolean[memberCount];

        for (int i = 0; i < memberCount; i++){
            StringTokenizer st = new StringTokenizer( br.readLine() , " " );
            for (int j = 0; j < memberCount; j++) {
                memberMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkCombination(0, 0);
        System.out.println(minAbility);
    }
    private static void checkCombination(int index, int count){
        if(count == memberCount / 2) {
            diff();
            return;
        }
        for(int i = index; i < memberCount; i++) {
            if(!visitedList[i]) {
                visitedList[i] = true;
                checkCombination(i + 1, count + 1);
                visitedList[i] = false;
            }
        }
    }

    private static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < memberCount; i++) {
            for (int j = i + 1; j < memberCount; j++) {
                if (visitedList[i] && visitedList[j]) {
                    teamStart += memberMap[i][j];
                    teamStart += memberMap[j][i];
                }else if (!visitedList[i] && !visitedList[j]) {
                    teamLink += memberMap[i][j];
                    teamLink += memberMap[j][i];
                }
            }
        }
        int value = Math.abs(teamStart - teamLink);
		
        if (value == 0) {
            System.out.println(value);
            System.exit(0);
        }

        minAbility = Math.min(value, minAbility);

    }
}