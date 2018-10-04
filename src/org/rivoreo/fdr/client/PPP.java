package org.rivoreo.fdr.client;

import java.util.HashMap;

interface PPP {
	//PPP();
	//PPP(boolean use_pty, String device_or_command);
	void set_device_path(String device);
	void set_pty_command(String command);
	void set_mtu(int mtu);
	void set_chap(HashMap<String, String> secrets);
	void set_pap(HashMap<String, String> secrets);
	void set_default_route(boolean v);
	void set_accomp(boolean v);
	void set_default_asyncmap(boolean v);
	void set_persist(boolean v);
	void set_speed(int speed);
	void dial();
	void hangup();
	boolean is_connected();
}
