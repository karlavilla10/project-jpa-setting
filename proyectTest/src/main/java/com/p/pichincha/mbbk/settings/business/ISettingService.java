package com.p.pichincha.mbbk.settings.business;

import java.util.Map;

import com.p.pichincha.mbbk.settings.model.dto.DataSettingDTO;
import com.p.pichincha.mbbk.settings.model.dto.HeaderDTO;
import com.p.pichincha.mbbk.settings.model.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.model.dto.SettingsRequest;

public interface ISettingService {
	
	SettingDTO getSettingForIbs(String ibs);
	HeaderDTO updateSetting(String ibs, Map<String, Object> body) throws Exception;
}