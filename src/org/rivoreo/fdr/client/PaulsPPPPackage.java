package org.rivoreo.fdr.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

class PaulsPPPPackage implements PPP {
	public PaulsPPPPackage() {
	}

	public PaulsPPPPackage(boolean use_pty, String device_or_command) {
		this.use_pty = use_pty;
		this.device_or_command = device_or_command;
	}

	private Process pppd_process;

	private boolean use_pty;

	private String device_or_command = null;
	private int mtu = -1;
	private String user = null;
	private String password = null;
	//private AbstractMap.SimpleEntry<String, String> chap_secret = null;
	//private AbstractMap.SimpleEntry<String, String> pap_secret = null;
	private boolean refuse_chap = false;
	private boolean refuse_pap = false;
	private boolean default_route = false;
	private boolean accomp = true;
	private boolean default_asyncmap = false;
	private int persist = -1;
	private int lcp_echo_interval = -1;
	private int lcp_echo_failure = -1;
	private int speed = -1;

	public void set_device_path(String device) {
		use_pty = false;
		device_or_command = device;
	}

	public void set_pty_command(String command) {
		use_pty = true;
		device_or_command = command;
	}

	public void set_mtu(int mtu) {
		this.mtu = mtu;
	}

	public void set_user(String user) {
		this.user = user;
	}

	public void set_password(String password) {
		this.password = password;
	}

/*
	public void set_chap(AbstractMap.SimpleEntry<String, String> secret) {
		if(secret == null) refuse_chap = true;
		else {
			refuse_chap = false;
			chap_secret = secret;
		}
	}

	public void set_pap(AbstractMap.SimpleEntry<String, String> secret) {
		if(secret == null) refuse_pap = true;
		else {
			refuse_pap = false;
			pap_secret = secret;
		}
	}
*/
	public void set_default_route(boolean v) {
		default_route = v;
	}

	public void set_accomp(boolean v) {
		accomp = v;
	}

	public void set_default_asyncmap(boolean v) {
		default_asyncmap = v;
	}

	public void set_persist(boolean v) {
		persist = v ? 1 : 0;
	}

	public void set_lcp_echo_interval(int v) {
		lcp_echo_interval = v;
	}

	public void set_lcp_echo_failure(int v) {
		lcp_echo_failure = v;
	}

	public void set_speed(int speed) {
		this.speed = speed;
	}

	public void dial() throws MissingDeviceException {
		if(device_or_command == null) throw new MissingDeviceException();
		List<String> args = new ArrayList<String>();
		args.add("pppd");
		if(mtu != -1) {
			args.add("mtu");
			args.add(String.valueOf(mtu));
		}
		if(refuse_chap) args.add("refuse-chap");
		if(refuse_pap) args.add("refuse-pap");
		args.add(default_route ? "defaultroute" : "nodefaultroute");
		if(!accomp) args.add("noaccomp");
		if(default_asyncmap) args.add("default-asyncmap");
		if(persist != -1) args.add(persist >= 1 ? "persist" : "nopersist");
		if(lcp_echo_interval != -1) {
			args.add("lcp-echo-interval");
			args.add(String.valueOf(lcp_echo_interval));
		}
		if(lcp_echo_failure != -1) {
			args.add("lcp-echo-failure");
			args.add(String.valueOf(lcp_echo_failure));
		}
		if(use_pty) {
			args.add("pty");
			args.add(device_or_command);
		} else {
			args.add(device_or_command);
			if(speed != -1) args.add(String.valueOf(speed));
		}
		if(user != null) {
			args.add("user");
			args.add(user);
		}
		if(password != null) {
			args.add("password");
			args.add(password);
		}
		args.add("nodetach");
		String[] a = new String[args.size()];
		try {
			pppd_process = Runtime.getRuntime().exec(args.toArray(a));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void hangup() {
		if(pppd_process == null) return;
		pppd_process.destroy();
	}

	public boolean is_connected() {
		if(pppd_process == null) return false;
		try {
			pppd_process.exitValue();
		} catch(IllegalThreadStateException e) {
			return true;
		}
		return false;
	}

	public String read_message() {
		if(pppd_process == null) return null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(pppd_process.getErrorStream()));
		try {
			if(!reader.ready()) return null;
			return reader.readLine();
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
