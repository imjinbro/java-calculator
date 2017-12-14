import java.util.Scanner;

/*
 	[규칙]
 	- 연산자 우선순위 고려없음
 	- 계산기 프로그램을 만드는 이유는 객체지향적으로 짜는 연습을 하려
 	
    [자바]
 	1. equals : 객체의 주소값을 비교함 / == : 기본적으로는 equals와 같음, String일 때 차이  	
 	- String은 처음에 같은 주소값인지 비교함
 	- 같은 주소값을 가지고 있지않다면 String인지 체크(instanceof)
 	- String이라면 문자열 각 인덱스 문자를 비교함 : 같은 문자열이라면 true  	
         
    [변경]
    - IO 환경 고려없이 클래스 나누는 것에만 치중해서 코드 변경해봄 : Input, Output, Calculator
      
 */
public class Calculator {		
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);				
		Calculator calculator = new Calculator();
				
		int result = CalcInput.getValue(scanner);		
		
		while(true) {						
			String symbol = CalcInput.getSymbol(scanner);
			
			if(symbol.equals("q")) {
				calculator.printResult(result);
				scanner.close();				
				calculator = null;					
				break;
			}
														
			int num2 = CalcInput.getValue(scanner);
			
			result = calculator.calc(symbol, result, num2);
			calculator.printResult(result);
		}
		
	}
		
		
	private void printResult(int result) {
		CalcOutput.print("결과 : " + result);
	}
	
	
	public int calc(String symbol, int num1, int num2) {		
		if(symbol.equals("+")) {
			return plus(num1, num2);
		} else if(symbol.equals("-")) {
			return minus(num1, num2);
		} else if(symbol.equals("*")) {
			return multiply(num1, num2);
		} else if(symbol.equals("/")) {
			return divide(num1, num2);
		} else {
			CalcOutput.print("유효하지않은 기호입니다");
			return num1;
		}				
	}
	
	public int plus(int num1, int num2) {	
		return num1+num2;
	}
	
	public int minus(int num1, int num2) {		
		return num1-num2;
	}
	
	public int multiply(int num1, int num2) {		
		return num1*num2;
	}
	
	public int divide(int num1, int num2) {		
		return num1/num2;
	}	
}