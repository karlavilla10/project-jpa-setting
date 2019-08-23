package com.p.pichincha.mbbk.settings.service.Impl;

import com.p.pichincha.mbbk.settings.dao.IsettingDAO;
import com.p.pichincha.mbbk.settings.dao.settingDao;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;
import com.p.pichincha.mbbk.settings.dto.SettingsResponse;
import com.p.pichincha.mbbk.settings.model.Setting;
import com.p.pichincha.mbbk.settings.service.IsettingService;

import ch.qos.logback.classic.Logger;

public class SettingServiceImpl implements IsettingService {
	
	private IsettingDAO settingDao;

	@Override
	public SettingsResponse getSetting(String ibs, SettingsRequest request) {
		
		SettingsResponse settingsResponse = new SettingsResponse();	
		try {
				Setting objectResult = settingDao.getSettingCustomer(request.getIbs());
				Setting objectSetting = new Setting();
				if(objectResult != null) {
					settingDao.settingCustomerUpdate(request.getIbs(), objectResult.isShowAmount());
				}else {
					objectSetting.setIbs(request.getIbs());
					objectSetting.setId(objectResult.getId());
					settingDao.insertSetting(objectSetting);
				}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return settingsResponse;
	}

	@Override
	public void updateSetting(Integer id, String ibs, boolean showAmount) {
		
	}
	
}
