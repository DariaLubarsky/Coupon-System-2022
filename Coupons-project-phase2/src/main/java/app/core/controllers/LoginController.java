package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.services.AdminService;
import app.core.services.CompanyService;
import app.core.services.CustomerService;
import app.core.util.JwtUtil;
import app.core.util.JwtUtil.Client;
import app.core.util.JwtUtil.Client.ClientType;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private JwtUtil jwtUtil;

	@PutMapping("/login/{email}/{password}")
	public String login(@RequestParam String email, @RequestParam String password,
			@RequestParam ClientType clientType) {
		switch (clientType) {
		case ADMIN:
			if (adminService.login(email, password)) {
				return this.jwtUtil.generateToken(new Client(email, ClientType.ADMIN, 0));
			}
			break;
		case COMPANY:
			if (companyService.login(email, password)) {
				int companyId = companyService.getCompanyByEmail(email).getId();
				return this.jwtUtil.generateToken(new Client(email, ClientType.COMPANY, companyId));

			}
			break;
		case CUSTOMER:
			if (customerService.login(email, password)) {
				int customerId = customerService.getCustomerByEmail(email).getId();
				return this.jwtUtil.generateToken(new Client(email, ClientType.CUSTOMER, customerId));
			}
			break;
		default:
			break;
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong email or password or both");

	}

//	@PutMapping("/logout")
//	public void logout() {
//		login.logout();
//	}
}
