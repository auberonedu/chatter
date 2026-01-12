import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.classfile.BufWriter;
import java.net.ServerSocket;
import java.net.Socket;

// To recompile files and run server:
//  Socket socket = new Socket(host, port);
//javac src/*.java && java -cp src OutServer
public class OutServer {

    public static void main(String[] args) {
        try {
            writeToSocket(12345);

        } catch (IOException e) {
            System.err.println("Error writing to cocket");
            System.err.println(e.getMessage());
            System.exit(1);
        }

        // Thread thread = new Thread(() -> spam("lol");
        // Thread thread2 = new Thread(() -> spam("jaja"));

        // thread.start();
        // thread2.start();

    }

    public static void spam(String msg) {
        while (true) {
            System.out.println(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;

            }

        }

    }

    public static void writeToSocket(int port) throws IOException {

        try (ServerSocket server = new ServerSocket(port)) {

            while (true) {
                System.out.println("Waiting for clinet to connect...");
                Socket socket = server.accept();

                Thread cliThread = new Thread(() -> handelClient(socket));
                cliThread.start();

            }

        }

    }

    public static void handelClient(Socket socket) {
        try {
            System.out.println("Client connected");

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,
                    java.nio.charset.StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            while (true) {
                bufferedWriter.write("Hello");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                try {
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Client intereupted");
                    return;

                }
            }

        } catch (IOException e) {

            System.out.println("Client Disconnected");
            return;

        }
    }
}
