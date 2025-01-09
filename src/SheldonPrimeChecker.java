import java.util.ArrayList;
import java.util.List;

class SheldonPrimeChecker {
    private final List<Integer> primeList;

    public SheldonPrimeChecker(List<Integer> primeList) {
        this.primeList = primeList;
    }

    public List<Integer> findSheldonPrimes() {
        List<Integer> sheldonPrimes = new ArrayList<>();
        for (Integer prime : primeList) {
            if (isSheldonPrime(prime)) {
                sheldonPrimes.add(prime);
            }
        }
        return sheldonPrimes;
    }

    private boolean isSheldonPrime(int number) {
        int position = primeList.indexOf(number) + 1;
        int invertedNumber = invert(number);
        int invertedPosition = primeList.indexOf(invertedNumber) + 1;

        return number == 73 && position == multiplyDigits(number) && invertedPosition == invert(position);
    }

    private int invert(int number) {
        int inverted = 0;
        while (number > 0) {
            inverted = inverted * 10 + number % 10;
            number /= 10;
        }
        return inverted;
    }

    private int multiplyDigits(int number) {
        int product = 1;
        while (number > 0) {
            product *= number % 10;
            number /= 10;
        }
        return product;
    }
}