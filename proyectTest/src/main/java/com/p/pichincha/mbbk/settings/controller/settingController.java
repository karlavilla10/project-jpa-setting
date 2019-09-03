package com.p.pichincha.mbbk.settings.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p.pichincha.mbbk.settings.dto.DataSettingDTO;
import com.p.pichincha.mbbk.settings.dto.HeaderDTO;
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.service.ISettingService;

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
	
	@PatchMapping(value = "/{ibs}/setting", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HeaderDTO updateSetting(@PathVariable("ibs") String ibs,
			@RequestBody Map<String, Object> updates) throws Exception {
		
		HeaderDTO headerDTO = new HeaderDTO();
		headerDTO = settingService.updateSetting(ibs, updates);
		headerDTO.setCode("000000");
		headerDTO.setDescription("Se realizó correctamente");
		
		return headerDTO;
		
	}

}
