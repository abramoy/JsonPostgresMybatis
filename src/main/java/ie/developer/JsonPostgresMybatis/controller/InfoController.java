package ie.developer.JsonPostgresMybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ie.developer.JsonPostgresMybatis.mappers.AddressMapper;
import ie.developer.JsonPostgresMybatis.model.Address;
import ie.developer.JsonPostgresMybatis.model.Customer;

@RestController
public class InfoController {
	
	@Autowired
	AddressMapper addressmapper;

	@RequestMapping(value="/getAddress", method = RequestMethod.GET)
	@ResponseBody
	public Address getAddresses() {
		printCustomer();
		Address address =addressmapper.getAddress(1L);
		return address;
		
	}

	private void printCustomer() {
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = new Customer();
		customer.setCustomer("Johnny");
		try {
			System.out.println(mapper.writeValueAsString(customer));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
