package org.rivoreo.fdr.client;

class PPPoE {
	public static String[] get_ethernet_interfaces() {
		if(Platform.have_linux()) {
			return new String[] { "eth0" };
		}
		return new String[0];
	}
}
