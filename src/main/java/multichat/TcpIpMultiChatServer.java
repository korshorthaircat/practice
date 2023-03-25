package multichat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultiChatServer {
    HashMap clients; //서버에 접속한 클라이언트를 저장

    TcpIpMultiChatServer() {
        clients = new HashMap();
        Collections.synchronizedMap(clients); //동기화 처리
    }

    public static void main(String[] args) {
        new TcpIpMultiChatServer().start();
    }
    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");

            while(true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ": " + socket.getPort() + "] 에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket); //ServerReceiver쓰레드는 클라이언트가 추가될 때마다 생성된다.
                thread.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void sendToAll(String message) {
        Iterator iterator = clients.keySet().iterator();
        while (iterator.hasNext()) {
            try {
                DataOutputStream dataOutputStream = (DataOutputStream) clients.get(iterator.next());
                dataOutputStream.writeUTF(message);
            } catch (IOException e) {}
        }
    }

    void sendToSomeone(String to, String message) {
//        Iterator iterator = clients.keySet().iterator();
//        while (iterator.hasNext()) {
            try {
                DataOutputStream dataOutputStream = (DataOutputStream) clients.get(to);
                dataOutputStream.writeUTF(message);
            } catch (IOException e) {}
//        }
    }

    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {}
        }

        @Override
        public void  run() {
            String userName = "";
            String toName = "";

            try{
                userName = dataInputStream.readUTF();
                sendToAll("# " + userName + "님이 들어오셨습니다.");

                clients.put(userName, dataOutputStream);
                sendToAll("# 현재 서버 접속자 수는 " + clients.size() + "입니다.");

                while (dataInputStream != null) { //클라이언트가 데이터(메세지)를 입력하면,
                    String message = dataInputStream.readUTF();

                    //귓속말 메세지
                    String[] split = message.split("]");
                    if (split[1].charAt(0) == '/') {
                        String[] s = message.split(" ");
                        toName = split[1].substring(1, s.length - 1);
                        sendToSomeone(toName, message);
                    } else {
                        //전체 메세지
                        sendToAll(message);
                    }
                }
            } catch (IOException e) {
                //ignore
            } finally {
                sendToAll("#" + userName + "님이 나가셨습니다.");
                clients.remove(userName);
                System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속을 종료하였습니다.");
                sendToAll("현재 서버 접속자 수는 " + clients.size() + "입니다.");
            }
        }

    }
}


