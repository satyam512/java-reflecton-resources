package init;

import java.net.InetSocketAddress;

public class ServerConfig {
    InetSocketAddress inetSocketAddress;
    String greetingMessage;

    private static ServerConfig serverConfig;

    public static ServerConfig getServerConfigInstance() {
        return serverConfig;
    }
    private ServerConfig(Integer port, String greetingMessage) {
        this.inetSocketAddress = new InetSocketAddress("localhost", port);
        this.greetingMessage = greetingMessage;

        if (serverConfig == null) {
            serverConfig = this;
        }
    }
    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }
}
