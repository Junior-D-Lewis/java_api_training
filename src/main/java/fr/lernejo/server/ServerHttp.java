package fr.lernejo.server;

import com.sun.net.httpserver.HttpServer;
import fr.lernejo.server.executorService.ServerExecutorService;
import fr.lernejo.server.handler.CustomHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerHttp {

    public ServerHttp(int port) throws IOException {
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
            this.serverExecutorService = new ServerExecutorService(port);
            this.server.createContext("/ping", new CustomHandler());
            this.server.start();
    }

    private final HttpServer server;
    private ServerExecutorService serverExecutorService;
}
