package com.p.pichincha.mbbk.settings.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingDTO extends HeaderDTO {
	
	private DataSettingDTO data;

}
