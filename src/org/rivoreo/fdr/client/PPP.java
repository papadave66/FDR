package org.rivoreo.fdr.client;

//import java.util.AbstractMap;

interface PPP {
	void set_device_path(String device);
	void set_pty_command(String command);
	void set_mtu(int mtu);
	void set_user(String user);
	void set_password(String password);
	//void set_chap(AbstractMap.SimpleEntry<String, String> secret);
	//void set_pap(AbstractMap.SimpleEntry<String, String> secret);
	void set_default_route(boolean v);
	void set_accomp(boolean v);
	void set_default_asyncmap(boolean v);
	void set_persist(boolean v);
	void set_lcp_echo_interval(int v);
	void set_lcp_echo_failure(int v);
	void set_speed(int speed);
	void dial() throws MissingDeviceException;
	void hangup();
	boolean is_connected();
	String read_message(boolean blocking);
}
