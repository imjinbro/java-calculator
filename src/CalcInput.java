import java.util.Scanner;

public class CalcInput {
	
	public static int getValue(Scanner scanner) {
		System.out.println("숫자를 입력해주세요");
		return scanner.nextInt();
	}
	
	public static String getSymbol(Scanner scanner) {
		System.out.println("사칙 연산기호를 입력해주세요");
		return scanner.next();
	}
}
