import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

// To recompile files and run client:
// javac src/*.java && java -cp src ChatClient

public class ChatClient {

    public static void main(String[] args) {
       try {
        readFromSocket("localhost", 12345);
       } catch (IOException e) {
        System.err.println("Error reading from socket");
        System.err.println(e.getMessage());
        System.exit(1);
       }
    }

    public static void readFromFile(String filename) throws IOException{
        InputStream inputStream = new FileInputStream(filename); // Reads from file and converts to bytes
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, java.nio.charset.StandardCharsets.UTF_8); // Converts bytes to characters (UTF-8)
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // Converts characters into readable strings

        String line; // A variable to track the current line
        // Assign the line variable the current line the buffered reader is reading
        // Check if its not null all in one line, this is possible due to ()
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line); // Read a line and print it to the console
        }
    }
    
    public static void readFromSocket(String host, int port) throws IOException {
        // Try to make a new socket and connect to the host
        try (Socket socket = new Socket(host, port)) {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, java.nio.charset.StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    
            String line; // A variable to track the current line
            // Assign the line variable the current line the buffered reader is reading
            // Check if its not null all in one line, this is possible due to ()
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Read a line and print it to the console
            }
        }
    }
}
