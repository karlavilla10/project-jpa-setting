package com.p.pichincha.mbbk.settings.service;

import java.util.Map;

import com.p.pichincha.mbbk.settings.dto.DataSettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;
import com.p.pichincha.mbbk.settings.model.Setting;

public interface ISettingService {
	
	SettingDTO getSettingForIbs(String ibs);
	DataSettingDTO updateSetting(String ibs, Map<String, Object> body) throws Exception;
}