package com.example.doctor.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PATIENT-SERVICE")
public interface PatientProxy {
    @GetMapping("/patient/{name}")
    public String getName(@PathVariable String name);

}
