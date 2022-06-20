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

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	public AdminService adminService;

	@PostMapping("/companies/addcompany")
	public int addcompany(@RequestBody Company company, @RequestHeader String token) {
		try {
			return this.adminService.addCompany(company);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@PutMapping("/companies/updateCompany")
	public void updateCompany(@RequestBody Company company, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/companies/deleteCompany")
	public void deleteCompany(@RequestBody int id, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/companies/gettAllCompanies")
	public void gettAllCompanies(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/companies/getCompany")
	public void getCompany(@RequestBody int id, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// ===================================================

	@PostMapping("/customers/addCustomer")
	public int addCustomer(@RequestBody Customer customer, @RequestHeader String token) {
		try {
			return this.adminService.addCustomer(customer);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/customers/getOneCustomer")
	public void getOneCustomer(@RequestBody int id, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/customers/getAllCustomers")
	public void getAllCustomers(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/customers/deleteCustomer")
	public void deleteCustomer(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping("/customers/updateCustomer")
	public void updateCustomer(@RequestBody Customer customer, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

//====================================================
	@PostMapping("/coupons/addCoupon")
	public int addCoupon(@RequestBody Coupon coupon, @RequestHeader String token) {
		try {
			return this.adminService.addCoupon(coupon);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/coupons/getCompanyCoupons")
	public void getCompanyCoupons(@RequestHeader String token) {
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

	@GetMapping("/coupons/getOneCoupon")
	public void getOneCoupon(@RequestBody int id, @RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/coupons/deleteCoupon")
	public void deleteCoupon(@RequestHeader String token) {
		try {
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/coupons/isCouponExists")
	public boolean isCouponExists(@RequestHeader Coupon coupon, @RequestHeader String token) {
		try {
			return this.adminService.isCouponExists(coupon);
		} catch (CouponSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
