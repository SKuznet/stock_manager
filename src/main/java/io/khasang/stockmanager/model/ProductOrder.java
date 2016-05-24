package io.khasang.stockmanager.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductOrder implements TableObjectInterface {
    private SimpleDriverDataSource dataSource;

    private JdbcTemplate jdbcTemplate;
    private int id;
    private String user;

    public ProductOrder() {
    }

    public ProductOrder(SimpleDriverDataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public SimpleDriverDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List selectWholeTable() throws SQLException{
        return this.jdbcTemplate.query("select id, user "+
        "from template", new ItemMapper());
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    final class ItemMapper implements RowMapper<ProductOrder> {
        public ProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException{
            ProductOrder productorder = new ProductOrder();
            productorder.setId(rs.getInt("id"));
            productorder.setUser(rs.getString("user"));
            return productorder;
        }
    }

}
