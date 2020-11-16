package jdbc;

import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 余俊锋
 * @date 2020/9/9 9:26
 */
public class Test03 {
    public static void main(String[] args) {
        Connection conn = null;
        conn = JdbcUtils.getConn();
        String sql = "delete  from dept1 where id='10' ";
        PreparedStatement statement=null;
        try {
             statement = conn.prepareStatement(sql);
            int i = statement.executeUpdate();
            System.out.println("删除成功："+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(statement,conn);
        }

    }
}
