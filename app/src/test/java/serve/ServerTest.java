package serve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @Test
    public void appHasAGreeting() {
        var serve = new Server();
        assertNotNull(serve);
    }
}
