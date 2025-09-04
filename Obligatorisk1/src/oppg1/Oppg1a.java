package oppg1;

import java.util.*;

public class Oppg1a {

	public static void main(String[] args) {
		
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
	
		Collections.sort(listen, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
		
		for(String s : listen) {
			System.out.print(s + " ");
		}
	
	}
}
