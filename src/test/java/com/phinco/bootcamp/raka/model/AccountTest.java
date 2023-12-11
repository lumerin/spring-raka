package com.phinco.bootcamp.raka.model;



import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.Calendar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



class AccountTest {

    @Test
    public void testAll() {
        Account account = new Account();
        account.setId("1");
        account.setName("raka");
        account.setType("pembeli");
        account.setAmount(50L);
        account.setCustomerId("1");
        account.setStatus(true);
        account.setCreatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        account.setUpdatedDate(null);

        assertThat(account.getId()).isEqualTo("1");
        assertThat(account.getName()).isEqualTo("raka");
        assertThat(account.getType()).isEqualTo("pembeli");
        assertThat(account.getAmount()).isEqualTo(50L);
        assertThat(account.getCustomerId()).isEqualTo("1");
        assertThat(account.status).isTrue();
        assertThat(account.getUpdatedDate()).isNull();


    }
}