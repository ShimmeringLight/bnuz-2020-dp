package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.entity.GoodsList;

import java.util.List;

/**
 * 订单商品条目数据数据访问层接口
 *
 * @see com.shimmeringlight.dp.dao.UserMapper
 */
public interface GoodsListMapper
{
    void insertByEntity(GoodsList goodsList);

    void deleteById(int id);

    void deleteByOrderId(int id);

    void updateByEntity(GoodsList goodsList);

    GoodsList findById(int id);

    GoodsList findByEntity(GoodsList goodsList);

    List<GoodsList> findAll();

    List<Goods> findGoodsByOrderId(int id);

    List<GoodsList> findByOrderId(int id);
}
