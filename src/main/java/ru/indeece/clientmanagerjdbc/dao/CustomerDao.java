package ru.indeece.clientmanagerjdbc.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.indeece.clientmanagerjdbc.model.Customer;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerDao {
    private final NamedParameterJdbcTemplate template;

    public CustomerDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<Customer> customerRowMapper = (rs, rowNum) -> {
        Customer c = new Customer();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        c.setEmail(rs.getString("email"));
        c.setPhone(rs.getString("phone"));
        c.setCreated(rs.getTimestamp("created").toLocalDateTime());
        return c;
    };

    @Transactional
    public Long create(Customer customer) {
        String sql = "INSERT INTO Customer(name, email, phone) VALUES (:name, :email, :phone)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", customer.getName());
        map.put("email", customer.getEmail());
        map.put("phone", customer.getPhone());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, new MapSqlParameterSource(map), keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Transactional
    public int update(Customer customer) {
        String sql = "UPDATE Customer SET name = :name, email = :email, phone = :phone WHERE id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", customer.getId());
        map.put("name", customer.getName());
        map.put("email", customer.getEmail());
        map.put("phone", customer.getPhone());

        return template.update(sql, map);
    }

    @Transactional
    public int delete(Long id) {
        String sql = "DELETE FROM Customer WHERE id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        return template.update(sql, map);
    }

    @Transactional
    public Customer findById(Long id) {
        String sql = "SELECT * FROM Customer WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return template.queryForObject(sql, params, customerRowMapper);
    }
}
