import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Scanner;

import DB.Connector;
import TCP.ChatClientAppController;
import TCP.ChatWindow;

public class ChatStartController {
	private static final String SERVER_IP = "192.168.0.16";
	private static final int SERVER_PORT = 5000;
	
	public static void Start() throws SQLException {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		
		new ChatClientAppController();
		
		Connector con = new Connector();
    	String str = con.getDatas("SELECT * FROM couple_bus.user WHERE seq = '1'");
    	

		while (true) {

			System.out.println("��ȭ���� �Է��ϼ���.");
			System.out.print(">>> ");
			name = str;

			if (name.isEmpty() == false) {
				break;
			}

			System.out.println("��ȭ���� �ѱ��� �̻� �Է��ؾ� �մϴ�.\n");
		}

		scanner.close();

		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			consoleLog("ä�ù濡 �����Ͽ����ϴ�.");
			new ChatWindow(name, socket).show();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);
			String request = "join:" + name + "\r\n";
			pw.println(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void consoleLog(String log) {
		System.out.println(log);
	}
}
