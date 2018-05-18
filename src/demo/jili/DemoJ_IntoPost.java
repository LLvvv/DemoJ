package demo.jili;

public class DemoJ_IntoPost {
	private DemoJ_stackX stackX;
	private String input;
	private String output="";
	public DemoJ_IntoPost(String in) {
		input = in;
		int stackSize = input.length();
		stackX = new DemoJ_stackX(stackSize);
	}
	public String  doTrain(){
		for(int i =0;i<input.length();i++){
			char ch = input.charAt(i);
			stackX.displayStack("For "+ch+" ");
			switch(ch){
			case '+':
			case '-':
				gotOper(ch,1);
				break;
			case '*':
			case '/':
				gotOper(ch,2);
				break;
			case '(':
				stackX.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output = output+ch;
				break;
				
			
			}//end switch
		}//end for
		while(!stackX.isnull()){
			stackX.displayStack("While");
			
			output=output+stackX.pop();
			
		}
		stackX.displayStack("end   ");
		return output;
	}
	
	public void gotOper(char opThis,int prec1){
		while(!stackX.isnull()){
			char opTop = stackX.pop();
			if(opTop=='('){
				stackX.push(opTop);
				break;
				
			}else{
				int prec2;
				if(opTop=='+'||opTop=='-'){
					prec2=1;
				}else{
					prec2=2;
				}
				if(prec2<prec1){
					stackX.push(opTop);
					break;
				}else{
					output=output+opTop;
				}
				
				
			}
		}
		stackX.push(opThis);
		
	}
	public void gotParen(char ch){
		while(!stackX.isnull()){
			char chx = stackX.pop();
			if(chx=='(')
				break;
			else
				output=output+chx;
			
		}
	}

}
