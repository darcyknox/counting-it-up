import java.util.*;
import java.lang.Math;

public class CountingItUp {


  public static void main(String[] args) {
    long r = Long.MAX_VALUE;

    String s = Long.toString(r + (r - r/8));
    s = s.substring(1);
    if(args.length == 2){
      long n = Long.parseLong(args[0]);
      long k = Long.parseLong(args[1]);
      final long start = System.nanoTime();
      if (n < 0 || k < 0) {
        System.out.println("Input cannot be negative");
      } else {
        long result = nck(n, k);
        final long end = System.nanoTime();
        System.out.println("For n = " +n+ " and k = " +k+ ", n choose k = " + result);
        System.out.println((end - start)/ Math.pow(10, 9));
      }
    } else {
        System.err.println("Please enter n and k as command line arguments for the calculation.");
    }
  }


  /*The countUp method recursively implements n choose k. This method works on the basis that the
  fixed set "n" is comprised of the fixed set "n-1" plus one more (new) element. One of the elements in the subset "k" either
  includes this new element, or it doesn't. With the new element added to the original n-1 fixed set, the number of
  unordered subsets k will be equal to however many there were in the n-1 fixed set if the new element is not part
  of the subset k, plus (+), if the new element is part of the subset k, there will be k-1 remaining elements
  to be put into the remaining n-1 elements. This calaculation is returned in result, and the method also handles the base case. */
    public static long countUp(long n, long k){
      if (k == 1) {
        return n;
      } else if (k == 0 || n == k) {
        return 1;
      } else {
        long result = countUp(n - 1, k - 1) + countUp(n - 1, k);
        return result;
      }
    }

    private static long nck(long n, long k) {
      if (k == 1) {
        return n;
      } else if (k == 0 || n == k) {
        return 1;
      } else {
        return (n * nck(n - 1, k - 1)) / k;
      }
    }
}
