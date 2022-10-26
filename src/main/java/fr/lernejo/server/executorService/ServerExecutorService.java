package fr.lernejo.server.executorService;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import fr.lernejo.server.handler.Handler;

public class ServerExecutorService implements Runnable {
    private final ServerSocket serverSocket;
    private final ExecutorService executorService;
    private final int numberOfThread = 1;
    private final int socketPort = 01;

    public ServerExecutorService(int port) throws IOException {
        this.serverSocket = new ServerSocket(socketPort);
        this.executorService = Executors.newFixedThreadPool(numberOfThread);
    }

    @Override
    public void run() {
        try {
            executorService.execute(new Handler(serverSocket.accept()));
        } catch (IOException e) {
            executorService.shutdown();
            throw new RuntimeException(e);
        }
    }
}

