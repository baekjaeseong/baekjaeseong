import java.util.*;
class Main{
	static int X,Y,num;
	static int[][] ans;
	static int[][] arr;
	static int cir_num;
	static void circular(int y2, int x2,int start){
		int nu = cir_num;
		if(X>1&&Y>1)
		{
			int sum = X*2+Y*2-start*4-4;
			while(sum<=nu){
				nu-=sum;
			}		
		}

		int y = y2;
		int x = x2;
//		System.out.println(nu+" "+arr[y][x]);
		while(nu>0){
//			if(arr[y2][x2] ==14)
//				System.out.println(y+" "+x+" "+nu+ " "+start+" "+y2+" "+x2);
			if(X==Y&&(Y-1)==start)
			break;	
//
			if(y==Y-1){
				if(x==X-1){
					y--;
				}
				else
				{
					x++;
				}
			}
			else if(x==X-1){
				if(y==start)
					x--;
				else
					y--;
			}
			else if(x==start){
				y++;

			}
			else if(y==start)
				x--;
			nu--;
		}
	//	System.out.println(y+" "+x+ " "+Y+" "+X+" "+start);
		ans[y][x] = arr[y2][x2];

	}
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		cir_num = sc.nextInt();
		arr = new int[Y][X];
		for(int i = 0; i<Y;i++){
			for(int j = 0; j<X;j++){
				arr[i][j] = sc.nextInt();
			}
		}
		int start = 0 ;
		int min = Y>X? X:Y;
		num = (min+1)/2;
		ans = new int[Y][X];
		int YY = Y;
		int XX = X;

		for(int i = 0; i<num;i++){
			for(int y = start; y<Y;y++){
				if(y==start || y==(Y-1)){
					for(int x = start; x<X;x++){
						circular(y,x,start);
					}
				}
				else
				{
					circular(y,start,start);
					circular(y,X-1,start);
				}
			}
			Y--;X--;
			start++;
		}
		for(int i = 0; i<YY;i++){
			for(int j = 0; j<XX;j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}
