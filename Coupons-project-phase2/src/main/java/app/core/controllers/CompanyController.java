package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Coupon;
import app.core.exceptions.CouponSystemException;
import app.core.services.CompanyService;

@RestController
@RequestMapping("/api/company")

public class CompanyController {

	@Autowired
	public CompanyService companyService;

	@GetMapping("/companies/getCompanyId")
	public void getCompanyId(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/companies/getCompanyCoupons")
	public void getCompanyCoupons(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping("/coupons/addCoupon")
	public void addCoupon(@RequestBody Coupon coupon, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping("/coupons/updateCoupon")
	public void updateCoupon(@RequestBody Coupon coupon, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/coupons/deleteCoupon")
	public void deleteCoupon(@RequestBody int id, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
