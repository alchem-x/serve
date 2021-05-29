package serve;

import org.jetbrains.annotations.NotNull;

public class App {

    public static void main(@NotNull String @NotNull ... args) {
        var port = 8080;
        if (args.length > 0) {
            port = getPort(args[0], port);
        }
        var server = new Server();
        server.serve(port);
    }

    private static int getPort(@NotNull String portString, int port) {
        try {
            return Integer.parseInt(portString);
        } catch (NumberFormatException ex) {
            return port;
        }
    }
}
