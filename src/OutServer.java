import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OutServer {
    public static void main(String[] args) {
        try {
            streamOut("localhost", 12345);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void streamOut(String host, int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        
        Socket socket = server.accept();

        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, java.nio.charset.StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        while(true) {
            bufferedWriter.write("hello");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        
    }
}
