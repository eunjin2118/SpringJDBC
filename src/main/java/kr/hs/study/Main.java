package kr.hs.study;

import kr.hs.study.dao.testDAO;
import kr.hs.study.config.BeanConfigClass;
import kr.hs.study.dto.testDTO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);


        testDAO dao = ctx.getBean(kr.hs.study.dao.testDAO.class);

        // 데이터 저장할 bean 생성
        // form대신
//        testDTO t = new testDTO();
//        t.setData1(1);
//        t.setData2("spring1");
//
//        dao.insert(t);


//        testDTO t = new testDTO();
//        t.setData1(2);
//        t.setData2("spring2222222");
//
//        dao.update(t);

        testDTO t = new testDTO();
        t.setData1(1);

        dao.delete(t);

        ctx.close();
    }
}