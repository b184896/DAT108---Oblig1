package oppg1;

import java.util.function.BiFunction;

//Jeg skjønte ikke helt om jeg var ment til å definere nye bifunksjoner for hver av beregningene, men valgte å gå for det.

public class Oppg1b {
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> funk) {
		return funk.apply(a, b);
	}
	
	public static void main(String[] args) {
		
		int sum = beregn(12, 13, (a, b) -> a + b);
		System.out.println("Summer: " + sum);
		
		BiFunction<Integer, Integer, Integer> storste = (a, b) -> {
			if(a > b) {
				return a;
			} else {
				return b;
			}
		};
		System.out.println("Største: " + beregn(-5, 3, storste));
		
		BiFunction<Integer, Integer, Integer> absVerdi = (a, b) -> {
			int res = a - b;
			if(res < 0) {
				res = res*-1;
			}
			return res;
		};
		System.out.println("AbsVerdi: " + beregn(54, 45, absVerdi));
	}

}
