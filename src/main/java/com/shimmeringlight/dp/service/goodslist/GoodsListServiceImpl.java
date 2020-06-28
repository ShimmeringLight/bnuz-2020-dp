package com.shimmeringlight.dp.service.goodslist;

import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactory;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.GoodsList;
import com.shimmeringlight.dp.service.goods.GoodsService;
import com.shimmeringlight.dp.service.goods.GoodsServiceImpl;

public class GoodsListServiceImpl implements GoodsListService
{
    GoodsService goodsService = GoodsServiceImpl.getInstance();

    GoodsListMapper goodsListMapper = DaoFactoryImpl.getInstance().buildGoodsListMapper();

    GoodsMapper goodsMapper = DaoFactoryImpl.getInstance().buildGoodsMapper();

    @Override
    public void updateByEntity(GoodsList list)
    {
        GoodsList goodsList = new GoodsList();
        goodsList.setGoodsListId(list.getGoodsListId());
        goodsList.setGoodsAmount(list.getGoodsAmount());
        goodsList.setGoodsId(list.getGoodsId());
        goodsList.setOrderId(list.getOrderId());
        list.setFinalPrice(goodsService.calcFinalPrice(goodsMapper.findById(goodsList.getGoodsId())) * goodsList.getGoodsAmount());
        goodsListMapper.updateByEntity(list);
    }

    @Override
    public void insertByEntity(GoodsList goodsList)
    {
        goodsList.setFinalPrice(goodsService.calcFinalPrice(goodsMapper.findById(goodsList.getGoodsId())) * goodsList.getGoodsAmount());
        goodsListMapper.insertByEntity(goodsList);
    }

    //单例
    private static class Instance
    {
        public static final GoodsListServiceImpl instance = new GoodsListServiceImpl();
    }

    public static GoodsListServiceImpl getInstance()
    {
        return GoodsListServiceImpl.Instance.instance;
    }
}
