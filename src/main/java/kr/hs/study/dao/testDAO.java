package kr.hs.study.dao;

import kr.hs.study.dto.testDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class testDAO {
    // 실제 디비에 접속해서 쿼리를 날림
    // 쿼리 날리는 예 : jdbcTemplate

    //JdbcTemplate jdbc = new JdbcTemplate();
    @Autowired
    JdbcTemplate jdbc; // 컨테이너에서 같은타입의 객체를 찾아서 대입

    @Autowired
    Mapper mapper;
    // Mapper mapper = new Mapper();

    // 저장 (insert)
    public void insert(testDTO dto ){
        String sql = "insert into test values(?,?)";

        jdbc.update(sql, dto.getData1(), dto.getData2());
    }

    public void update(testDTO dto){
        String sql = "update test set data2 = ? where data1=?";

        jdbc.update(sql, dto.getData2(), dto.getData1());
    }

    public void delete(testDTO dto){
        String sql = "delete from test where data1=?";
        jdbc.update(sql, dto.getData1());
    }

    // list
    public List<testDTO> select(){
        String sql = "select * from test";
        List<testDTO> list = jdbc.query(sql, mapper);
        return list;
    }
}
