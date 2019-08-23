package com.p.pichincha.mbbk.settings.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.p.pichincha.mbbk.settings.model.Setting;

/**
 * @author CARORR
 *
 */
public class settingDao implements IsettingDAO {
	
   @PersistenceContext
    private EntityManager entityManager;
   
   @Override
   	public void insertSetting(Setting setting) {
	   entityManager.persist(setting);
   }

	@Override
	public Setting getSettingCustomer(String ibs) {
		Setting settingEntity = null;
		String hql = "SELECT * FROM Setting as s WHERE s.id = :id";
		Query query = entityManager.createQuery(hql).
			setParameter("ibs", ibs);
			query.setMaxResults(1);
			List resultsSettings = query.getResultList();
			if(!resultsSettings.isEmpty()){
				settingEntity = (Setting) resultsSettings.get(0);
	        }
		return settingEntity;		
		
	}

	@Override
	public void settingCustomerUpdate(String ibs, boolean showAmount) {
		String hql = "UPDATE Setting s SET s.ibs = :ibs WHERE s.id = :id";
		Query query = entityManager.createQuery(hql).
		setParameter("ibs", ibs).
		setParameter("showAmount", showAmount);
		query.executeUpdate();		
	}
	
}
