package kr.hs.study.dao;

import kr.hs.study.dto.testDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class Mapper implements RowMapper<testDTO> {
    @Override
    public testDTO mapRow(ResultSet rs, int i) throws SQLException {
        testDTO t = new testDTO();

        t.setData1(rs.getInt("data1"));
        t.setData2(rs.getString("data2"));

        return t;
    }
}
