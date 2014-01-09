package ru.migger.comsrv;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.net.Socket;

public class MainTest {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainTest.class);
    private Thread mainThread;

    @org.junit.Before
    public void setUp() throws Exception {
        mainThread = new Thread(new Runnable() {
            public void run() {
                try {
                    Main.main(new String[0]);
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        });
        mainThread.start();
    }

    @Test
    public void testWorks() throws Exception {
        int i;
        for(i = 0; i < 10; i++) {
            LOG.info("try #{} to start...", i + 1);
            try(Socket socket = new Socket("localhost", 8080)) {
                return;
            }
            catch (Exception e) {
                LOG.error(e.getMessage(), e);
                Thread.sleep(1000);
            }
        }
        Assert.fail("Failed after " + i + " tries");
    }
}
