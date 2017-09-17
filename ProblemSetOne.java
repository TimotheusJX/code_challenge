import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemSetOne {	
	public static void main(String[] args){
		ProblemSetOne problemSetOne = new ProblemSetOne();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int numberOne = scanner.nextInt();
			System.out.println(numberOne);
			int numberTwo = scanner.nextInt();
			System.out.println(numberTwo);
			problemSetOne.processNumbers(numberOne, numberTwo);
			scanner.nextLine();
		}
		scanner.close();
	}
	
	public void processNumbers(int numberOne, int numberTwo){
		int n=0;
		int difference = numberTwo - numberOne;
		List<Integer> sizeList = new ArrayList<Integer>();
		while(difference > -1){
			sizeList.add(n, calculate(numberOne + n));
			difference--;
			n++;
		}
		System.out.println(sizeList.size());
	}
	
	public int calculate(int x){
		if(x==1){
			return 1;
		}else if(x%2 == 1){
			return calculate(3*x + 1);
		}else{
			return calculate(x/2);
		}
	}
}
