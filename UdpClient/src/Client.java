import java.io.*;
import java.net.*;

public class Client {
    private static final int PORT = 1234;
    private static final String SERVER_HOSTNAME = "localhost";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOSTNAME);
            byte[] buffer = new byte[BUFFER_SIZE];

            while (true) {
                System.out.print("Nhap ho ten ban: ");
                String input = System.console().readLine();

                if (input.equalsIgnoreCase("quit")) {
                    break;
                } else if (input.equalsIgnoreCase("khong")) {
                    System.out.println("Khong hieu lenh");
                    continue;
                }

                buffer = input.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, PORT);
                clientSocket.send(packet);

                buffer = new byte[BUFFER_SIZE];
                packet = new DatagramPacket(buffer, buffer.length);
                clientSocket.receive(packet);

                String response = new String(packet.getData(), 0, packet.getLength());
                System.out.println(response);
            }

        } catch (SocketException e) {
            System.err.println("Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
