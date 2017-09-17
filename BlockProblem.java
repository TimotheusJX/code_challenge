import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BlockProblem {
    public static int numberBlocks;
    public static Stack<Integer> blocks[];
    public static int position[];
    public static String line, firstWord, secondWord; 
    public static int a, b;
    
	public static void main(String[] args) throws Exception{
		BlockProblem blockProblem = new BlockProblem();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try{	
		numberBlocks = Integer.parseInt(input.readLine());
		blocks = new Stack[numberBlocks];
		position = new int[numberBlocks];
		//initialize 
		for(int i = 0; i < numberBlocks; i++){
			blocks[i] = new Stack<Integer>();
			blocks[i].push(i);
			position[i] = i;
		}
		line ="";
		while(!(line = input.readLine()).equals("quit")){
			blockProblem.printResult();
			StringTokenizer stringInput = new StringTokenizer(line);
			firstWord = stringInput.nextToken();
			a = Integer.parseInt(stringInput.nextToken());
			secondWord = stringInput.nextToken();
			b = Integer.parseInt(stringInput.nextToken());
			
			if(a == b || position[a] == position[b]) continue;
			if(firstWord.equals("move")){
				if(secondWord.equals("onto")){
					blockProblem.moveOnto(a, b);
				}else{
					blockProblem.moveOver(a, b);
				}
			}else{
				if(secondWord.equals("onto")){
					blockProblem.pileOnto(a, b);
				}else{
					blockProblem.pileOver(a, b);
				}
			}
		}
		blockProblem.printResult();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void moveOnto(int firstNum, int secondNum){
		clearAbove(secondNum);
		moveOver(firstNum, secondNum);
	}
	
	public void moveOver(int firstNum, int secondNum){
		clearAbove(firstNum);
		blocks[secondNum].push(blocks[position[firstNum]].pop());
		position[firstNum] = secondNum; 
	}
	
	public void pileOnto(int firstNum, int secondNum){
		clearAbove(secondNum);
		pileOver(firstNum, secondNum);
	}
	
	public void pileOver(int firstNum, int secondNum){
		//create a temporary pile for transfer
		Stack<Integer> tempBlock = new Stack<Integer>();
		
		while(!blocks[position[firstNum]].peek().equals(firstNum)){
			tempBlock.push(blocks[position[firstNum]].pop());
		}
		tempBlock.push(blocks[position[firstNum]].pop());
		while(!tempBlock.isEmpty()){
			int oneItem = tempBlock.pop();
			blocks[secondNum].push(oneItem);
			position[oneItem] = secondNum;
		}
	}
	
	public void clearAbove(int block){
		//find the stack that contains the block 
		int stackNumOfSingleBlock = findPosition(block);
		while(!blocks[stackNumOfSingleBlock].peek().equals(block)){
			int oneRemove = blocks[stackNumOfSingleBlock].pop();
			blocks[oneRemove].push(oneRemove); //add back to initial pile
			position[oneRemove] = oneRemove;  
		}
	}
	
	public int findPosition(int blockNum){
		for(int i = 0; i < blocks.length; i++){
			if(blocks[i].contains(blockNum)){
				return i;
			}
		}
		return -1;
	}
	
	public void printResult(){
		for (int i = 0; i < blocks.length; i++){
			System.out.print(i + ":");
			for(int j : blocks[i]){
				System.out.print(" " + j);
			}
			System.out.print("\n");
		}
	}
}
