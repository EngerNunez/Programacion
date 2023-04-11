package Socket;

import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Servidor extends Thread {

	public static void main(String args[]) {
		ServerSocket sfd = null;
		try {
			sfd = new ServerSocket(7000);
		} catch (IOException ioe) {
			System.out.println("Comunicaci�n rechazada." + ioe);
			System.exit(1);
		}

		while (true) {
			try {
				Socket nsfd = sfd.accept();
				System.out.println("Conexion aceptada de: " + nsfd.getInetAddress());
				DataInputStream oos = new DataInputStream((nsfd.getInputStream()));
				DataOutputStream escritor = new DataOutputStream(new FileOutputStream(new File("Resplado/empresa_respaldo.dat")));
				int unByte;
				try {
					while ((unByte = oos.read()) != -1)
						escritor.write(unByte);
					oos.close();
					escritor.close();

				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} catch (IOException ioe) {
				System.out.println("Error: " + ioe);
			}
		}
	}
}