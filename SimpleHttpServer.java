import java.io.*;
import java.net.*;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        int port = 8000; // Port number
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started at: http://localhost:" + port);

        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {
                handleRequest(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String requestLine = in.readLine();
        if (requestLine != null && requestLine.startsWith("GET")) {
            // Serve the home.html file
            File file = new File("home.html");
            if (file.exists()) {
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println("Content-Length: " + file.length());
                out.println();
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = fileReader.readLine()) != null) {
                    out.println(line);
                }
                fileReader.close();
            } else {
                out.println("HTTP/1.1 404 Not Found");
                out.println();
                out.println("File not found!");
            }
        }
        out.close();
        in.close();
    }
}
