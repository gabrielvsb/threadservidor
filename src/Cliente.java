import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 3333);
        PrintWriter escritor = new PrintWriter(socket.getOutputStream());
        escritor.println("sistemas distribuidos");
        escritor.flush();

        InputStreamReader leitor = new InputStreamReader(socket.getInputStream());
        BufferedReader leitorB = new BufferedReader(leitor);
        String resposta = leitorB.readLine();
        
        System.out.println(resposta);

        leitor.close();
        leitorB.close();
        escritor.close();
        socket.close();
    }
}
