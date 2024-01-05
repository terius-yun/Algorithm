import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cardCount = in.nextInt();
        int max = in.nextInt();

        int[] cards = new int[cardCount];

        for (int i = 0; i < cardCount; i++) {
            cards[i] = in.nextInt();
        }

        int result = search(cards, cardCount, max);
        System.out.println(result);
    }


    static int search(int[] cards, int cardCount, int max) {
        int result = 0;

        for (int firstCardIndex = 0; firstCardIndex < cardCount - 2; firstCardIndex++) {
            for (int secondCardIndex = firstCardIndex + 1; secondCardIndex < cardCount - 1; secondCardIndex++) {
                for (int thirdCardIndex = secondCardIndex + 1; thirdCardIndex < cardCount; thirdCardIndex++) {
                    
                    int sum = cards[firstCardIndex] + cards[secondCardIndex] + cards[thirdCardIndex];

                    if (max == sum) {
                        return sum;
                    }

                    if(result < sum && sum < max) {
                        result = sum;
                    }
                }
            }
        }

        return result;
    }
}