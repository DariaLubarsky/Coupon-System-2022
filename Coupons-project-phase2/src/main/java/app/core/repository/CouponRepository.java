package app.core.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EnumType;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	List<Coupon> findByCompanyId(int companyId);

	List<Coupon> findByCustomersId(int customerId);

	Coupon deleteById(Coupon coupon);

	List<Coupon> findByCustomersIdAndCategory(int customerId, EnumType couponCategory);

	List<Coupon> findByPrice(int customerId);

	boolean existsByIdAndCustomersId(int id, int customerId);

	void deleteByEndDateBefore(LocalDate now);

}
