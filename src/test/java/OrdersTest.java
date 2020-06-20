import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.Orders;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.service.login.LoginService;
import com.shimmeringlight.dp.service.login.LoginServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrdersTest
{
    Log log = LogFactory.build();

    OrdersMapper ordersMapper = DaoFactoryImpl.getInstance().buildOrdersMapper();

    LoginService loginService = LoginServiceImpl.getInstance();

    @Before
    public void beforeTest()
    {
        loginService.login("root", "123456");
        Orders orders = new Orders();
        orders.setOrderPrice(100);
        orders.setWeight(1);
        orders.setNum(10);
        ordersMapper.insertByEntity(orders);
        assert !ordersMapper.findAll().isEmpty();
    }

    @Test
    public void test()
    {
        Orders orders = ordersMapper.findAll().get(0);
        orders.setNum(15);
        ordersMapper.updateByEntity(orders);
        assert ordersMapper.findById(orders.getOrderId()).getNum() == 15;
    }

    @After
    public void after()
    {
        for (Orders orders : ordersMapper.findAll())
            ordersMapper.deleteById(orders.getOrderId());
    }
}
