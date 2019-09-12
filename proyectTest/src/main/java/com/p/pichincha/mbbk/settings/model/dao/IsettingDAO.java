package com.p.pichincha.mbbk.settings.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p.pichincha.mbbk.settings.model.Setting;

@Repository
public interface IsettingDAO extends JpaRepository<Setting, String> {
	
	Setting findByIbs(String ibs);

	boolean existsByIbs(String ibs);
}
