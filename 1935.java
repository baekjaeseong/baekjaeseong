import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String hu = sc.next();
		double[] arr = new double[n];
		for(int i = 0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		Stack<Double> sta = new Stack<Double>();
		int x = hu.charAt(0);
		double temp = arr[hu.charAt(0)-65];
		sta.push(temp);
		temp = arr[hu.charAt(1)-65];
		sta.push(temp);

		for(int i=  2; i<hu.length();i++){
			if(hu.charAt(i)=='+'){
				double a = sta.pop();
				double b = sta.pop();
				sta.push(a+b);
			}
			else if(hu.charAt(i)=='-'){
				double a = sta.pop();
				double b = sta.pop();
				sta.push(b-a);
			}
			else if(hu.charAt(i)=='*'){
				double a = sta.pop();
				double b = sta.pop();
				sta.push((b)*(a));
			}
			else if(hu.charAt(i)=='/'){
				double a = sta.pop();
				double b = sta.pop();
				sta.push((b)/(a));
			}
			else{
				temp = arr[hu.charAt(i)-65];
				sta.push(temp);
			}
		}
		
		System.out.printf("%.2f",sta.pop());
	}
}
