package oppg2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Gikk ut ifra at lønnen skulle endres for alle under visse kriterier som kjønn osv., ikke for enkeltpersoner.

public class Oppg2 {

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funk) {
		for(Ansatt a : ansatte) {
			a.setAarslonn(funk.apply(a));
		}
	}
	
	public static void skrivUtAlle(List<Ansatt> list) {
		for(Ansatt a : list) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		Ansatt a1 = new Ansatt("Ann", "test1", Kjonn.Kvinne, "blabla", 700000);
		Ansatt a2 = new Ansatt("Bob", "test2", Kjonn.Mann, "Direktør", 1000000);
		Ansatt a3 = new Ansatt("Cris", "test3", Kjonn.Mann, "tull", 200000);
		Ansatt a4 = new Ansatt("Dookie", "test4", Kjonn.Annet, "fikser", 300000);
		Ansatt a5 = new Ansatt("Erba", "test5", Kjonn.Kvinne, "hopper", 450000);
		
		List<Ansatt> ansatte1 = new ArrayList<>();
		ansatte1.add(a1);
		ansatte1.add(a2);
		ansatte1.add(a3);
		ansatte1.add(a4);
		ansatte1.add(a5);
		
		System.out.println("Før oppgjør:");
		skrivUtAlle(ansatte1);
		
		lonnsoppgjor(ansatte1, a -> a.getAarslonn() + 1000);
		
		System.out.println("Etter kronetillegg:");
		skrivUtAlle(ansatte1);
		
		lonnsoppgjor(ansatte1, a -> a.getAarslonn() + a.getAarslonn()/100);
		
		System.out.println("Etter 1% tillegg:");
		skrivUtAlle(ansatte1);
		
		lonnsoppgjor(ansatte1, a -> {
			if(a.getAarslonn() < 300000) {
				return a.getAarslonn() + 200000;
			} else {
				return a.getAarslonn();
			}
		});
		
		System.out.println("Etter økning for lav lønn:");
		skrivUtAlle(ansatte1);
		
		lonnsoppgjor(ansatte1, a -> {
			if(a.getKjonn().equals("Mann")) {
				return a.getAarslonn() + a.getAarslonn()/100*30;
			} else {
				return a.getAarslonn();
			}
		});
		
		System.out.println("Etter økingn iht. kjønn:");
		skrivUtAlle(ansatte1);
	}
}
