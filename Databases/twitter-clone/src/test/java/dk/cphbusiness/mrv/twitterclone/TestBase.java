package dk.cphbusiness.mrv.twitterclone;

import dk.cphbusiness.mrv.twitterclone.contract.PostManagement;
import dk.cphbusiness.mrv.twitterclone.contract.UserManagement;
import dk.cphbusiness.mrv.twitterclone.dto.UserCreation;
import dk.cphbusiness.mrv.twitterclone.impl.PostManagementImpl;
import dk.cphbusiness.mrv.twitterclone.impl.UserManagementImpl;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {

    private GenericContainer redisContainer;

    protected UserManagement um;
    protected PostManagement pm;
    protected TimeFake time;
    private Jedis jedis;

    private String host = "localhost";
    private int port = 6379;

    private void setupContainer() {
        redisContainer = new GenericContainer(DockerImageName.parse("redis:alpine"))
                .withExposedPorts(6379);
        redisContainer.start();
        host = redisContainer.getHost();
        port = redisContainer.getFirstMappedPort();
    }

    @BeforeAll
    public void setup(){
        host = "localhost";
        port = 6379;

        /*
        The following line starts a new container with redis, and runs integration tests on it.

        Depending on your setup, it might not work. If it doesn't work, try this in your terminal:
        docker pull testcontainers/ryuk:0.3.0

        If it still doesn't work, you can comment out the line,
        BUT then the integration tests will be run against your local redis, AND IT WILL FLUSH DB 9!
        To prove that you have read this warning, delete the exception below.
        */
        setupContainer();

        jedis = new Jedis(host, port);
        jedis.select(9);
        time = new TimeFake();

        um = new UserManagementImpl(jedis);
        pm = new PostManagementImpl(jedis, time);

    }

    @BeforeEach
    public void beforeEach() {
        jedis.flushDB();
    }

    protected UserCreation getAlbert() {
        return new UserCreation("ahr","Albert", "Rumle", "aou87", "1951-03-03");
    }

    protected UserCreation getBenny() {
        return new UserCreation("ben","Benny", "Juuel", "htiuh9", "1941-04-04");
    }

    protected UserCreation getCarl() {
        return new UserCreation("crl","Carl", "Vladimirovich", "tytytt", "1981-05-05");
    }

    protected UserCreation getDennis() {
        return new UserCreation("den","Dennis", "Olsen", "uhcah834", "1982-06-06");
    }
}

