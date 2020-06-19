import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactory;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.entity.GoodsList;
import com.shimmeringlight.dp.service.login.LoginService;
import com.shimmeringlight.dp.service.login.LoginServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class GoodsListTest
{
    GoodsListMapper goodsListMapper = DaoFactoryImpl.getInstance().buildGoodsListMapper();

    GoodsMapper goodsMapper = DaoFactoryImpl.getInstance().buildGoodsMapper();

    LoginService loginService = LoginServiceImpl.getInstance();

    @Before
    public void before()
    {
        loginService.login("root","123456");
        goodsListMapper.trim();
        Goods goods = new Goods();
        goods.setGoodsName("Test");
        goods.setInventory(100);
        goods.setWeight(10);
        goods.setDiscount(80);
        goods.setOriPrice(100);
        goodsMapper.insertByEntity(goods);
        goods = goodsMapper.findByName("Test");
        GoodsList goodsList = new GoodsList();
        goodsList.setFinalPrice(80);
        goodsList.setGoodsAmount(1);
        goodsList.setGoodsId(goods.getGoodId());
        goodsListMapper.insertByEntity(goodsList);
        assert goodsListMapper.findAll().size() > 0;
    }

    @Test
    public void test()
    {
        GoodsList goodsList = goodsListMapper.findAll().get(0);
        goodsList.setFinalPrice(75);
        goodsListMapper.updateByEntity(goodsList);
        assert goodsListMapper.findByEntity(goodsList).getFinalPrice() == 75;
    }

    @Test
    public void after()
    {
        for(GoodsList goodsList: goodsListMapper.findAll())
            goodsListMapper.deleteById(goodsList.getGoodsListId());
    }
}
