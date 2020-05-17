import java.util.*;
import java.lang.Math;

public class CountingItUp {

  /* Multiplicative formula

  /*
  The main method takes command line arguments n and k on which to find the result n choose k, where either term can be a 64-bit integer.
  This method also handles invalid empty and negative arguments, and prints a statement with the result of n choose k.
  */
  public static void main(String[] args) {
    long r = Long.MAX_VALUE;

    if (args.length == 2) {
      long n = Long.parseLong(args[0]);
      long k = Long.parseLong(args[1]);

      if (n < 0 || k < 0) {
        System.out.println("Input cannot be negative");
      } else if (n < k) {
        System.out.println("n should be greater than k");
      } else {
        String result = nck(n, k);
        System.out.println("n = " + n + " k = " + k + " nck = " + result);
      }
    } else {
      System.err.println("Please enter n and k as command line arguments for the calculation.");
    }
  }

  /*
  The nck method recursively implements the multiplicative formula to calculate binomial coefficients. Here, nck(n - 1, k - 1)
  represents the binomial coefficient of the previous term i.e. where an element has been subtracted from the current set and
  where k was part of that set.
  This calaculation is returned in result, and the method also handles the base case.
  */
  private static String nck(long n, long k) {
    ArrayList<Long> nums = new ArrayList<>();
    ArrayList<Long> dens = new ArrayList<>();
    ArrayList<Integer> primes = new ArrayList<>();

    if (k > n - k) {
      k = n - k;
    }

    for (long i = 0; i < k; i++) {
      nums.add(n - i);
    }
    //System.out.println(nums);
    for (long i = k; i > 0; i--) {
      dens.add(i);
    }
    //System.out.println(dens);


    for (int i = 0; i < dens.size(); i++) {
      while ((dens.get(i) != 0) && (dens.get(i) % 2 == 0)) { // while denominator is divisible by 2
        primes.add(2);
        dens.set(i, dens.get(i) / 2);
        //nums.set(i, nums.get(i) / 2);
      }
      while ((dens.get(i) != 0) && (dens.get(i) % 3 == 0)) {
        primes.add(3);
        dens.set(i, dens.get(i) / 3);
        //nums.set(i, nums.get(i) / 3);
      }
      while ((dens.get(i) != 0) && (dens.get(i) % 5 == 0)) {
        primes.add(5);
        dens.set(i, dens.get(i) / 5);
        //nums.set(i, nums.get(i) / 5);
      }
      while ((dens.get(i) != 0) && (dens.get(i) % 7 == 0)) {
        primes.add(7);
        dens.set(i, dens.get(i) / 7);
        //nums.set(i, nums.get(i) / 7);
      }
      if (dens.get(i) > 1) {
        nums.set(i, nums.get(i) / dens.get(i));
      }
    }
    //System.out.println(primes);


    // Cancel out numerator terms by prime terms
    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < primes.size(); j++) {
        if (nums.get(i) % primes.get(j) == 0) {
          nums.set(i, nums.get(i) / primes.get(j));
          primes.set(j, 1);
        }
      }
    }


    long nCk = 1;

    for (int i = 0; i < k; i++) {
      if (nCk * nums.get(i) / nCk != nums.get(i)) {
        return "Overflow";
      }
      nCk *= nums.get(i);
    }

    //System.out.println(nums);
    //System.out.println(dens);
    //System.out.println(primes);

    return Long.toUnsignedString(nCk);
  }

}
