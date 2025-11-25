import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// To recompile files and run client:
// javac src/*.java && java -cp src ChatClient

public class ChatClient {

    public static void main(String[] args) {
       try {
        readFromFile("LICENSE");
       } catch (IOException e) {
        System.err.println("Error reading from file ");
        System.err.println(e.getMessage());
        System.exit(1);
       }
    }

    public static void readFromFile(String filename) throws IOException{
        InputStream inputStream = new FileInputStream(filename); // Reads from file and converts to bytes
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, java.nio.charset.StandardCharsets.UTF_8); // Converts bytes to characters (UTF-8)
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // Converts characters into readable strings

        System.out.println(bufferedReader.readLine()); // Read a single line and print it to the console
    }

    public static void readFromSocket(String host, int port) throws IOException {
        
    }
}
