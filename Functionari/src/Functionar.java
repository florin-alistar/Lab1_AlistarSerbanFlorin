import java.util.Random;

public class Functionar extends Thread {

	private Imprimanta imprimanta;
	private int nr;
	private Random rand = new Random();
	
	public Functionar(Imprimanta imprimanta, int nrFunc) {
		this.imprimanta = imprimanta;
		this.nr = nrFunc;
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(1000 + rand.nextInt(5000));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			while (!imprimanta.getIsFree()) {
				try {
					synchronized (imprimanta) {
						imprimanta.wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			synchronized(imprimanta) {
				String docName = "Document func #" + nr;
				int copyCount = 1 + rand.nextInt(3);
				System.out.println("Functionar #" + nr + " printeaza acum...");
				this.imprimanta.printDocument(docName, copyCount);
				System.out.println();
				imprimanta.notifyAll();
			}
		}
		
	}
	
}
