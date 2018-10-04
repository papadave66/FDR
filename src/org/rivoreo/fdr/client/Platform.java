package org.rivoreo.fdr.client;

public class Platform {
	private static boolean _have_linux = System.getProperty("os.name").equals("Linux");
	public static boolean have_linux() {
		return _have_linux;
	}
}
