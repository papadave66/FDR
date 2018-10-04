package org.rivoreo.fdr.client;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Set;
import java.util.HashSet;

class PPPoE {
	public PPPoE(PPP ppp) {
		this.ppp = ppp;
		ppp.set_mtu(1496);
		ppp.set_accomp(true);
		ppp.set_default_asyncmap(true);
		ppp.set_persist(true);
	}

	private PPP ppp;

	public static String[] get_ethernet_interfaces() {
		Set<String> if_set = new HashSet<String>();
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while(interfaces.hasMoreElements()) {
				NetworkInterface i = interfaces.nextElement();
				System.err.println(i);
				if(i.isVirtual()) continue;
				if(i.isLoopback()) continue;
				if(i.isPointToPoint()) continue;
				if_set.add(i.getName());
			}
		} catch(SocketException e) {
			e.printStackTrace();
			return new String[0];
		}
		String[] a = new String[if_set.size()];
		return if_set.toArray(a);
	}
}
