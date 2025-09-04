package oppg1;

import java.util.function.BiFunction;


public class Oppg1b {
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> operasjon) {
		return operasjon.apply(a, b);
	}

	public static void main(String[] args) {
		int sum = beregn(12, 13, (a,b) -> a+b);
		System.out.println("Summen av 12 og 13 er: " + sum);
		
		int maks = beregn(-5, 3, (a,b) -> Math.max(a, b));
		System.out.println("største av -5 og 3 er: " + maks);
		
		int lengde = beregn(54, 45, (a,b) -> Math.abs(a-b));
		System.out.println("absolutt lengde mellom 54 og 45 er: " + lengde);
	
	}

}

