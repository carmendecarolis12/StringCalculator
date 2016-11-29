package it.uniba.tdd;

public class StringCalculator {
	
	public static int add(String numbersStr) throws StringCalculatorException  {
		int sum = 0; 
		String delimiter = ",|\\n";
		
		if (numbersStr == ""){
			return 0; // in caso di stringa vuota
		}
		
		if (numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/'){ //separatori speciali
			String[] sepSpe = numbersStr.split("\n|//");
			delimiter = sepSpe[1]; 
			String[] sepNewLine = numbersStr.split("\n");
			numbersStr = sepNewLine[1];
			
		}
		String[] sep = numbersStr.split(delimiter);
		
		for (String string : sep) { //caso base
			/*if (Integer.parseInt(string) < 0 && Integer.parseInt(string) > 1000){
				throw new StringCalculatorException(); */
			
			if (string.isEmpty()){ // ,\n oppure \n,
				throw new StringCalculatorException();
			}
			if(Integer.parseInt(string)>= 0 && Integer.parseInt(string)<1000){	
			 sum += Integer.parseInt(string);
			}
		}
			
		return sum;
	}
}