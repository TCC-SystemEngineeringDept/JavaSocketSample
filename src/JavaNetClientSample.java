import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 * 
 */

/**
 * @author t.yoshizawa
 *
 */
public class JavaNetClientSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int port = 5000;
		Socket soc = null;
		BufferedReader in = null;
		PrintWriter out = null;

		// 1 Socket

		try {
			soc = new Socket("localhost", port);
		} catch (UnknownHostException e1) {
			System.out.println("socketをnewするところで例外");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("socketをnewするところで例外");
			e1.printStackTrace();
		}

		// 2 in
		try {
			InputStreamReader isr = null;
			isr = new InputStreamReader(soc.getInputStream());
			in = new BufferedReader(isr);
		} catch (IOException e) {
			System.out.println("inをnewするところで例外");
			e.printStackTrace();
		}

		// 3 out
		try {
			out = new PrintWriter(soc.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("outをnewするところで例外");
			e.printStackTrace();
		}

		// 4 write
		out.println("Hello,World");

		// 5 close
		try {
			in.close();
		} catch (IOException e) {
			System.out.println("inをcloseするところで例外");
			e.printStackTrace();
		}
		out.close();

	}

}
