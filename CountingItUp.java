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

  
  private static String nck(long n, long k) {
    ArrayList<Long> nums = new ArrayList<>();
    ArrayList<Long> dens = new ArrayList<>();
    ArrayList<Long> primes = new ArrayList<>();

    if (k > n - k) {
      k = n - k;
    }

    for (long i = 0; i < k; i++) {
      nums.add(n - i);
    }
    System.out.println(nums);
    for (long i = k; i > 0; i--) {
      dens.add(i);
    }
    System.out.println(dens);


    for (int i = 0; i < dens.size(); i++) {

      while ((dens.get(i) != 0) && (dens.get(i) % 2 == 0)) { // while denominator is divisible by 2
        primes.add((long) 2);
        dens.set(i, dens.get(i) / 2);
        //nums.set(i, nums.get(i) / 2);
      }
      while ((dens.get(i) != 0) && (dens.get(i) % 3 == 0)) {
        primes.add((long) 3);
        dens.set(i, dens.get(i) / 3);
        //nums.set(i, nums.get(i) / 3);
      }
      while ((dens.get(i) != 0) && (dens.get(i) % 5 == 0)) {
        primes.add((long) 5);
        dens.set(i, dens.get(i) / 5);
        //nums.set(i, nums.get(i) / 5);
      }
      if (dens.get(i) > 1) {
        primes.add(dens.get(i));
        //nums.set(i, nums.get(i) / dens.get(i));
      }

    }


    System.out.println(primes);

    // Cancel out numerator terms by prime terms
    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < primes.size(); j++) {
        if (nums.get(i) % primes.get(j) == 0) {
          //System.out.println(Long.toString(nums.get(i)) + ' ' + Long.toString(primes.get(j)));
          nums.set(i, nums.get(i) / primes.get(j));
          primes.set(j, (long) 1);
        }
      }
    }

    /*
    for (int i = 0; i < top.size(); i++) {
        //for each
        for (int j = 0; j < bottom.size(); j++) {
            if (top.get(i) % bottom.get(j) == 0) {
                top.set(i, top.get(i) / bottom.get(j));
                bottom.set(j, 1L);
            }
        }
    }
    */

    System.out.println("Nums");
    System.out.println(nums);
    System.out.println("Dens");
    System.out.println(dens);
    System.out.println("Primes");
    System.out.println(primes);


    long nCk = 1;

    for (int i = 0; i < k; i++) {
      if (nCk * nums.get(i) / nCk != nums.get(i)) {
        return "Overflow";
      }
      nCk *= nums.get(i);
    }

    return Long.toUnsignedString(nCk);
  }

}
