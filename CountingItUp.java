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
        long result = countUp(n, k);
        final long end = System.nanoTime();
        System.out.println("For n = " +n+ " and k = " +k+ ", n choose k = " + result);
        System.out.println((end - start)/ Math.pow(10, 9));
      }
    } else {
        System.err.println("Please enter n and k as command line arguments for the calculation.");
    }
      System.out.println(r + 1);
      System.out.println(s);
  }

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
}
