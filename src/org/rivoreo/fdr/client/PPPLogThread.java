
package org.rivoreo.fdr.client;

import org.eclipse.swt.widgets.Display;

public class PPPLogThread extends Thread {
	public PPPLogThread(PPP ppp, TextReceiver receiver, Display display, Runnable handler) {
		this.ppp = ppp;
		this.receiver = receiver;
		this.display = display;
		this.handler = handler;
	}

	private PPP ppp;
	TextReceiver receiver;
	Display display;
	Runnable handler;

	public void run() {
		String line;
		while(true) {
			line = ppp.read_message(true);
			if(line == null) break;
			receiver.send_text(line);
			display.asyncExec(handler);
		}
		System.err.println("exiting PPPLogThread");
	}
}
