package com.p.pichincha.mbbk.settings.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.p.pichincha.mbbk.settings.dto.DataSettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.service.IsettingService;

@RestController
@RequestMapping("/channel/mbbk/v1.0/auth/session")
public class settingController {
	
	@Value("${setting.url-api-setting}")
	private String urlApiSetting;
	
	@Value("${setting.url-api-setting-output}")
	private String urlApiSettingOutput;
	
	@Value("${setting.url-api-setting-update}")
	private String urlApiSettingUpdate;
	
	private IsettingService isettingService;
	
	@GetMapping(value = "/setting", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public SettingDTO getSetting(@RequestBody SettingsRequest settingsRequest) {
		
		SettingDTO settingsResponse = new SettingDTO();
		RestTemplate restTemplate = new RestTemplate();
		
		SettingDTO settingDTO = restTemplate.getForObject(urlApiSetting + settingsRequest.ibs + urlApiSettingOutput, SettingDTO.class);
		settingDTO.setCode("000000");
		settingDTO.setDescription("Se realizó correctamente");
		
		return settingsResponse;
	}
	
	@PutMapping(value = "/update/setting", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public SettingDTO updateSetting(@RequestBody SettingsRequest setting) {
		
		SettingDTO response = new SettingDTO();
		RestTemplate restTemplate = new RestTemplate();
		
		SettingDTO settingDTO = restTemplate.getForObject(urlApiSettingUpdate + setting.ibs + urlApiSettingOutput, SettingDTO.class);
		response.setData(getData().getShowAmount());
		settingDTO.setCode("000000");
		settingDTO.setDescription("Se realizó correctamente");
		
		return response;
		
	}

}
