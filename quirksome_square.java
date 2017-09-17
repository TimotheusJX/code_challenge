import java.util.Scanner;

public class quirksome_square {
	
	quirksome_square(){
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int cutHalf = (int) Math.pow(10,n/2);
			for(int i = 0; i < cutHalf; i++) {
				int sum = (int) Math.pow(i, 2);
				if (Math.pow((sum/cutHalf + sum%cutHalf), 2) == sum) {
					System.out.println(sum);
				}
			}
		}
	}
}
