package com.p.pichincha.mbbk.settings.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p.pichincha.mbbk.settings.model.Setting;

public interface IsettingDAO extends JpaRepository<Setting, String> {
	
	Setting findByIbs(String ibs);
}
