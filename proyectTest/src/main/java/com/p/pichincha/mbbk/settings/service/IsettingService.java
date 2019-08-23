package com.p.pichincha.mbbk.settings.service;

import com.p.pichincha.mbbk.settings.dto.SettingsRequest;
import com.p.pichincha.mbbk.settings.dto.SettingsResponse;

public interface IsettingService {
	
	void updateSetting(Integer id, String ibs, boolean showAmount);
	SettingsResponse getSetting(String ibs, SettingsRequest request);

}
