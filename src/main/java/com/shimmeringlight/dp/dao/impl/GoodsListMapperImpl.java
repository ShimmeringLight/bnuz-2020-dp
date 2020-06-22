package com.shimmeringlight.dp.dao.impl;

import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.entity.GoodsList;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.utils.Utils;
import com.shimmeringlight.dp.utils.annotations.Login;
import com.shimmeringlight.dp.utils.config.LoadedProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @see com.shimmeringlight.dp.dao.GoodsListMapper
 * 订单商品条目数据访问层实现类
 */
public class GoodsListMapperImpl implements GoodsListMapper
{

    static Log log = LogFactory.build();

    Statement statement;

    /**
     * 映射结果集与实体类
     *
     * @param resultSet 结果集
     * @return 实体类List
     */
    public static List<GoodsList> extract(ResultSet resultSet)
    {
        int count = 0;
        List<GoodsList> lists = new ArrayList<>();
        try
        {
            while (resultSet.next())
            {
                count++;
                GoodsList goodsList = new GoodsList();
                goodsList.setGoodsListId(resultSet.getInt("goodsListId"));
                goodsList.setOrderId(resultSet.getInt("orderId"));
                goodsList.setGoodsId(resultSet.getInt("goodsId"));
                goodsList.setGoodsAmount(resultSet.getInt("goodsAmount"));
                goodsList.setFinalPrice(resultSet.getInt("finalPrice"));
                lists.add(goodsList);
                log.debug("Find: " + count);
            }
            return lists;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Login
    public void insertByEntity(GoodsList goodsList)
    {
        String sql = "insert into GoodsList (goodsId, orderId,goodsAmount, finalPrice) VALUES ("
                + goodsList.getGoodsId() + ","
                + goodsList.getOrderId() + ","
                + goodsList.getGoodsAmount() + ","
                + goodsList.getFinalPrice() + ")";
        Utils.logSQL(sql);
        try
        {
            statement.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    @Login
    public void deleteById(int id)
    {
        String sql = "delete from GoodsList where goodsListId = " + id;
        Utils.logSQL(sql);
        try
        {
            statement.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    @Login
    public void updateByEntity(GoodsList goodsList)
    {
        String sql = "update GoodsList set"
                + " goodsId = " + goodsList.getGoodsId()
                + ",orderId = " + goodsList.getOrderId()
                + ",goodsAmount = " + goodsList.getGoodsAmount()
                + ",finalPrice = " + goodsList.getFinalPrice()
                + " where goodsListId = " + goodsList.getGoodsListId();
        Utils.logSQL(sql);
        try
        {
            statement.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public GoodsList findById(int id)
    {
        String sql = "select * from GoodsList where goodsListId = " + id;
        Utils.logSQL(sql);
        try
        {
            ResultSet resultSet = statement.executeQuery(sql);
            List<GoodsList> list = extract(resultSet);
            return list.get(0);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GoodsList findByEntity(GoodsList goodsList)
    {
        String sql = "select * from GoodsList where "
                + "goodsId = " + goodsList.getGoodsId()
                + " and orderId = " + goodsList.getOrderId()
                + " and goodsAmount = " + goodsList.getGoodsAmount()
                + " and finalPrice = " + goodsList.getFinalPrice();
        try
        {
            return extract(statement.executeQuery(sql)).get(0);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GoodsList> findAll()
    {
        String sql = "select * from GoodsList";
        Utils.logSQL(sql);
        try
        {
            ResultSet resultSet = statement.executeQuery(sql);
            List<GoodsList> list = extract(resultSet);
            return list;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public GoodsListMapperImpl()
    {
        final String DB_URL;

        final String USER;

        final String PASSWORD;

        Connection connection = null;
        log.debug("Loading GoodsListMapper");
        DB_URL = LoadedProperties.getInstance().getProperties().getProperty("jdbc.url");
        USER = LoadedProperties.getInstance().getProperties().getProperty("jdbc.user");
        PASSWORD = LoadedProperties.getInstance().getProperties().getProperty("jdbc.password");
        log.debug("Loading Driver");
        log.debug("Connecting to database");
        try
        {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        log.info("Creating statement");
        try
        {
            statement = connection.createStatement();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    //单例
    private static class Instance
    {
        public static final GoodsListMapperImpl instance = new GoodsListMapperImpl();
    }

    public static GoodsListMapperImpl getInstance()
    {
        return GoodsListMapperImpl.Instance.instance;
    }
}
