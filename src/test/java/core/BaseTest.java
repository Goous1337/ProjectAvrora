package core;

import api.clients.AccountClient;
import api.clients.BookClient;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

        protected BookClient bookClient;
        protected AccountClient accountClient;

        @BeforeEach
        void setUpBase() {
            bookClient = new BookClient();
            accountClient = new AccountClient();
        }
}