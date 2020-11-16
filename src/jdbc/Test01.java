package jdbc;

import utils.JdbcUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 余俊锋
 * @date 2020/9/8 17:07
 */
public class Test01 {
    public static void main(String[] args) {
        /**
         * 插入数据
         */

        Connection connection = JdbcUtils.getConn();
        //加载驱动
        //连接数据库
        //获取ps对象
        // String sql="insert into dept1(id,name) values('10','刘邦')";
        String sql = "insert into dept1(id,name) values(?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, 12);
            ps.setObject(2, "王九蛋");
            //获取结果集
            int update = ps.executeUpdate();
            System.out.println("修改结果;"+update);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ps,connection);
        }


    }
}
