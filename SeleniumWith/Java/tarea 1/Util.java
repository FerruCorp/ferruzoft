package tarea;

public class Util {

	public void sleep(int millis) throws InterruptedException{
		
		Thread.sleep(millis);	
		
	}	
	
	public void printMessage(String message){
		
		System.out.println(message);
		
	}	

	public String getNumber(String result){
		
		boolean flag = true;
		
		String number = result.substring(0,result.indexOf('(')-1);
		
		while(flag){
			
			number = number.substring(number.indexOf(" ")+1, number.length());
			
			Character aux = number.charAt(0);
			
			if(Character.isDigit(aux)){
				
				flag = false;				
				
			}
			
		}
		
		return number.substring(0, number.indexOf(" "));
		
	}
}
