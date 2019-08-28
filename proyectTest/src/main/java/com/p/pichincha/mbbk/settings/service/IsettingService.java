package com.p.pichincha.mbbk.settings.service;

import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;

public interface ISettingService {
	
	SettingDTO getSettingForIbs(String ibs);
	SettingDTO updateSetting(String ibs, SettingsRequest settingsRequest);
}