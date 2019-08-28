package com.p.pichincha.mbbk.settings.dto;

import com.p.pichincha.mbbk.settings.model.Setting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataSettingDTO {
	
	private boolean showAmount;
	
	public DataSettingDTO(Setting setting) {
		
		this.showAmount = setting.isShowAmount();
	}
}
