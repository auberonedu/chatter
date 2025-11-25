import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// To recompile files and run server:
// javac src/*.java && java -cp src OutServer
public class OutServer {
    
    public static void main(String[] args) {
        try{
            // writes what port number to use
        writeToSocket(12345);
        }catch (IOException e){
            System.err.println("Error writing to scoket");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void writeToSocket(int port) throws IOException {

        // stores port number 
        ServerSocket server = new ServerSocket(port);

        System.out.println("waiting for client to connect...");

        // ready to accept client, keeps waiting till there is a connection
        Socket socket = server.accept();
        System.out.println("Client Connected!");


        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, java.nio.charset.StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        // spam "Howdy"
        while(true){
            bufferedWriter.write("Howdy"); // write
            bufferedWriter.newLine(); // newline
            bufferedWriter.flush(); // flush out bufferedWriter
        }

    }
}
