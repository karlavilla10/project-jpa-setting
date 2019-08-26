package com.p.pichincha.mbbk.settings.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.p.pichincha.mbbk.settings.dao.IsettingDAO;
import com.p.pichincha.mbbk.settings.dao.settingDao;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.model.Setting;
import com.p.pichincha.mbbk.settings.service.IsettingService;

import ch.qos.logback.classic.Logger;

public class SettingServiceImpl implements IsettingService {
	
	@Autowired
	private IsettingDAO settingDao;

	@Override
	public Setting getSettingForIbs(String ibs) {
		
		return settingDao.findByIbs(ibs);
	}
	
}
