//package com.phinco.bootcamp.raka.model;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.sql.Timestamp;
//import java.util.Calendar;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@RunWith(SpringRunner.class)
//class CustomerTest {
//    @Test
//    public void testAll() {
//        Customer customer = new Customer();
//        customer.setId("1");
//        customer.setName("raka");
//        customer.setStatus(true);
//        customer.setCreatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//        customer.setUpdatedDate(null);
//
//        assertThat(customer.getId()).isEqualTo("1");
//        assertThat(customer.getName()).isEqualTo("raka");
//        assertThat(customer.status).isTrue();
//        assertThat(customer.getUpdatedDate()).isNull();
//
//
//    }
//}