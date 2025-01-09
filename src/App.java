import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Up to what number do you want to check?: ");
        int max = reader.nextInt();
        reader.close();

        long timeStart = System.currentTimeMillis();
        PrimeNumberGenerator primeGenerator = new PrimeNumberGenerator(max);
        List<Integer> primeList = primeGenerator.generatePrimes();
        long timePrimes = System.currentTimeMillis();
        System.out.println("\nTime to generate prime array: " + (TimeUnit.MILLISECONDS.toSeconds(timePrimes - timeStart)) + "s.");

        SheldonPrimeChecker sheldonChecker = new SheldonPrimeChecker(primeList);
        List<Integer> sheldonPrimes = sheldonChecker.findSheldonPrimes();
        long timeEnd = System.currentTimeMillis();
        System.out.println("\nTime to find sheldon primes: " + (TimeUnit.MILLISECONDS.toSeconds(timeEnd - timePrimes)) + "s.");
        System.out.println("\nTotal time: " + (TimeUnit.MILLISECONDS.toSeconds(timeEnd - timeStart)) + "s.");
        System.out.println("\nSheldon primes: " + sheldonPrimes);
    }
}