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
    //    System.out.println("Hello World!");
        // try{
        // readFromFile("LICENSE");
        // // catch IOException and read error 
        // } catch (IOException e){
        //     System.err.println("Error reading from file");
        //     System.err.println(e.getMessage());
        //     System.exit(1);
        // }


        try{
        readFromSocket("localhost", 12345);
        // catch IOException and read error 
        } catch (IOException e){
            System.err.println("Error reading from Socket");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void readFromFile(String filename) throws IOException{
        InputStream inputStream = new FileInputStream(filename); // bytes
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, java.nio.charset.StandardCharsets.UTF_8); // decoded chars
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // buffered strings/chars


        // while "line" is not empty keep looping through whole file
        String line;
        while((line = bufferedReader.readLine())!= null){
            System.out.println(line);
        }
        // read and print one line
        // System.out.println(bufferedReader.readLine());
    }

    public static void readFromSocket(String host, int port) throws IOException {
        // socket = host IP address and port number(where on the machine)
        Socket socket = new Socket(host, port);


        InputStream inputStream = socket.getInputStream();// btyes
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, java.nio.charset.StandardCharsets.UTF_8); // chars
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // buffered chars/strings


        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
    }
}
