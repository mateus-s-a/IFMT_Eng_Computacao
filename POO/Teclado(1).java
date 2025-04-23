import java.util.Locale;
import java.util.Scanner;

public class Teclado {
	public static int lerInteiro(String rotulo) {
		System.out.println(rotulo);
		Scanner teclado = new Scanner(System.in);
		return teclado.nextInt();
	}
	public static double lerDouble(String rotulo) {
		System.out.println(rotulo);
		Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
		return teclado.nextDouble();
	}
	public static String lerString(String rotulo) {
		System.out.println(rotulo);
		Scanner teclado = new Scanner(System.in);
		return teclado.nextLine();
	}
}