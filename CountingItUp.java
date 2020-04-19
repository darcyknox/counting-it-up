import java.util.*;

public class CountingItUp{


  public static void main(String[] args){
	   if(args.length == 2){
	      long n = Long.parseLong(args[0]);
        long k = Long.parseLong(args[1]);
        long result = countUp(n, k);
        System.out.println("For n = " +n+ " and k = " +k+ ", n choose k = " + result);
      } else {
        System.err.println("Please enter n and k as command line arguments for the calculation.");
      }
    }

    public static long countUp(long n, long k){
      if (k == 0 || n == k) {
        return 1;
      } else {
        long result = countUp(n - 1, k - 1) + countUp(n - 1, k);
        return result;
      }
    }
}
