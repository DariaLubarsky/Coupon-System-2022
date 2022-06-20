package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.services.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	public CustomerService customerService;

//	@Autowired
//	private JwtUtil jwtUtil;

	@PostMapping("/customers/addCustomer")
	public int addCustomer(@RequestBody Customer customer, @RequestHeader String token) {
		try {
			return this.customerService.addCustomer(customer);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@GetMapping("/customers/getCustomerCoupons")
	public void getCustomerCoupons(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/customers/getCoupondByCategory")
	public void getCoupondByCategory(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/customers/getCustomerDetails")
	public void getCustomerDetails(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping("/customers/purchase")
	public void purchaseCoupon(@RequestBody Coupon coupon, @RequestBody Customer customer,
			@RequestHeader String token) {
		try {
//			int customerId = JwtUtil.extractId(token);
//			this.customerService.purchaseCoupon(customerId);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
