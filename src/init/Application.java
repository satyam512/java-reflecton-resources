package init;


import web.WebServer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        initServerConfig(8072, "Kept you waiting huh ?");

        WebServer webServer = new WebServer();
        webServer.startServer();
    }

    private static void initServerConfig(Integer port, String greetingMessage) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = ServerConfig.class;
        Constructor<?> serverConfigConstrictor = clazz.getDeclaredConstructor(Integer.class, String.class);

        serverConfigConstrictor.setAccessible(true);
        serverConfigConstrictor.newInstance(port, greetingMessage);
    }
}
