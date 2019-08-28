package com.p.pichincha.mbbk.settings.controller;

<<<<<<< HEAD
import java.util.Map;

=======
>>>>>>> master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PatchMapping;
=======
>>>>>>> master
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p.pichincha.mbbk.settings.service.ISettingService;
<<<<<<< HEAD
import com.p.pichincha.mbbk.settings.dto.DataSettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;
import com.p.pichincha.mbbk.settings.model.Setting;
=======
import com.p.pichincha.mbbk.settings.dto.SettingDTO;
import com.p.pichincha.mbbk.settings.dto.SettingsRequest;
>>>>>>> master

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
	
<<<<<<< HEAD
	@PatchMapping(value = "/{ibs}/setting", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SettingDTO updateSetting(@PathVariable("ibs") String ibs,
			@RequestBody Map<String, Object> updates) throws Exception {
		
		SettingDTO settingDTO = new SettingDTO();
		DataSettingDTO dataSetting = settingService.updateSetting(ibs, updates);
		settingDTO.setData(dataSetting);
=======
	@PutMapping(value = "/{ibs}/setting", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public SettingDTO updateSetting(@PathVariable("ibs") String ibs,
			@RequestBody SettingsRequest settingsRequest) {
		
		SettingDTO settingDTO = settingService.updateSetting(ibs, settingsRequest);
>>>>>>> master
		settingDTO.setCode("000000");
		settingDTO.setDescription("Se realizó correctamente");
		
		return settingDTO;
		
	}

}
