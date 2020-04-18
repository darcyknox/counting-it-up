
public class CountingItUp{
    
    public static void main(String[] args){
	if(args.length == 2){
	    long n = Long.parseLong(args[0]);
	    long k = Long.parseLong(args[1]);
	    long result = countUp(n, k);
	    System.out.println("For n = " +n+ " and k = " +k+ ", n choose k = " + result);
	}else{
	    System.err.println("Please enter n and k as command line arguments for the calculation.");
    }
}

    public static long countUp(long n, long k){
        long result = 0; //placeholder
        
        //Computation method(s) goes here
        
        return result;
    }
}
