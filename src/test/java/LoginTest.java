import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.dao.impl.factory.DaoFactory;
import com.shimmeringlight.dp.dao.impl.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.service.login.LoginService;
import com.shimmeringlight.dp.service.login.LoginServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginTest
{
    UserMapper userMapper;

    Log log = LogFactory.build();

    @Before
    public void beforeTest()
    {
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        userMapper = daoFactory.buildUserMapper();
    }

    @Test
    public void test()
    {
        log.debug("UserMapper : " + userMapper);
        userMapper.insert("login","123456");
        LoginService loginService = new LoginServiceImpl();
        loginService.login("login","123456");
    }

    @After
    public void afterTest()
    {
        userMapper.deleteByUserName("login");
    }
}
