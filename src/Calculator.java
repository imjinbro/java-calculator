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
    1. 실행시키고 싶은 만큼 계산할 수 있음 : while - 탈출문  
 	2. 프린터가 어떤 것이냐에 따라서 알아서 프린트되도록 : 입력값 물을 때도
 	3. 계속해서 계산할 수 있도록 함
 	- 첫번째 값 입력 후 사칙연산 입력 에러인 경우 첫번째 값 유지
  	
 */
public class Calculator {		
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		CalcPrinter printer = ConsoleCalcPrinter.getInstance();
		Calculator calculator = new Calculator(ConsoleCalcPrinter.getInstance());
		
		printer.print("숫자를 입력해주세요");			
		int result = scanner.nextInt();		
		
		while(true) {
			printer.print("사칙 연산 기호 입력해주세요(종료하려면 q)");
			String symbol = scanner.next();
			
			if(symbol.equals("q")) {
				scanner.close();
				calculator = null;	
				printer.print("계산기 종료 - 최종결과 : " + result);
				break;
			}
									
			printer.print("숫자를 입력해주세요");
			int num2 = scanner.nextInt();
			
			result = calculator.calc(symbol, result, num2);
			calculator.printResult(result);
		}
		
	}
	
	
	private CalcPrinter printer;
	
	public Calculator(CalcPrinter printer) {
		this.printer = printer;
	}
	
	private void printResult(int result) {
		printer.print(result);
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
