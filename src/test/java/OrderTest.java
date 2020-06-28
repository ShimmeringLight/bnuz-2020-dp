import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.OrderPo;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.service.login.LoginRetention;
import com.shimmeringlight.dp.service.login.LoginService;
import com.shimmeringlight.dp.service.login.LoginServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest
{
    Log log = LogFactory.build();

    OrdersMapper ordersMapper = DaoFactoryImpl.getInstance().buildOrdersMapper();

    LoginService loginService = LoginServiceImpl.getInstance();

    @Before
    public void beforeTest()
    {
        LoginRetention.setIsLogin(true);
        OrderPo orderPo = new OrderPo();
        orderPo.setOrderPrice(100);
        orderPo.setWeight(1);
        orderPo.setNum(10);
        ordersMapper.insertByEntity(orderPo);
        assert !ordersMapper.findAll().isEmpty();
    }

    @Test
    public void test()
    {
        OrderPo orderPo = ordersMapper.findAll().get(0);
        orderPo.setNum(15);
        ordersMapper.updateByEntity(orderPo);
        assert ordersMapper.findById(orderPo.getOrderId()).getNum() == 15;
    }

    @After
    public void after()
    {
        for (OrderPo orderPo : ordersMapper.findAll())
            ordersMapper.deleteById(orderPo.getOrderId());
    }
}
