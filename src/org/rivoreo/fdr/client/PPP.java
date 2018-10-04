package org.rivoreo.fdr.client;

import java.util.AbstractMap;

interface PPP {
	//PPP();
	//PPP(boolean use_pty, String device_or_command);
	void set_device_path(String device);
	void set_pty_command(String command);
	void set_mtu(int mtu);
	void set_chap(AbstractMap.SimpleEntry<String, String> secret);
	void set_pap(AbstractMap.SimpleEntry<String, String> secret);
	void set_default_route(boolean v);
	void set_accomp(boolean v);
	void set_default_asyncmap(boolean v);
	void set_persist(boolean v);
	void set_speed(int speed);
	void dial() throws MissingDeviceException;
	void hangup();
	boolean is_connected();
}
