package TCP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatClientApp extends JFrame{
    private static final String SERVER_IP = "192.168.0.16";
    private static final int SERVER_PORT = 5000;
    
	public ChatClientApp() {
	        
	        setTitle("��ư���� ���� ���ο� â");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        JPanel MainContainer = new JPanel();
	        setContentPane(MainContainer);
	        
	        JButton OpenWindow = new JButton("�� â ����");
	        
	        OpenWindow.addActionListener(new ActionListener() {
	            // ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // TODO Auto-generated method stub
	                new newWindow(); // Ŭ���� newWindow�� ���� ������
	            }
	            
	        });
	        
	        MainContainer.add(OpenWindow);
	        
	        setSize(300,100);
	        setResizable(false);
	        setVisible(true);
	    }



    
    
    public static void main(String[] args) {
        String name = null;
        Scanner scanner = new Scanner(System.in);
        
        new ChatClientApp();
        
        while( true ) {

            System.out.println("��ȭ���� �Է��ϼ���.");
            System.out.print(">>> ");
            name = scanner.nextLine();

            if (name.isEmpty() == false ) {
                break;
            }

            System.out.println("��ȭ���� �ѱ��� �̻� �Է��ؾ� �մϴ�.\n");
        }

        scanner.close();

        Socket socket = new Socket();
        try {
            socket.connect( new InetSocketAddress(SERVER_IP, SERVER_PORT) );
            consoleLog("ä�ù濡 �����Ͽ����ϴ�.");
            new ChatWindow(name, socket).show();

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
            String request = "join:" + name + "\r\n";
            pw.println(request);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void consoleLog(String log) {
        System.out.println(log);
    }
}

class newWindow extends JFrame {
    // ��ư�� �������� ��������� �� â�� ������ Ŭ����
    newWindow() {
        setTitle("���� ��� â");
        // ����, ���⼭ setDefaultCloseOperation() ���Ǹ� ���� ���ƾ� �Ѵ�
        // �����ϰ� �Ǹ� �� â�� ������ ��� â�� ���α׷��� ���ÿ� ������
        
        JPanel NewWindowContainer = new JPanel();
        setContentPane(NewWindowContainer);
        
        JLabel NewLabel = new JLabel("�� â�� ���µ� ����!");
        
        NewWindowContainer.add(NewLabel);
        
        setSize(300,100);
        setResizable(false);
        setVisible(true);
    }
}

