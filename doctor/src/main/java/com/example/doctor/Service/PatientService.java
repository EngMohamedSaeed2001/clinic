package com.example.doctor.Service;

import com.example.doctor.Proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientService {

    @Autowired
    private PatientProxy patientProxy;
    public String getPatient(String name){
        RestTemplate restTemplate = new RestTemplate();
        String patientName = restTemplate.getForObject("http://localhost:9000/patient/"+name,String.class);

        return patientName;
    }

    public String getPatientByFeignClient(String name){
        return patientProxy.getName(name);
    }
}
