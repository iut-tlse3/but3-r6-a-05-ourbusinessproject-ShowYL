package com.example.ourbusinessproject;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap {

    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService){
        this.initializationService = initializationService;
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }

    @PostConstruct
    public void init(){
        try {
            this.initializationService.initProjects();
        } catch (RuntimeException e) {
            return;
        }
    }
}
