package org.rivoreo.fdr.client;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Set;
import java.util.HashSet;

class PPPoE {
	public static String[] get_ethernet_interfaces() {
		Set<String> if_set = new HashSet<String>();
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while(interfaces.hasMoreElements()) {
				NetworkInterface i = interfaces.nextElement();
				System.err.println(i);
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
