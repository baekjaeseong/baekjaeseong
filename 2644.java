import java.util.*;
class Main{
	static boolean[] visit;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int z = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int m = sc.nextInt();
		visit = new boolean[z+1];
		int[][] per = new int[z+1][z+1];
		for(int i = 0; i<m;i++){
			int q = sc.nextInt();
			int p = sc.nextInt();
			per[q][p] = 1;
			per[p][q] = 1;
		}
		Queue<Integer> q =new LinkedList<Integer>();
		q.add(x);
		visit[x] = true;
		q.add(0);
		int w = 0;
		while(!q.isEmpty()){
			int c = q.poll();
			int l = q.poll();
			if(c==y){
				w++;
			//	System.out.println(l);
				break;
			}
			for(int i = 0; i<z+1;i++){
				System.out.println(c+" "+i + " "+ visit[i]);
				if(per[c][i] ==1&&visit[i]==false){
					visit[i] = true;
					q.add(i);
					q.add(l+1);
			//		System.out.println(i);
				}

			}

		}
		if(w==0)
			System.out.println(-1);


	}
}

