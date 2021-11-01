import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		String str = sc.next();
		int strlen = str.length();
		Stack<Character> st = new Stack<Character>();

		for(int i = 0; i<strlen;i++){
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
				System.out.print(str.charAt(i));
			}
			else if(str.charAt(i)=='('){
				st.push(str.charAt(i));
			}
			else if(str.charAt(i)==')'){
				while(!st.isEmpty())
				{
					if(st.peek()=='('){
						st.pop();
						break;
					}
					System.out.print(st.pop());
				}
			}
			else 
			{

				if(!st.isEmpty() && (st.peek()=='*'||st.peek()=='/')){
					if(str.charAt(i)=='*'||str.charAt(i)=='/'){
						System.out.print(st.pop());
						st.push(str.charAt(i));

					}
					else{
						while(!st.isEmpty()){
							if(st.peek()!='(')
								System.out.print(st.pop());
							else
								break;

						}
						st.push(str.charAt(i));
					}
				}
				else if(!st.isEmpty()&&(st.peek()=='+' ||st.peek()=='-')&&(str.charAt(i)=='+'||str.charAt(i)=='-'))
				{
					while(!st.isEmpty()){
						if(st.peek()!='(')
							System.out.print(st.pop());
						else
							break;
					}
					st.push(str.charAt(i));
				}
				else
					st.push(str.charAt(i));



			}

		}
		while(!st.isEmpty()){
			System.out.print(st.pop());
		}
	}
}
