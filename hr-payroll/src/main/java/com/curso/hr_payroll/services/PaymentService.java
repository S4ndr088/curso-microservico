package com.curso.hr_payroll.services;

import com.curso.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
       return new Payment("Bob", 200.0, days);
    }

}
