import java.util.ArrayList;
import java.util.List;

import prob4.strcapete.StrProcessor;
import prob4.strcapete.StrWrapper;

public class MainClass {

	public static void main(String[] args) {
		
		exImprimante();
		
		//exStringCeleDouaCapete();
	}
	
	private static void exImprimante() {
		Imprimanta imprimanta = new Imprimanta();
		List<Functionar> functionari = new ArrayList<Functionar>();
		for (int i = 1; i <= 8; i++) {
			functionari.add(new Functionar(imprimanta, i));
		}
		
		for (Functionar func: functionari) {
			func.start();
		}
	}
	
	private static void exStringCeleDouaCapete() {
		StrWrapper strWrapper = new StrWrapper("TheQuickBrownFoxJumpsOverTheLazyDog");
		StrProcessor strProcStDr = new StrProcessor(strWrapper, 1, 1);
		StrProcessor strProcDrSt = new StrProcessor(strWrapper, 2, -1);
		strProcStDr.start();
		strProcDrSt.start();
	}

}
