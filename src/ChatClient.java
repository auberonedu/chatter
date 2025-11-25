import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        // Scanner userInput = new Scanner(System.in);

        // System.out.println("Enter the name of the file to read");
        // String filename = userInput.nextLine();

        Socket socket = new Socket("localhost", 12345);
 
        InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        String line;
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
