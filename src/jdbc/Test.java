package jdbc;

import utils.JdbcUtils;

import java.sql.*;

/**
 * @author 余俊锋
 * @date 2020/9/8 16:54
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 查询
         */
        Connection connection = null;
        ResultSet resultSet = null;

        //加载驱动
        //连接数据库
        connection = JdbcUtils.getConn();
        //获取ps对象
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("select * from dept1");
            //获取结果集
            resultSet = ps.executeQuery();

            //遍历
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + ":" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet,ps,connection);
        }


    }
}
