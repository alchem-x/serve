package serve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTests {

    @Test
    public void test() {
        var serve = new Server();
        assertNotNull(serve);
    }
}
