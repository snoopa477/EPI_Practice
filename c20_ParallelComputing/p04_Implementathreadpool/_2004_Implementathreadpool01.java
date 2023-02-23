package c20_ParallelComputing.p04_Implementathreadpool;

import static java.lang.System.out;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class _2004_Implementathreadpool01 {

	public static class SingleThreadWebServer {
		public static final int PORT = 8080;

		public static void main(String[] args) throws IOException {
			ServerSocket serversock = new ServerSocket(PORT);
			for (;;) {
				Socket sock = serversock.accept();
				processReq(sock);

			}

		}
	}
}
