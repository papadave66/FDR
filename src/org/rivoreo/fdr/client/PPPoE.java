package org.rivoreo.fdr.client;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Set;
import java.util.HashSet;

class PPPoE {
	public PPPoE(PPP ppp) {
		if(ppp == null) throw new IllegalArgumentException("ppp cannot be null");
		this.ppp = ppp;
		ppp.set_mtu(1496);
		ppp.set_accomp(true);
		ppp.set_default_asyncmap(true);
		ppp.set_persist(true);
		ppp.set_lcp_echo_interval(20);
	}

	private final int MSS = 1452;

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

	public void dial(String user, String password, String _interface) {
		ppp.set_user(user);
		ppp.set_password(password);
		ppp.set_pty_command(String.format("pppoe -I %s -T 80 -m %d", _interface, MSS));
		try {
			ppp.dial();
		} catch(MissingDeviceException e) {
			// How is this possible?
			throw new RuntimeException(e);
		}
	}

	public PPP get_ppp_instance() {
		return ppp;
	}
}
