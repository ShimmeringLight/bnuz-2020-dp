import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import org.junit.Test;

public class LogTest
{
    @Test
    public void logTest()
    {
        Thread.currentThread().setName("Test");
        Log log = LogFactory.build();
        log.info("Test INFO");
        log.debug("Test DEBUG");
        log.error("Test ERROR");
    }
}
