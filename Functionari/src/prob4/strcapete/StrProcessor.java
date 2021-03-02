package prob4.strcapete;

import java.util.Random;

public class StrProcessor extends Thread{

	private StrWrapper strWrapper;
	private int nr;
	private Random rand = new Random();
	// 1 pentru parcurgere st->dr
	// -1 pentru dr->str
	private int direction;
	
	public StrProcessor(StrWrapper wrapper, int nr, int direction) {
		this.strWrapper = wrapper;
		this.nr = nr;
		this.direction = direction;
	}
	
	@Override
	public void run() {
		
		int strLen = strWrapper.getTextLength();
		int start = direction == 1 ? 0 : strLen - 1;
		int pos = start;
		while (pos >= 0 && pos < strLen) {
			
			try {
				Thread.sleep(rand.nextInt(200));
			}catch(Exception ex) {
			}
			
			while (strWrapper.getIsCurrentlyProcessed()) {
				//System.out.println("Thread #" + nr + " asteapta...");
				synchronized(strWrapper) {
					try {
						strWrapper.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			synchronized(strWrapper) {
				int chReadLen = 1 + rand.nextInt(4);
				System.out.println("Thread #" + nr + " --> " + pos + " " + chReadLen);
				strWrapper.processChars(nr, pos, chReadLen, direction);
				strWrapper.notifyAll();
				pos += direction * chReadLen;
			}
			
		}
		
		//System.out.println("Thread-ul #" + nr + " a terminat treaba...");
	}
	
}
