package com.sds.emp.services.sale;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.sale.vo.SaleVO;
import com.sds.emp.view.paging.Page;

public interface SaleDAO {
	public void updateTranStatusCode(SaleVO saleVO) throws Exception;
	public SaleVO getSale(String prodNo) throws Exception;
	public Page getSaleList(SearchVO searchVO) throws Exception;
}
