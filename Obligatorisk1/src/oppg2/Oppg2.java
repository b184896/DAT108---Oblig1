package oppg2;

import java.util.ArrayList;
import java.util.Arrays;
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
		List<Ansatt> ansatte1 = new ArrayList<>(Arrays.asList(
			    new Ansatt("Sigurd", "Ståløy", Kjonn.Mann, "Ingeniør", 850000),
			    new Ansatt("Kari", "Nordmann", Kjonn.Kvinne, "Tester", 550000),
			    new Ansatt("Alex", "Hansen", Kjonn.Annet, "Designer", 500000),
			    new Ansatt("Lise", "Berg", Kjonn.Kvinne, "Sjef", 750000),
			    new Ansatt("Jon", "Dahl", Kjonn.Mann, "Utvikler", 480000)
			));

		System.out.println("Før oppgjør:");
		skrivUtAlle(ansatte1);
		
		lonnsoppgjor(ansatte1, a -> a.getAarslonn() + 1000);
		
		System.out.println("\nEtter kronetillegg:");
		skrivUtAlle(ansatte1);
		
		lonnsoppgjor(ansatte1, a -> (int)(a.getAarslonn()*1.15));
		
		System.out.println("\nEtter 15% tillegg:");
		skrivUtAlle(ansatte1);
		
		lonnsoppgjor(ansatte1, a -> {
			if(a.getAarslonn() < 300000) {
				return a.getAarslonn() + 200000;
			} else {
				return a.getAarslonn();
			}
		});
		
		System.out.println("\nEtter økning for lav lønn:");
		skrivUtAlle(ansatte1);
		
		lonnsoppgjor(ansatte1, a -> {
			if(a.getKjonn().equals("Mann")) {
				return a.getAarslonn() + a.getAarslonn()/100*30;
			} else {
				return a.getAarslonn();
			}
		});
		
		System.out.println("\nEtter økingn iht. kjønn:");
		skrivUtAlle(ansatte1);
	}
}
