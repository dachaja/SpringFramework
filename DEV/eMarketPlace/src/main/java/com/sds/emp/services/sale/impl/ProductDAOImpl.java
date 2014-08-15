package com.sds.emp.services.sale.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.sale.ProductDAO;
import com.sds.emp.services.sale.vo.ProductVO;
import com.sds.emp.view.paging.Page;

@Repository("productDAO")
public class ProductDAOImpl extends SqlSessionDaoSupport implements ProductDAO {
	public int countProductListByCategory(ProductVO productVO) throws Exception {
		Integer cnt = (Integer) getSqlSession().selectOne("Product.countProductListByCategory", productVO);
		return cnt.intValue();
	}

	public void addProduct(ProductVO productVO) throws Exception {
		getSqlSession().insert("Product.addProduct", productVO);
	}

	public void updateProduct(ProductVO productVO) throws Exception {	
		getSqlSession().update("Product.updateProduct", productVO);
	}
	
	public ProductVO getProduct(ProductVO productVO) throws Exception {
		ProductVO product = (ProductVO) getSqlSession().selectOne("Product.getProduct", productVO);
		return product;
	}

	public Page getProductList(SearchVO searchVO) throws Exception {
		ProductVO productSearchVO = new ProductVO();	
	
		String searchCondition = searchVO.getSearchCondition();
		if(searchCondition == null)
			searchCondition = "";
		
		String searchKeyword = searchVO.getSearchKeyword();
		if(searchKeyword == null)
			searchKeyword = "";
		
		if("".equals(searchCondition) || "0".equals(searchCondition))
			productSearchVO.setProdNo("%" + searchKeyword + "%");
		else
			productSearchVO.setProdName("%" + searchKeyword + "%");
		if(searchVO.getSearchAsYn()!=null && !"A".equals(searchVO.getSearchAsYn()))
			productSearchVO.setAsYn(searchVO.getSearchAsYn());		
		
		RowBounds rowBounds = new RowBounds((searchVO.getPageIndex() * 3) - 3, 3);	
		ArrayList<ProductVO> productList = (ArrayList) getSqlSession().selectList("Product.getProductList", productSearchVO, rowBounds);
		Integer productListCnt = (Integer)getSqlSession().selectOne("ProductSearch.getProductListCnt", productSearchVO);

		Page resultPage = new Page(productList, searchVO.getPageIndex(), productListCnt, 5, 3);
		return resultPage;
		
	}
}
