package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.Goods;

import java.util.List;

/**
 * 商品数据访问层接口
 *
 * @see com.shimmeringlight.dp.dao.UserMapper
 */
public interface GoodsMapper
{
    void insertByEntity(Goods goods);

    void deleteById(int id);

    void deleteByName(String name);

    void updateByEntity(Goods goods);

    Goods findById(int id);

    Goods findByName(String name);

    List<Goods> findAll();
}
