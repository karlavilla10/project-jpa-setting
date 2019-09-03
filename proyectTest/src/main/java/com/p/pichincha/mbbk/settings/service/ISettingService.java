package com.p.pichincha.mbbk.settings.service;

import java.util.Map;

import com.p.pichincha.mbbk.settings.dto.DataSettingDTO;
import com.p.pichincha.mbbk.settings.dto.HeaderDTO;
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;

public interface ISettingService {
	
	SettingDTO getSettingForIbs(String ibs);
	HeaderDTO updateSetting(String ibs, Map<String, Object> body) throws Exception;
}