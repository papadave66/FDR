package org.rivoreo.fdr.client;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

class PPPoE {
	private static String[] get_ethernet_interfaces_from_ifconfig() {
		System.err.println("method: get_ethernet_interfaces_from_ifconfig()");
		Set<String> if_set = new HashSet<String>();
		try {
			Process p = Runtime.getRuntime().exec(new String[] { "ifconfig", "-a" });
			System.err.println(p);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while((line = reader.readLine()) != null) {
				System.err.println(line);
				if(!Character.isLetter(line.charAt(0))) continue;
				int colon_i = line.indexOf(':');
				if(colon_i == -1) continue;
				if_set.add(line.substring(0, colon_i));
			}
		} catch(IOException e) {
			e.printStackTrace();
			return new String[0];
		} 
		String[] a = new String[if_set.size()];
		return if_set.toArray(a);
	}

	public static String[] get_ethernet_interfaces() {
		if(Platform.have_linux()) {
			return new String[] { "eth0" };
		} else {
			return get_ethernet_interfaces_from_ifconfig();
		}
	}
}
