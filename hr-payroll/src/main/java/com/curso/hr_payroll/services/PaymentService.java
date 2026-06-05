package com.curso.hr_payroll.services;

import com.curso.hr_payroll.entities.Payment;
import com.curso.hr_payroll.entities.Worker;
import com.curso.hr_payroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPaymentRestTemplate(long workerId, int days) {
        Map<String, String> urlVariable = new HashMap<>();
        urlVariable.put("id", "" + workerId);

        String url = workerHost + "/workers/{id}";
        Worker worker = restTemplate.getForObject(url, Worker.class, urlVariable);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
