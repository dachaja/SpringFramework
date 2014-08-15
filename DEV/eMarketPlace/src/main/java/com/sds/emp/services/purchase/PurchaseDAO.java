package com.sds.emp.services.purchase;
 
import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.purchase.vo.PurchaseVO;
import com.sds.emp.view.paging.Page;

public interface PurchaseDAO {
	public int countPurchaseListByDeliveryCompany(String dlvyCompNo) throws Exception;
	public PurchaseVO getPurchase(String tranNo) throws Exception;
	public void addPurchase(PurchaseVO purchaseVO) throws Exception;
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception;
	public Page getPurchaseList(SearchVO searchVO) throws Exception;
}
