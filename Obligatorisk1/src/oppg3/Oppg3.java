package oppg3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import oppg2.Ansatt;
import oppg2.Kjonn;

public class Oppg3 {
	
	public static void main(String[] args) {
		List<Ansatt> ansatte1 = new ArrayList<>(Arrays.asList(
			    new Ansatt("Sigurd", "Ståløy", Kjonn.Mann, "Ingeniør", 850000),
			    new Ansatt("Kari", "Nordmann", Kjonn.Kvinne, "Tester", 550000),
			    new Ansatt("Alex", "Hansen", Kjonn.Annet, "Designer", 500000),
			    new Ansatt("Lise", "Berg", Kjonn.Kvinne, "Sjef", 750000),
			    new Ansatt("Jon", "Dahl", Kjonn.Mann, "Utvikler", 480000)
			));

		List<String> Ansatteetternavn = ansatte1.stream()
				.map(a -> a.getEtternavn())
				.toList();
		
		System.out.println("Ansatte etternavn:" + Ansatteetternavn.toString());
		
		long antallKvinner = ansatte1.stream()
				.filter(a -> a.getKjonn().equals("Kvinne"))
				.count();
		
		System.out.println("\nAntall kvinner: " + antallKvinner);
		
		double LonnKvinner = ansatte1.stream()
				.filter(a -> a.getKjonn().equals("Kvinne"))
				.mapToInt(a -> a.getAarslonn())
				.average()
				.orElse(0);
		
		System.out.println("\nGjennomsnittslønn for kvinner: " + LonnKvinner);
		
		ansatte1.stream()
				.filter(a -> a.getStilling().contains("sjef"))
				.forEach(a -> {
					int nyLonn = a.getAarslonn() + a.getAarslonn()/100 * 7;
					a.setAarslonn(nyLonn);
				});
		
		System.out.println("\nNye sjefslønner: " + ansatte1.toString());
		
		boolean noenMerEnn800000 = ansatte1.stream()
				.anyMatch(a -> a.getAarslonn() > 800000);
		
		System.out.println(noenMerEnn800000);
		
		ansatte1.stream()
			.forEach(a -> {
				System.out.println(a.toString());
			});
		
		int minLonn = ansatte1.stream()
				.mapToInt(a -> a.getAarslonn())
				.min()
				.orElse(0);
		
		List<Ansatt> ansatteMin = ansatte1.stream()
				.filter(a -> a.getAarslonn() == minLonn)
				.toList();
		
		System.out.println("\nAnsatte med lavest lønn: " + ansatteMin.toString());
		
		int sum = IntStream.range(1, 1000)
				.filter(i -> i%5 == 0 || i%3 == 0)
				.sum();
		
		System.out.println("\nSum av alle tall delelig med 5 eller 3 mellom 1 og 1000: " + sum);
	}
}
