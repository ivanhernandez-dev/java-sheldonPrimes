import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {
    private final int max;

    public PrimeNumberGenerator(int max) {
        this.max = max;
    }

    public List<Integer> generatePrimes() {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int factor = 2; factor * factor <= max; factor++) {
            if (isPrime[factor]) {
                for (int j = factor * factor; j <= max; j += factor) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
