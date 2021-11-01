import java.util.*;
class Main{
	static int num;
	static double a_ ;
	static double b_ ;
	static double c_ ;
	static double d_ ;
	static double sum;
	static void find_(boolean[][] visit,int x, int y, int number,double answer){
			if(number==num){
				sum+= answer;
			}
			else if(number<num){
				visit[y][x] = true;
				if(a_!=0&&visit[y][x-1]==false){
					find_(visit,x-1,y,number+1,answer*a_);
					visit[y][x-1] = false;
				}
				if(b_!=0&&visit[y][x+1]==false){
					 find_(visit,x+1,y,number+1,answer*b_);
					visit[y][x+1] = false;
				}
				if(c_!=0&&visit[y+1][x]==false){
					 find_(visit,x,y+1,number+1,answer*c_);
					visit[y+1][x] = false;
				}
				if(d_!=0&&visit[y-1][x]==false){
					 find_(visit,x,y-1,number+1,answer*d_);
					visit[y-1][x] = false;
				}


			}

	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		sum = 0;
		a_ = a*0.01;
		b_ = b*0.01;
		c_ = c*0.01;
		d_ = d*0.01;
		boolean[][] visit = new boolean[30][30];
		double ans = 0;
		visit[15][15] = true;
		find_(visit,15,15,0,1.0);
		/*find_(visit,16,15,1,1.0*b_);
		find_(visit,15,16,1,1.0*c_);
		find_(visit,15,14,1,1.0*d_);
*/
		System.out.println(sum);
	}
}


