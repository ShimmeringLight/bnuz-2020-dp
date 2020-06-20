package com.shimmeringlight.dp.dao.impl;

import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.utils.Utils;
import com.shimmeringlight.dp.utils.annotations.Login;
import com.shimmeringlight.dp.utils.config.LoadedProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @see com.shimmeringlight.dp.dao.GoodsMapper
 * 商品数据访问层实现，为单例
 */
@Login
public class GoodsMapperImpl implements GoodsMapper
{
    Statement statement;

    static Log log = LogFactory.build();

    /**
     * 映射结果集与实体类
     *
     * @param resultSet 结果集
     * @return 实体类List
     */
    public static List<Goods> extract(ResultSet resultSet)
    {
        ArrayList<Goods> goodsList = new ArrayList<>();
        int count = 0;
        try
        {
            while (resultSet.next())
            {
                count++;
                Goods goods = new Goods();
                goods.setGoodId(resultSet.getInt("goodsId"));
                goods.setOriPrice(resultSet.getInt("oriPrice"));
                goods.setDiscount(resultSet.getInt("discount"));
                goods.setWeight(resultSet.getInt("weight"));
                goods.setInventory(resultSet.getInt("inventory"));
                goods.setGoodsName(resultSet.getString("goodsName"));
                goodsList.add(goods);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        log.debug("Find: " + count);
        return goodsList;
    }

    @Override
    public void insertByEntity(Goods goods)
    {
        String sql = "insert into Goods (oriPrice, discount, weight, inventory, goodsName) " +
                "VALUES (" + goods.getOriPrice() + "," + goods.getDiscount() + "," + goods.getWeight() +
                "," + goods.getInventory() + ",'" + goods.getGoodsName() + "')";
        Utils.logSQL(sql);
        try
        {
            statement.executeUpdate(sql);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id)
    {
        String sql = "delete from Goods where goodsId = " + id;
        Utils.logSQL(sql);
        try
        {
            statement.executeUpdate(sql);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteByName(String name)
    {
        String sql = "delete from Goods where goodsName = '" + name + "'";
        Utils.logSQL(sql);
        try
        {
            statement.executeUpdate(sql);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateByEntity(Goods goods)
    {
        String sql = "update Goods set oriPrice = " + goods.getOriPrice() +
                ",discount = " + goods.getDiscount() +
                ",weight =" + goods.getWeight() +
                ",inventory = " + goods.getInventory() +
                ",goodsName = '" + goods.getGoodsName() + "'" +
                "where goodsId = " + goods.getGoodId();
        Utils.logSQL(sql);
        try
        {
            statement.executeUpdate(sql);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public Goods findById(int id)
    {
        String sql = "select * from Goods where goodsId = " + id;
        Utils.logSQL(sql);
        try
        {
            return extract(statement.executeQuery(sql)).get(0);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Goods findByName(String name)
    {
        String sql = "select * from Goods where goodsName = '" + name + "'";
        Utils.logSQL(sql);
        try
        {
            return extract(statement.executeQuery(sql)).get(0);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Goods> findAll()
    {
        String sql = "select * from Goods";
        Utils.logSQL(sql);
        try
        {
            return extract(statement.executeQuery(sql));
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    private static class Instance
    {
        public static final GoodsMapperImpl instance = new GoodsMapperImpl();
    }

    public static GoodsMapperImpl getInstance()
    {
        return GoodsMapperImpl.Instance.instance;
    }

    private GoodsMapperImpl()
    {
        final String DB_URL;

        final String USER;

        final String PASSWORD;

        Connection connection = null;

        log.debug("Loading GoodsMapper");
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
}
