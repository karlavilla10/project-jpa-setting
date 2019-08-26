package com.p.pichincha.mbbk.settings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p.pichincha.mbbk.settings.service.ISettingService;
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;

@RestController
@RequestMapping("/support/mbbk/v1.0/config/persons")
public class settingController {
	
	@Value("${spring.datasource.url}")
	private String urlApiSetting;
	
	@Autowired
	public ISettingService settingService;
	
	
	@GetMapping(value = "/{ibs}/setting", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public SettingDTO getSetting(@PathVariable("ibs") String ibs) {
	
		SettingDTO settingDTO = settingService.getSettingForIbs(ibs);
		settingDTO.setCode("000000");
		settingDTO.setDescription("Se realizó correctamente");
		
		return settingDTO;
	}
	
	@PutMapping(value = "/{ibs}/setting", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public SettingDTO updateSetting(@PathVariable("ibs") String ibs,
			@RequestBody SettingsRequest settingsRequest) {
		
		SettingDTO settingDTO = settingService.updateSetting(ibs, settingsRequest);
		settingDTO.setCode("000000");
		settingDTO.setDescription("Se realizó correctamente");
		
		return settingDTO;
		
	}

}
