package demo.jili;
/**
 * 
 * @author jili
 * 中缀表达式转换后缀表达式
 * 优先级队列
 *
 */
public class DemoJ_stackX {
	private int top;
	private char[] stackArray;
	private int maxSize;
	
	public DemoJ_stackX(int maxSize) {
		this.top=-1;
		this.maxSize=maxSize;
		this.stackArray=new char[this.maxSize];
		 
	}
	
	
	public void push(char c){//字符压入栈，
		stackArray[++top]=c;
	}
	
	public char pop(){//字符移除栈
		return stackArray[top--];
	}
	
	public char peek(){//查看栈顶字符
		return stackArray[top];
	}
	
	public boolean isnull(){
		return top==-1;
	}
	
	public boolean isfull(){
		return top==maxSize-1;
	}
	
	
	public int size(){
		return top-1;
	}
	public char peekN(int n){
		return stackArray[n];
		
	}
	
	public void displayStack(String s){
		System.out.println(s);
		System.out.println("--------------------------------");
		for(int j=0;j<size();j++){
			System.out.print(peekN(j));
			System.out.println(' ');
			
		}
	}
	

}
