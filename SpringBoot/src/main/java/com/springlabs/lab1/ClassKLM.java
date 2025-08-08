package com.springlabs.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassKLM {

    @Autowired
    @Qualifier("classABC")  // You can change to "classXYZ" to test alternative injection
    private InterfacePQR interfacePQR;

    public void invoke() {
        interfacePQR.display();
    }
}