import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] arr = new int[x];
		int num = 0;
		for(int i = 0; i<x;i++){
			arr[i] = sc.nextInt();
		}
		Stack<Integer> sq = new Stack<Integer>();
		int j = 1;
		sq.add(j++);
			System.out.println("+");
		while(!sq.isEmpty()){
			int xx = arr[num];
			int an = sq.pop();
			if(an ==xx)
			{
				num++;
				System.out.println("-");
			}
			else
			{
				System.out.println("+");
				sq.add(an);
				sq.add(j++);
			}

		}
	}
}
