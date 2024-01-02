import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] check = new int[100001];
        int[] inputNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int subin = inputNum[0];
        int brother = inputNum[1];

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        int count = 0;
        queue.add(subin);
        countQueue.add(count);
        if(subin == brother){
            System.out.println(count);
        }else{
            while (!queue.isEmpty()){
                for (int i = 0; i < 3; i++) {
                    int num = queue.peek();
                    if(i == 0){
                        num = num + 1;
                    } else if (i == 1) {
                        num = num -1;
                    } else if (i == 2) {
                        num = 2 * num;
                    }

                    if(num == brother) {
                        queue.clear();
                        count = countQueue.peek()+1;
                        countQueue.clear();
                        break;
                    }

                    if(num>=0 && num < check.length && check[num] == 0){
                        check[num] = 1;
                        queue.add(num);
                        countQueue.add(countQueue.peek()+1);
                    }
                }
                queue.poll();
                countQueue.poll();
            }
            System.out.println(count);
        }
    }
}