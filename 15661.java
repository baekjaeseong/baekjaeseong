import java.util.*;
class Main{
	static int person_num;
	static int[][] graph;
	static int min;
	static boolean[] visit;
	static void diff(){
		int[] sta = new int[person_num];
		int[] lin = new int[person_num];
		int st=0;
		int li =0;
		int x = 0;
		int y=0;
		for(int i =0; i<person_num;i++){
			if(visit[i]==true)
				sta[i] = 1;
			else
				lin[i] = 1;
		}
		for(int i =0; i<person_num;i++){
			for(int j =i+1; j<person_num;j++){
				int xx,yy;
				if(sta[i]==1&&sta[j]==1){
				xx = i;
				yy = j;
				st+=graph[xx][yy];
				st+=graph[yy][xx];
				}
				if(lin[i]==1&&lin[j]==1){
				xx = i;
				yy= j;
				li+=graph[xx][yy];
				li+=graph[yy][xx];
				}
				
			}
		}
		if(min>Math.abs(li-st)){
			min = Math.abs(li-st);
//			System.out.println(min+" "+li+" "+st);
		}
			
	}
	static void recursive(int i,int num){
		if(num<(person_num-1)&&num>0){
			diff();
		}
		if(i<person_num){
		visit[i]= true;
		recursive(i+1,num+1);
		visit[i]= false;
		recursive(i+1,num);
		}
			
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		person_num = sc.nextInt();
		graph = new int[person_num][person_num];
		for(int i = 0; i<person_num;i++){
			for(int j = 0; j<person_num;j++){
				graph[i][j] = sc.nextInt();
			}
		}
		visit = new boolean[person_num];
		min = 999999999;
		recursive(0,0);
		System.out.println(min);
	}
}
				
				

