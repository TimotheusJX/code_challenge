import java.util.Scanner;

public class EcologicalPackingService {
	int b1, g1, c1, b2, g2, c2, b3, g3, c3;
	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] arg){
		EcologicalPackingService eco = new EcologicalPackingService(); 
		//check if there is anything in the current line
		//this scanner scan from System.in
		while(scanner.hasNext()){
			eco.processData();
		}
		scanner.close();
	}
	
	public void processData(){
		b1 = scanner.nextInt();
		g1 = scanner.nextInt();
		c1 = scanner.nextInt();
		b2 = scanner.nextInt();
		g2 = scanner.nextInt();
		c2 = scanner.nextInt();
		b3 = scanner.nextInt();
		g3 = scanner.nextInt();
		c3 = scanner.nextInt();
		scanner.nextLine();
		
		String name = "BCG";
		int moves = sumUp(new int[]{b2, b3, c1, c3, g1, g2});
		
		int bgc = sumUp(new int[]{b2, b3, g1, g3, c1, c2});
		if(bgc < moves){
			name = "BGC";
			moves = bgc;
		}
		int cbg = sumUp(new int[]{c2, c3, b1, b3, g2, g1});
		if(cbg < moves){
			name = "CBG";
			moves = cbg;
		}
		int cgb = sumUp(new int[]{c2, c3, g1, g3, b1, b2});
		if(cgb < moves){
			name = "CGB";
			moves = cgb;
		}
		int gbc = sumUp(new int[]{g2, g3, b1, b3, c1, c2});
		if(gbc < moves){	
			name = "GBC";
			moves = gbc;
		}
		int gcb = sumUp(new int[]{g2, g3, c1, c3, b1, b2});
		if(gcb < moves){
			name = "GCB";
			moves = gcb;
		}
		
		//print result
		System.out.println(name + " " + moves);
	}
	
	public int sumUp(int[] glasses){
		return glasses[0] + glasses[1] + glasses[2] + glasses[3] + glasses[4] + glasses[5];
	}
}
