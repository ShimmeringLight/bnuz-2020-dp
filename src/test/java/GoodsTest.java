import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.service.login.LoginRetention;
import com.shimmeringlight.dp.service.login.LoginService;
import com.shimmeringlight.dp.service.login.LoginServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GoodsTest
{
    GoodsMapper goodsMapper = DaoFactoryImpl.getInstance().buildGoodsMapper();

    LoginService loginService = LoginServiceImpl.getInstance();

    Log log = LogFactory.build();

    @Before
    public void beforeTest()
    {
        LoginRetention.setIsLogin(true);
        Goods goods = new Goods(100, 90, 10, 100, "Test");
        goodsMapper.insertByEntity(goods);
    }

    @Test
    public void test()
    {
        List<Goods> goodsList = goodsMapper.findAll();
        Goods goods = goodsList.get(0);
        goods.setGoodsName("changed");
        goodsMapper.updateByEntity(goods);
        assert goodsMapper.findByName("changed") != null;
    }

    @After
    public void afterTest()
    {
        List<Goods> goodsList = goodsMapper.findAll();
        assert goodsList.size() > 0;
        for (Goods g : goodsList)
            goodsMapper.deleteById(g.getGoodId());
    }
}
