import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        int[] randomNumbers = new int[1000];
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            randomNumbers[i] = random.nextInt(1000) + 1; 
        }

        for (int number : randomNumbers) {
            System.out.print(number + ", ");
        }
    }
}
