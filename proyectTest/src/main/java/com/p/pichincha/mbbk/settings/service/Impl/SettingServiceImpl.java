package com.p.pichincha.mbbk.settings.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.pichincha.mbbk.settings.dao.IsettingDAO;
import com.p.pichincha.mbbk.settings.dto.DataSettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;
import com.p.pichincha.mbbk.settings.model.Setting;
import com.p.pichincha.mbbk.settings.service.ISettingService;

@Service
public class SettingServiceImpl implements ISettingService {
	
	@Autowired
	private IsettingDAO settingDao;

	@Override
	public SettingDTO getSettingForIbs(String ibs) {
		
		SettingDTO settingDTO = new SettingDTO();
		Setting setting = new Setting();
		setting = settingDao.findByIbs(ibs);
		DataSettingDTO data = new DataSettingDTO();
		data.setShowAmount(setting.isShowAmount());
		settingDTO.setData(data);
		
		return settingDTO;
	}
	
	@Override 
	public SettingDTO updateSetting(String ibs, SettingsRequest settingsRequest) {
		
		SettingDTO settingResponse = new SettingDTO();
		Setting setting = new Setting();
		setting.setIbs(ibs);
		setting.setShowAmount(settingsRequest.isShowAmount());
		setting = settingDao.save(setting);
		DataSettingDTO data = new DataSettingDTO();
		settingResponse.setData(data);
		
		return settingResponse;
		
	}
}
