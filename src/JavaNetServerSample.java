import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */

/**
 * @author t.yoshizawa
 *
 */
public class JavaNetServerSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int port = 5000;
		ServerSocket server = null;
		Socket soc = null;
		BufferedReader in = null;
		PrintWriter out = null;

		// 1 ServerSocket

		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("ServerSocket��new����Ƃ���ŗ�O");
			e.printStackTrace();
		}

		// 2 Accept
		try {
			soc = server.accept();
		} catch (IOException e) {
			System.out.println("ServerSocket��accept����Ƃ���ŗ�O");
			e.printStackTrace();
		}

		// 3 in
		try {
			InputStreamReader isr = null;
			isr = new InputStreamReader(soc.getInputStream());
			in = new BufferedReader(isr);
		} catch (IOException e) {
			System.out.println("in��new����Ƃ���ŗ�O");
			e.printStackTrace();
		}

		// 4 out
		try {
			out = new PrintWriter(soc.getOutputStream());
		} catch (IOException e) {
			System.out.println("out��new����Ƃ���ŗ�O");
			e.printStackTrace();
		}

		// 5 read & write
		String s = null;
		try {
			s = in.readLine();
		} catch (IOException e) {
			System.out.println("readLine����Ƃ���ŗ�O");
			e.printStackTrace();
		}
		if (s != null) {
			System.out.println("Client:[" + s + "]");
		}

		// 6 close
		try {
			in.close();
		} catch (IOException e) {
			System.out.println("in��close����Ƃ���ŗ�O");
			e.printStackTrace();
		}
		out.close();
	}
}
