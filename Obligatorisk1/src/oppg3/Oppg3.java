package oppg3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import oppg2.Ansatt;
import oppg2.Kjonn;

public class Oppg3 {
	
	public static void main(String[] args) {
		Ansatt a1 = new Ansatt("Ann", "test1", Kjonn.Kvinne, "blabla sjef", 700000);
		Ansatt a2 = new Ansatt("Bob", "test2", Kjonn.Mann, "Direktør", 1000000);
		Ansatt a3 = new Ansatt("Cris", "test3", Kjonn.Mann, "tull sjef", 200000);
		Ansatt a4 = new Ansatt("Dookie", "test4", Kjonn.Annet, "fikser", 300000);
		Ansatt a5 = new Ansatt("Erba", "test5", Kjonn.Kvinne, "hopper", 450000);
		
		List<Ansatt> ansatte1 = new ArrayList<>();
		ansatte1.add(a1);
		ansatte1.add(a2);
		ansatte1.add(a3);
		ansatte1.add(a4);
		ansatte1.add(a5);
		
		List<String> Ansatteetternavn = ansatte1.stream()
				.map(a -> a.getEtternavn())
				.toList();
		
		System.out.println("Ansatte etternavn:" + Ansatteetternavn.toString());
		
		long antallKvinner = ansatte1.stream()
				.filter(a -> a.getKjonn().equals("Kvinne"))
				.count();
		
		System.out.println("Antall kvinner: " + antallKvinner);
		
		double LonnKvinner = ansatte1.stream()
				.filter(a -> a.getKjonn().equals("Kvinne"))
				.mapToInt(a -> a.getAarslonn())
				.average()
				.orElse(0);
		
		System.out.println("Gjennomsnittslønn for kvinner: " + LonnKvinner);
		
		ansatte1.stream()
				.filter(a -> a.getStilling().contains("sjef"))
				.forEach(a -> {
					int nyLonn = a.getAarslonn() + a.getAarslonn()/100 * 7;
					a.setAarslonn(nyLonn);
				});
		
		System.out.println("Nye sjefslønner: " + ansatte1.toString());
		
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
		
		System.out.println("Ansatte med lavest lønn: " + ansatteMin.toString());
		
		int sum = IntStream.range(1, 1000)
				.filter(i -> i%5 == 0 || i%3 == 0)
				.sum();
		
		System.out.println("Sum av alle tall delelig med 5 eller 3 mellom 1 og 1000: " + sum);
	}
}
