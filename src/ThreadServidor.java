import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ThreadServidor implements Runnable {
    private Socket cliente;

    public ThreadServidor(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            InputStreamReader leitor = new InputStreamReader(cliente.getInputStream());
            BufferedReader leitorB = new BufferedReader(leitor);
            String linha = leitorB.readLine();

            PrintWriter escritor = new PrintWriter(cliente.getOutputStream());
            escritor.println("Nome Thread - " + Thread.currentThread().getName() +linha.toUpperCase());
            escritor.flush();

            leitor.close();
            leitorB.close();
            escritor.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}