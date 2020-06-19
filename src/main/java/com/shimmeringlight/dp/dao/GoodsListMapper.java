package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.GoodsList;

import java.util.List;

public interface GoodsListMapper
{
    void insertByEntity(GoodsList goodsList);

    void deleteById(int id);

    void trim();

    void updateByEntity(GoodsList goodsList);

    GoodsList findById(int id);

    GoodsList findByEntity(GoodsList goodsList);

    List<GoodsList> findAll();
}
