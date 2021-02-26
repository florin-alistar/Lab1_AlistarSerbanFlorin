
public class Imprimanta {

	// milisecunde
	private final int pauseBetweenPages = 500;

	private boolean isFree = true;
	
	public boolean getIsFree() {
		return this.isFree;
	}
	
	public synchronized void printDocument(String docName, int copyCount) {
		
		if (!isFree) {
			return;
		}
		
		isFree = false;
		for (int i = 1; i <= copyCount; i++) {
			System.out.println("     Printing page #" + i + " of doc " + docName);
			try {
				Thread.sleep(pauseBetweenPages);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		isFree = true;
		
	}
	
}
