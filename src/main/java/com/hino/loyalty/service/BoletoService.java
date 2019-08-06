package com.hino.loyalty.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.hino.loyalty.domain.BoletoPayment;

@Service
public class BoletoService {

	public void fullfillBoletoPayment(BoletoPayment boleto, Date orderDate) {
		
		//for dummy matters (no webservice integrated to a bank that generates a boleto
		Calendar cal = Calendar.getInstance();
		cal.setTime(orderDate);
		cal.add(Calendar.DAY_OF_MONTH, 5);
		boleto.setDueDate(cal.getTime());
	}

}
