package com.sds.emp.services.sale;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.sale.vo.ProductVO;
import com.sds.emp.view.paging.Page;

public interface ProductDAO {
	public int countProductListByCategory(ProductVO productVO) throws Exception;
	public void addProduct(ProductVO productVO) throws Exception;
	public void updateProduct(ProductVO productVO) throws Exception;
	public ProductVO getProduct(ProductVO productVO) throws Exception;
	public Page getProductList(SearchVO searchVO) throws Exception;	
}
