
import java.io.IOException;
import java.net.*;

public class Server {
    private static final int PORT = 1234;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                serverSocket.receive(packet);

                String input = new String(packet.getData(), 0, packet.getLength());
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }

                String response = "DAI HOC CONG NGHE DONG A CHAO BAN: " + input.toUpperCase() + " K12";
                buffer = response.getBytes();
                packet.setData(buffer);
                packet.setLength(buffer.length);
                serverSocket.send(packet);
            }

        } catch (SocketException e) {
            System.err.println("Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
