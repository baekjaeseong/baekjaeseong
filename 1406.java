import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		String arr = sc.next();
		int x = sc.nextInt();
		int nu = arr.length();
		Stack<String> leftst = new Stack<String>();
		Stack<String> rightst = new Stack<String>();
		for(String s : arr){
			leftst.push(s);
		}
		for(int i = 0; i<x;i++){
			String  arr_2 = sc.next();
			if(arr_2.charAt(0)=='L')
			{
				if(nu>0)
				rightst.push(leftst.pop());
			}
			else if(arr_2.charAt(0)=='D')
			{
				if(nu<arr.length())
					leftst.push(rightst.pop());
			}
			else if(arr_2.charAt(0)=='B'){
				if(nu>0){
					leftst.pop();
				}
			//	System.out.println(arr);
			}
			else if(arr_2.charAt(0) == 'P'){
				arr_2 = sc.next();
				leftst.pop(arr_2);
			}

		}
		while(!leftst.isEmpty())
			rightst.push(leftst.pop());
		while(!leftst.isEmpty())
			rightst.push(leftst.pop());
		System.out.println(arr);
	}
}
