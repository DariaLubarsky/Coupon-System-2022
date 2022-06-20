package app.core.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.util.JwtUtil.Client;

@Service
@Scope("prototype")
@Transactional
public class CustomerService extends ClientService {

	public int getCustomerId() {
		return customerId;
	}

	private int customerId;
	private EnumType couponCategory;

	@Override
	public boolean login(String email, String password) {
		Optional<Customer> opt = this.customerRepository.findByEmailAndPassword(email, password);
		if (opt.isPresent()) {
			this.customerId = opt.get().getId();
			return true;
		}
		return false;
	}

	public int addCustomer(Customer customer) throws CouponSystemException {
		if (this.customerRepository.existsByFirstNameAndLastName(customer.getFirstName(), customer.getLastName())) {
			throw new CouponSystemException(
					"add customer faild - name already exist: " + customer.getFirstName() + customer.getLastName());
		}
		return this.customerRepository.save(customer).getId();
	}

	public List<Coupon> getCustomerCoupons() {
		return this.couponRepository.findByCustomersId(this.customerId);

	}

	public List<Coupon> getCoupondByCategory(int customerId, EnumType couponCategory) {
		return this.couponRepository.findByCustomersIdAndCategory(this.customerId, this.couponCategory);
	}

	// public List<Coupon> getCouponsByPrice() {
	// return this.couponRepository.findByPrice(this.customerId);
	// }

	public Customer getCustomerDetails() throws CouponSystemException {

		Optional<Customer> opt = customerRepository.findById(this.customerId);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CouponSystemException("failed to get customer " + this.customerId);
		}

	}

	public void purchaseCoupon(int couponId) throws CouponSystemException {
		if (couponRepository.existsById(couponId)) {
			Coupon coupon = couponRepository.findById(couponId).get();
			if (!couponRepository.existsByIdAndCustomersId(coupon.getId(), customerId)) {
				if (coupon.getAmount() > 0 && coupon.getEndDate().isAfter(LocalDate.now())) {
					getCustomerDetails().addCoupon(coupon);
					coupon.setAmount(coupon.getAmount() - 1);
					couponRepository.save(coupon);
					System.out.printf("coupon %d purchased successfully \n", coupon.getId());
				} else {
					throw new CouponSystemException(
							"failed to purchase coupon " + coupon.getId() + " - coupon expired or is out of stock");
				}
			} else {
				throw new CouponSystemException(
						"failed to purchase coupon " + coupon.getId() + " - coupon already purchased");
			}
		} else {
			throw new CouponSystemException("failed to purchase coupon " + couponId + " - coupon does not exist");
		}
	}

	public Client getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
}
