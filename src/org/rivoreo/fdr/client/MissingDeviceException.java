package org.rivoreo.fdr.client;

class MissingDeviceException extends Exception {
	public MissingDeviceException() {
		super("Missing device to run PPP");
	}
}
