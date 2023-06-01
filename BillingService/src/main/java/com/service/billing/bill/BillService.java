package com.service.billing.bill;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/rest/bill")
public class BillService {
	
	
			String strMessage;
			@GetMapping
			public String welcome() {
				return "billing" + strMessage;
				
				
			}
			
	}


