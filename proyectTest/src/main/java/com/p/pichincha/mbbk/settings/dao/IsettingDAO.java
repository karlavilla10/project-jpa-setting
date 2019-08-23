package com.p.pichincha.mbbk.settings.dao;

import com.p.pichincha.mbbk.settings.model.Setting;

public interface IsettingDAO {
	
	//Se declara metodos para consultar y actualizar en la BD
	public Setting getSettingCustomer(String ibs);
	public void settingCustomerUpdate(String ibs, boolean showAmount);
	public void insertSetting(Setting setting);

}
