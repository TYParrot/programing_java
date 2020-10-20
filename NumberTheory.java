
public class NumberTheory {

	public int isPrime(int n) {
		if(n<2)
			throw new RuntimeException("is Prime error : 부적절한 인수 "+n);
		else {
			boolean found_item=false;
			int current=n/2;
			while(!found_item&&n>1) {
				if(n%current==0) 
					found_item=true;
				else
					current=current-1;
				}
			if(found_item)
				return current;
			else
				return -1;
			}
	}
	public static void main(String[] args) {
		NumberTheory math= new NumberTheory();
		System.out.println(math.isPrime(7));
		System.out.println(math.isPrime(9));

	}

}
