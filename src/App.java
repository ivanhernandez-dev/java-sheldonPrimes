import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    static Integer[] primeArray;

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        long timeStart, timePrimes, timeEnd;
        int max;
        LinkedHashSet<Integer> sheldonPrimes = new LinkedHashSet<Integer>();

        System.out.print("Up to what number do you want to check?: ");
        max = reader.nextInt();
        timeStart = System.currentTimeMillis();
        primeArray = getPrimeArray(max);
        timePrimes = System.currentTimeMillis();
        System.out.println("\nTime to generate prime array: "
                + (TimeUnit.MILLISECONDS.toSeconds(timePrimes - timeStart)) + "s.");
        for (Integer integer : primeArray) {
            if (primeIsSheldonPrime(integer)) {
                sheldonPrimes.add(integer);
            }
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("\nTime to find sheldon primes: "
                + (TimeUnit.MILLISECONDS.toSeconds(timeEnd - timePrimes)) + "s.");
        System.out.println("\nTotal time: " + (TimeUnit.MILLISECONDS.toSeconds(timeEnd - timeStart)) + "s.");
        System.out.println("\nSheldon primes: " + sheldonPrimes);
        reader.close();
    }

    static boolean isPrime(int number) {
        if (number == 0 || number == 1 || number == 4) {
            return false;
        }
        for (int x = 2; x < number / 2; x++) {
            if (number % x == 0) {
                return false;
            }
        }
        return true;
    }

    static int invert(int number) {
        int inverted = 0;
        while (number > 0) {
            inverted = inverted * 10 + number % 10;
            number = number / 10;
        }
        return inverted;
    }

    static int positionPrime(int prime) {
        for (int i = 0; i < primeArray.length; i++) {
            if (primeArray[i] == prime) {
                return i + 1;
            }
        }
        return -1;
    }

    static Integer[] getPrimeArray(int max) {
        LinkedHashSet<Integer> primeList = new LinkedHashSet<Integer>();
        for (int i = 0; i <= max; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        Integer[] primeArray = primeList.toArray(new Integer[primeList.size()]);
        return primeArray;
    }

    static int multiplyDigits(int number) {
        int product = 1;
        while (number > 0) {
            product *= number % 10;
            number = number / 10;
        }
        return product;
    }

    static boolean primeIsSheldonPrime(int number) {
        int positionPrime = positionPrime(number);
        if (positionPrime == invert(positionPrime(invert(number)))) {
            if (multiplyDigits(number) == positionPrime) {
                return true;
            }
        }
        return false;
    }
}
