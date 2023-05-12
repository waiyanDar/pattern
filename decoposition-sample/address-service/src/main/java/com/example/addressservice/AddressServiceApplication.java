package com.example.addressservice;

import com.example.addressservice.dao.AddressDao;
import com.example.addressservice.entity.Address;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class AddressServiceApplication {

    private final AddressDao addressDao;

    public AddressServiceApplication(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Bean
    @Transactional @Profile("dev")
    public ApplicationRunner runner(){
        return args -> {
            Address ad1 = new Address("dream land","799","Mdy","12345");
            Address ad2 = new Address("Ma Ma yin kwin","1500","ma ma's heart","12356");
            Address ad3 = new Address("nyi ma lay","528","ma thi buu","12378");
            Address ad4 = new Address("team mama","122","Ygn","123655");

            addressDao.save(ad1);
            addressDao.save(ad2);
            addressDao.save(ad3);
            addressDao.save(ad4);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceApplication.class, args);
    }

}
