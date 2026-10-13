package core;

import api.DemoQaClient;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    protected DemoQaClient client;

    @BeforeEach
    void setUpBase() {
        client = new DemoQaClient();
    }
}