package com.atguigu.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.bookstore.dao.Dao;
import com.atguigu.bookstore.db.JDBCUtils;
import com.atguigu.bookstore.utils.ReflectionUtils;
import com.mysql.jdbc.Statement;

/**
 * 2019��1��7������2:00:48
 */
public class BaseDAO<T> implements Dao<T> {
    // ��Ƶ03 3'38"
    // JavaWeb֮DBUtils��һ��QueryRunner������ݱ������ɾ���飨8�ֽ��������ʽ�����Ĳ���
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;

    public BaseDAO() {
        clazz = ReflectionUtils.getSuperGenericType(getClass());
    }

    @Override
    public long insert(String sql, Object... args) {
        long id = 0;
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedstatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // ?
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    // setObject������JDBC��SQL����ռλ����ֵ��
                    preparedstatement.setObject(i + 1, args[i]);
                }
            }
            preparedstatement.executeUpdate();
            //��ȡ���ɵ�����
            resultSet = preparedstatement.getGeneratedKeys();
            // ?
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, preparedstatement);
            JDBCUtils.release(connection);
        }
        return id;
    }

    /*
     * (non-Javadoc)
     * @see com.atguigu.bookstore.dao.Dao#update(java.lang.String,
     * java.lang.Object[])
     */
    @Override
    public void update(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            queryRunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection);
        }
    }

    /*
     * (non-Javadoc)
     * @see com.atguigu.bookstore.dao.Dao#query(java.lang.String,
     * java.lang.Object[])
     */
    @Override
    public T query(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.atguigu.bookstore.dao.Dao#queryForList(java.lang.String,
     * java.lang.Object[])
     */
    @Override
    public List<T> queryForList(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.atguigu.bookstore.dao.Dao#getSingleVal(java.lang.String,
     * java.lang.Object[])
     */
    //��ȡĳһ��ֵ
    @Override
    public <V> V getSingleVal(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return (V) queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.atguigu.bookstore.dao.Dao#batch(java.lang.String,
     * java.lang.Object[][])
     */
    @Override
    public void batch(String sql, Object[]... params) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            queryRunner.batch(connection, sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
