
package org.rivoreo.fdr.client;

public class PPPLogThread extends Thread {
	public PPPLogThread(PPP ppp) {
		this.ppp = ppp;
	}

	private PPP ppp;

	public void run() {
		String line;
		while(true) {
			line = ppp.read_message(true);
			if(line == null) break;
		}
		System.err.println("exiting PPPLogThread");
	}
}
