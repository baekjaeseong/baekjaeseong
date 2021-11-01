import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[50];
		int num = 0;
		int[] ma = new int[50];
		for(int i = 0 ; i<n;i++){
			String x = sc.next();
			boolean check = false;
			for(int j = 0; j<num;j++){
				//System.out.println(x+ " "+arr[j]+" "+x);
				if(x.compareTo(arr[j])==0){
					ma[j] ++;
//					System.out.println(ma[j]);
					check = true;
				}
			}
			if(check == false){
				ma[num] = 1;
				arr[num] = x;
				num++;
			}
		}
		int max = 0;
		String ans=arr[0];
		for(int i = 0; i<num;i++){
			if(max<ma[i]){
				max = ma[i];
				ans = arr[i];
			}
		}
		for(int i = 0; i<num;i++){
			if(max==ma[i]){
//				System.out.println(arr[i]+"1 "+ans+" "+arr[i].compareTo(ans));
				if(arr[i].compareTo(ans)<0)
					ans = arr[i];
			}
		}
		System.out.println(ans);
	}
}
