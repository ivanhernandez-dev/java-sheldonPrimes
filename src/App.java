import java.util.LinkedHashSet;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedHashSet<Integer> sheldonPrimes = new LinkedHashSet<Integer>();
        for (int i = 0; true; i++) {
            if (isSheldonPrime(i)) {
                sheldonPrimes.add(i);
            }
            if (i % 1000 == 0) {
                System.out.println("Actual number: " + i + " - Sheldon primes: " + sheldonPrimes);
            }
        }
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

    static int positionPrime(int number) {
        int position = 1;
        for (int i = 0; i < number; i++) {
            if (isPrime(i)) {
                position++;
            }
        }
        return position;
    }

    static int multiplyDigits(int number) {
        int product = 1;
        while (number > 0) {
            product *= number % 10;
            number = number / 10;
        }
        return product;
    }

    static boolean isSheldonPrime(int number) {
        if (isPrime(number)) {
            int positionPrime = positionPrime(number);
            if (positionPrime == invert(positionPrime(invert(number)))) {
                if (multiplyDigits(number) == positionPrime) {
                    return true;
                }
            }
        }
        return false;
    }
}
