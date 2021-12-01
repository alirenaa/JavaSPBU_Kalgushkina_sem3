import java.util.*;

public class Algorithms {
    public static void main(String args[]) {
        System.out.println("Задача sieveOfEratosthenes");
        System.out.println(Arrays.toString(sieveOfEratosthenes(7)));
        System.out.println(Arrays.toString(sieveOfEratosthenes(100)));
        System.out.println("Задача primes");
        System.out.println(Arrays.toString(primes(7)));
        System.out.println(Arrays.toString(primes(100)));
        System.out.println("Задача factorization");
        factorization(600);

    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= n; ++i) {
            if (prime[i]) {
                for (int j = 2; j * i <= n; ++j) {
                    prime[i * j] = false;
                }
            }
        }
        return prime;
    }

    private static int[] primes(int n) {
        boolean[] prime = sieveOfEratosthenes(n);
        int[] primes_sample = new int[n/2 + 1];
        int j = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primes_sample[j] = i;
                j++;
            }
        }
        int[] primes = new int[j];
        for (int i = 0; i < j; i++) {
            primes[i] = primes_sample[i];
        }
        return primes;
    }


    private static void factorization(int x){
        List<Integer[]> factors = new ArrayList<Integer[]>();
        int[] primes = primes(x);
        for (int i : primes){
            int count = 0;
            while (x % i == 0) {
                x /= i;
                count++;
            }
            if (count != 0) factors.add(new Integer[] { i, count });
        }
        for(Integer[] i : factors) {
            System.out.println(Arrays.toString(i));
        }
    }


}


