package com.onlineVote.OnlineVotingSystem_angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "model")
public class OnlineVotingSystemAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineVotingSystemAngularApplication.class, args);
    }
}


