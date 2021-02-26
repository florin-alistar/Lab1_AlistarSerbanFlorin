import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		
		Imprimanta imprimanta = new Imprimanta();
		List<Functionar> functionari = new ArrayList<Functionar>();
		for (int i = 1; i <= 8; i++) {
			functionari.add(new Functionar(imprimanta, i));
		}
		
		for (Functionar func: functionari) {
			func.start();
		}
		
	}

}
