import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(3333);
        while (true) {
            Socket cliente = servidor.accept();
            Thread t = new Thread(new ThreadServidor(cliente));
            t.start();
        }
        
    }
}


