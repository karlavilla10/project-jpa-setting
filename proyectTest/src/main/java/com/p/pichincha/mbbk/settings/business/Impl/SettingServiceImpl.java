package com.p.pichincha.mbbk.settings.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p.pichincha.mbbk.settings.dao.IsettingDAO;
import com.p.pichincha.mbbk.settings.dto.DataSettingDTO;
import com.p.pichincha.mbbk.settings.dto.HeaderDTO;
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
	public HeaderDTO updateSetting(String ibs, Map<String, Object> body) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		//SettingDTO settingDTO = new SettingDTO();
		HeaderDTO headerDTO = new HeaderDTO();
		Setting setting = settingDao.findByIbs(ibs);
		mapper.updateValue(setting, body);
		setting = settingDao.save(setting);
//		DataSettingDTO data = new DataSettingDTO(setting);
//		settingDTO.setData(data);
		
		return headerDTO;
		
	}
}
