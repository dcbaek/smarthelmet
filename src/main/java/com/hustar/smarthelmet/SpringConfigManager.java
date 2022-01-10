package com.hustar.smarthelmet;

import com.hustar.smarthelmet.repository.ManagerRepository;
import com.hustar.smarthelmet.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigManager {

    private final ManagerRepository managerRepository;

    @Autowired
    public SpringConfigManager(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Bean
    public ManagerService managerService() {
        return new ManagerService(managerRepository);
    }

}
