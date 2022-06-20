package app.core.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.exceptions.CouponSystemException;

@Service
@Scope("prototype")
@Transactional
public class CompanyService extends ClientService {

	public int getCompanyId() {
		return companyId;
	}

	private int companyId;

	@Override
	public boolean login(String email, String password) {
		Optional<Company> opt = this.companyRepository.findByEmailAndPassword(email, password);
		if (opt.isPresent()) {
			this.companyId = opt.get().getId();
			return true;
		}
		return false;
	}

	public List<Coupon> getCompanyCoupons() {
		return this.couponRepository.findByCompanyId(this.companyId);

	}

	public void addCoupon(Coupon coupon) throws CouponSystemException {
		if (this.couponRepository.existsById(coupon.getId())) {
			throw new CouponSystemException("add coupon faild - name already exist: " + coupon.getId());
		} else {

			this.couponRepository.save(coupon).getId();
		}

	}

	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt = this.couponRepository.findById(coupon.getId());
		if (opt.isPresent()) {
			Coupon couponFromDb = opt.get();
			couponFromDb.setCompany(coupon.getCompany());
			couponFromDb.setCategory(coupon.getCategory());
			couponFromDb.setTitle(coupon.getTitle());
			couponFromDb.setDescription(coupon.getDescription());
			couponFromDb.setStartDate(coupon.getStartDate());
			couponFromDb.setEndDate(coupon.getEndDate());
			couponFromDb.setAmount(coupon.getAmount());
			couponFromDb.setPrice(coupon.getPrice());
			couponFromDb.setImage(coupon.getImage());
		} else {
			throw new CouponSystemException("update company faild - not found: " + coupon.getId());
		}
		this.couponRepository.save(coupon).getId();
	}

	public void deleteCoupon(Coupon coupon) throws CouponSystemException {
		if (!this.couponRepository.existsById(coupon.getId())) {
			throw new CouponSystemException("add coupon faild - name already exist: " + coupon.getId());
		} else {

			this.couponRepository.deleteById(coupon).getId();
		}
	}

	public Company getCompanyByEmail(String email) {
		return companyRepository.findByEmail(email);
	}

}
