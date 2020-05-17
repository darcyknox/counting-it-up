import java.util.*;
import java.lang.Math;

public class CountingItUpOld {

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
        long result = nck(n, k);
        System.out.println("n = " + n + " k = " + k + " nck = " + Long.toUnsignedString(result));
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
  private static long nck(long n, long k) {
    if (k == 1) {
      return n;
    } else if (k == 0 || n == k) {
      return 1;
    } else {
      return (n * nck(n - 1,  k - 1)) / k;
    }
  }

}
