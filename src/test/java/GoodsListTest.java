import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.entity.GoodsList;
import com.shimmeringlight.dp.entity.Orders;
import com.shimmeringlight.dp.service.login.LoginRetention;
import com.shimmeringlight.dp.service.login.LoginService;
import com.shimmeringlight.dp.service.login.LoginServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoodsListTest
{
    GoodsListMapper goodsListMapper = DaoFactoryImpl.getInstance().buildGoodsListMapper();

    GoodsMapper goodsMapper = DaoFactoryImpl.getInstance().buildGoodsMapper();

    LoginService loginService = LoginServiceImpl.getInstance();

    OrdersMapper ordersMapper = DaoFactoryImpl.getInstance().buildOrdersMapper();

    @Before
    public void before()
    {
        LoginRetention.setIsLogin(true);
        Goods goods = new Goods();
        goods.setGoodsName("Test");
        goods.setInventory(100);
        goods.setWeight(10);
        goods.setDiscount(80);
        goods.setOriPrice(100);
        goodsMapper.insertByEntity(goods);

        Orders orders = new Orders();
        orders.setOrderPrice(100);
        orders.setWeight(1);
        orders.setNum(10);
        ordersMapper.insertByEntity(orders);
        assert !ordersMapper.findAll().isEmpty();

        goods = goodsMapper.findByName("Test");
        GoodsList goodsList = new GoodsList();
        goodsList.setFinalPrice(80);
        goodsList.setOrderId(ordersMapper.findAll().get(0).getOrderId());
        goodsList.setGoodsAmount(1);
        goodsList.setGoodsId(goods.getGoodId());
        goodsListMapper.insertByEntity(goodsList);
        assert !goodsListMapper.findAll().isEmpty();
    }

    @Test
    public void test()
    {
        GoodsList goodsList = goodsListMapper.findAll().get(0);
        goodsList.setFinalPrice(75);
        goodsListMapper.updateByEntity(goodsList);
        assert goodsListMapper.findByEntity(goodsList).getFinalPrice() == 75;
    }

    @After
    public void after()
    {
        for (GoodsList goodsList : goodsListMapper.findAll())
            goodsListMapper.deleteById(goodsList.getGoodsListId());

        for (Goods goods : goodsMapper.findAll())
            goodsMapper.deleteById(goods.getGoodId());

        for (Orders orders : ordersMapper.findAll())
            ordersMapper.deleteById(orders.getOrderId());
    }
}
