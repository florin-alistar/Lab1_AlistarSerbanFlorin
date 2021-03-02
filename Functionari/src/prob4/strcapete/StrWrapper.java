package prob4.strcapete;

public class StrWrapper {

	private String text;
	private boolean isCurrentlyProcessed = false;
	private int processTime = 200;
	
	public boolean getIsCurrentlyProcessed() {
		return this.isCurrentlyProcessed;
	}
	
	public StrWrapper(String text) {
		this.text = text;
	}
	
	public int getTextLength() {
		return text.length();
	}
	
	// afiseaza caractere
	public synchronized void processChars(int thID, int start, int count, int di) {
		
		if (isCurrentlyProcessed) {
			return;
		}
		
		isCurrentlyProcessed = true;
		
		int i = start;
		int stop = start + count * (int)Math.signum(di);
		while (i >= 0 && i < text.length()) {
			
			if (i == stop) {
				break;
			}
			
			System.out.println("Thread-ul #" + thID + " afiseaza caracterul #" + i + ": "
					+ text.charAt(i));
			i += di;
			try {
				Thread.sleep(processTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		isCurrentlyProcessed = false;
	}
	
}
