import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        int[] randomNumbers = new int[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            randomNumbers[i] = random.nextInt(100) + 1; 
        }

        for (int number : randomNumbers) {
            System.out.print(number + ", ");
        }
    }
}
