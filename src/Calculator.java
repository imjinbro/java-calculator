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
     
 	[현재 코드 문제점]
 	1. 입력 숫자가 여러개 일 때
 	2. 연산자 분기 : if ~ else 떡
 	
 */
public class Calculator {		
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in); //Stream은 byte, char 단위 통
		System.out.println("첫번째 값 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println("사칙연산 기호 : ");
		String symbol = sc.next();
			
		System.out.println("두번째 값 입력 : ");
		int num2 = sc.nextInt();
	
		Calculator calculator = new Calculator(ConsoleCalcPrinter.getInstance());		
		calculator.calc(symbol, num1, num2);
		
	}
	private CalcPrinter printer;
	
	public Calculator(CalcPrinter printer) {
		this.printer = printer;
	}
	
	private void print(int result) {
		printer.print(result);
	}
	
	private void print(String msg) {
		printer.print(msg);
	}
	
	public void calc(String symbol, int num1, int num2) {
		if(symbol.equals("+")) {
			plus(num1, num2);
		} else if(symbol.equals("-")) {
			minus(num1, num2);
		} else if(symbol.equals("*")) {
			multiply(num1, num2);
		} else if(symbol.equals("/")) {
			divide(num1, num2);
		} else {
			print("유효하지않은 기호입니다");
		}
	}
	
	public void plus(int num1, int num2) {	
		print(num1+num2);
	}
	
	public void minus(int num1, int num2) {		
		print(num1-num2);
	}
	
	public void multiply(int num1, int num2) {		
		print(num1*num2);
	}
	
	public void divide(int num1, int num2) {		
		print(num1/num2);
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
