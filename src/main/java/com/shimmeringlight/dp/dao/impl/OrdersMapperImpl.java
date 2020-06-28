package com.shimmeringlight.dp.dao.impl;

import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.entity.OrderPo;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.utils.Utils;
import com.shimmeringlight.dp.utils.annotations.Login;
import com.shimmeringlight.dp.utils.config.LoadedProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @see com.shimmeringlight.dp.dao.OrdersMapper
 * 订单数据访问层实现，为单例
 */
public class OrdersMapperImpl implements OrdersMapper
{
    Statement statement;

    private static final Log log = LogFactory.build();

    /**
     * 映射结果集与实体类
     *
     * @param resultSet 结果集
     * @return 实体类List
     */
    private static List<OrderPo> extract(ResultSet resultSet)
    {
        int count = 0;
        List<OrderPo> orderPoList = new ArrayList<>();
        try
        {
            while (resultSet.next())
            {
                OrderPo orderPo = new OrderPo();
                orderPo.setOrderId(resultSet.getInt("orderId"));
                orderPo.setOrderPrice(resultSet.getInt("orderPrice"));
                orderPo.setNum(resultSet.getInt("num"));
                orderPo.setWeight(resultSet.getInt("weight"));
                orderPoList.add(orderPo);
                count++;
            }
            log.debug("Find: " + count);
            return orderPoList;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Login
    public void insertByEntity(OrderPo orderPo)
    {
        String sql = "insert into Orders (orderPrice, num, weight) VALUES ("
                + orderPo.getOrderPrice() + ","
                + orderPo.getNum() + ","
                + orderPo.getWeight() + ")";
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
        String sql = "delete from Orders where orderId = " + id;
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
    public void updateByEntity(OrderPo orderPo)
    {
        String sql = "update Orders set "
                + "orderPrice = " + orderPo.getOrderPrice() + ","
                + "num = " + orderPo.getNum() + ","
                + "weight = " + orderPo.getWeight() + " "
                + "where orderId = " + orderPo.getOrderId();
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
    public OrderPo findById(int id)
    {
        String sql = "select * from Orders where orderId = " + id;
        Utils.logSQL(sql);
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
    public OrderPo findByEntity(OrderPo orderPo)
    {
        String sql = "select * from Orders where "
                + "orderPrice = " + orderPo.getOrderPrice() + " and "
                + "num = " + orderPo.getNum() + " and "
                + "weight = " + orderPo.getWeight();
        Utils.logSQL(sql);
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
    public List<OrderPo> findAll()
    {
        String sql = "select * from Orders";
        Utils.logSQL(sql);
        try
        {
            return extract(statement.executeQuery(sql));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //单例
    private static class Instance
    {
        public static final OrdersMapperImpl instance = new OrdersMapperImpl();
    }

    public static OrdersMapperImpl getInstance()
    {
        return OrdersMapperImpl.Instance.instance;
    }

    private OrdersMapperImpl()
    {
        final String DB_URL;

        final String USER;

        final String PASSWORD;

        Connection connection = null;

        log.debug("Loading GoodsMapper");
        DB_URL = LoadedProperties.getInstance().getProperties().getProperty("jdbc.url");
        USER = LoadedProperties.getInstance().getProperties().getProperty("jdbc.user");
        PASSWORD = LoadedProperties.getInstance().getProperties().getProperty("jdbc.password");
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
