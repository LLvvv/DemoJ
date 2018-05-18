package demo.jili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DemoJ_InfixApp {
	public static void main(String[] args) throws Exception {
		String input,output;
		while(true){
			System.out.println("Enter infix:  ");
			System.out.flush();
			input=getString();
			if(input.equals(""))
				break;
			
			DemoJ_IntoPost theTrans = new DemoJ_IntoPost(input);
			output=theTrans.doTrain();
			System.out.println("postfix is " +output +"\n");
			
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
