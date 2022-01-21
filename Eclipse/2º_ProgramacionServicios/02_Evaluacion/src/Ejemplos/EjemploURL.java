package Ejemplos;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjemploURL {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress dir = InetAddress.getByName("www.google.es");
		System.out.println(dir);
	}
}
