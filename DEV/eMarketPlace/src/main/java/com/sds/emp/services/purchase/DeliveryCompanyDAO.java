package com.sds.emp.services.purchase;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.purchase.vo.DeliveryCompanyVO;
import com.sds.emp.view.paging.Page;

public interface DeliveryCompanyDAO {
	public void addDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception;
	public void updateDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception;
	public DeliveryCompanyVO getDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception;
	public Page getDeliveryCompanyList(SearchVO searchVO) throws Exception;
}
