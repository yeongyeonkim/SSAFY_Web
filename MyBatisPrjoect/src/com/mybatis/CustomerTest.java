package com.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class CustomerTest {

    public static void main(String[] args) {
        String conf = "res/Configuration.xml";
        Reader reader;

        try {
            reader = Resources.getResourceAsReader(conf);//read conf xml file 
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            SqlSession session = factory.openSession();
            List<Customer> list;

            try {
            	//0. delete
            	session.delete("Customer.delete", "900"); //dml 실행 후
            	session.commit();  //commit 혹은 rollback 해줘야해
            	
            	//1. select all data:
            	//selectList: 여러개의 데이터 가져올때
            	list = session.selectList("selectAll");
            	list = session.selectList("Customer.selectAll");
                for(Customer rec : list) {
                    System.out.println(rec.getNum()+"--"+rec.getName()+"--"+rec.getAddress());
                }

            	//2. select one data
            	Customer vo = (Customer) session.selectOne("Customer.selectOne", "111");
                System.out.println(vo.getName()+"--"+vo.getAddress());

                //3. insert data
                Customer insert = new Customer("900", "geene", "la");
                session.insert("Customer.insert", insert);
                session.commit();//dml 실행 후 commit() or rollback()해줄것
                list = session.selectList("Customer.selectAll");
                
                System.out.println("after insert-------------------");
                for(Customer rec : list) {
                	System.out.println(rec.getNum()+"--"+rec.getName()+"--"+rec.getAddress());
                }
                
                //4. update data
                
            	
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
