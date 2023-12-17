package edu.itstep.javaintro.collections;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

class TestMySql {
    //test purposes only
    private final static Logger log = Logger.getLogger(TestMySql.class.getName());
    private Connection conn;//connection to database
    private Statement st;

    @BeforeEach
    public void setUp() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/albums";
            String user = "root";
            String password = "cisco";
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            log.info("Connection to database is OK!");
        } catch (SQLException sql) {
            log.error("problem with driver. Not found!");
            sql.printStackTrace();
        }
    }

    @Test
    void testCreateTable() throws SQLException {
        String sql = "create table if not exists users  (" +
                "id integer primary key  AUTO_INCREMENT," +
                "user_name varchar(20) not null UNIQUE," +
                "password varchar(20) not null)";
        st.execute(sql);
    }

    @Test
    void testUserName() throws SQLException {
        String sql = "select user_name from albums.users where user_name='user1'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Assertions.assertTrue(rs.next());
        ps.close();
        rs.close();
    }

    @Test
    void testAlbumName() throws SQLException {
        String sql = "";
    }
}
