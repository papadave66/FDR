package org.rivoreo.fdr.client;

import java.util.AbstractMap;

class PualsPPPPackage implements PPP {
	public PualsPPPPackage() {
	}

	public PualsPPPPackage(boolean use_pty, String device_or_command) {
		this.use_pty = use_pty;
		this.device_or_command = device_or_command;
	}

	private boolean use_pty;

	private String device_or_command = null;
	private int mtu = -1;
	private AbstractMap.SimpleEntry<String, String> chap_secret = null;
	private AbstractMap.SimpleEntry<String, String> pap_secret = null;
	private boolean refuse_chap = false;
	private boolean refuse_pap = false;
	private boolean default_route;
	private boolean accomp;
	private boolean default_asyncmap;
	private boolean persist;
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
		persist = v;
	}

	public void set_speed(int speed) {
		this.speed = speed;
	}

	public void dial() throws MissingDeviceException {
		if(device_or_command == null) throw new MissingDeviceException();
	}

	public void hangup() {
	}

	public boolean is_connected() {
		return false;
	}
}
