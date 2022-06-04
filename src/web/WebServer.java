package web;

import com.sun.net.httpserver.HttpServer;
import init.ServerConfig;

import java.io.IOException;
import java.io.OutputStream;

public class WebServer {
    public void startServer() throws IOException {

        HttpServer httpServer = HttpServer.create(ServerConfig.getServerConfigInstance().getInetSocketAddress(), 0);
        httpServer.createContext("/home", httpExchange -> {
            String responseMessage = ServerConfig.getServerConfigInstance().getGreetingMessage();

            httpExchange.sendResponseHeaders(200, responseMessage.length());

            OutputStream responseBody = httpExchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();
        });

        httpServer.start();
    }
}
