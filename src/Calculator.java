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
         
    [개선]
    1. 값, 심볼 받아오는, 결과 출력 메서드 분리
  	
 */
public class Calculator {		
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		CalcPrinter printer = ConsoleCalcPrinter.getInstance();
		Calculator calculator = new Calculator(ConsoleCalcPrinter.getInstance());
		
				
		int result = getValue(scanner, printer);		
		
		while(true) {			
			String symbol = getSymbol(scanner, printer);
			
			if(symbol.equals("q")) {
				calculator.printResult(result);
				scanner.close();				
				calculator = null;					
				break;
			}
											
			int num2 = getValue(scanner, printer);
			
			result = calculator.calc(symbol, result, num2);
			calculator.printResult(result);
		}
		
	}
	
	public static int getValue(Scanner scanner, CalcPrinter printer) {
		printer.print("숫자를 입력해주세요");
		return scanner.nextInt();
	}
	
	public static String getSymbol(Scanner scanner, CalcPrinter printer) {
		printer.print("사칙 연산 기호 입력해주세요(종료하려면 q)");
		return scanner.next();
	}
	
	
	
	private CalcPrinter printer;
	
	public Calculator(CalcPrinter printer) {
		this.printer = printer;
	}
	
	private void printResult(int result) {
		printer.print("결과 : " + result);
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
			printer.print("유효하지않은 기호입니다");
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


/******** 계산기 전용 프린터 ********/
interface CalcPrinter{
	void print(int result);
	void print(String msg);
}

class ConsoleCalcPrinter implements CalcPrinter{
	private static ConsoleCalcPrinter printer = new ConsoleCalcPrinter();
	private ConsoleCalcPrinter() {}
	
	public static ConsoleCalcPrinter getInstance() {
		return printer;
	}
	
	@Override
	public void print(int result) {
		System.out.println(result);
	}
	
	@Override
	public void print(String msg) {
		System.out.println(msg);
	}
}

/************************************/
