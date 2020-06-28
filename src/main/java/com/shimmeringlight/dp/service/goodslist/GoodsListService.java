package com.shimmeringlight.dp.service.goodslist;

import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.entity.GoodsList;

public interface GoodsListService
{
    void updateByEntity(GoodsList goodsList);

    void insertByEntity(GoodsList goodsList);
}
