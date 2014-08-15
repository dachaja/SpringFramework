package com.sds.emp.services.sale.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.sale.SaleDAO;
import com.sds.emp.services.sale.vo.SaleVO;
import com.sds.emp.view.paging.Page;

@Repository("saleDAO")
public class SaleDAOImpl extends SqlSessionDaoSupport implements SaleDAO {

	public void updateTranStatusCode(SaleVO saleVO) throws Exception {
		getSqlSession().update("Sale.updateProductTranStatusCode", saleVO);		
		getSqlSession().update("Sale.updateTransactionTranStatusCode", saleVO);
	}
	
	public SaleVO getSale(String prodNo) throws Exception {
		return (SaleVO) getSqlSession().selectOne("Sale.getSale", prodNo);
	}

	public Page getSaleList(SearchVO searchVO) throws Exception {
		int pageIndex = searchVO.getPageIndex();
		SaleVO saleVO = new SaleVO();
		
		String searchCondition = searchVO.getSearchCondition();
		if(searchCondition == null)
			searchCondition = "";
		
		String searchKeyword = searchVO.getSearchKeyword();
		if(searchKeyword == null)
			searchKeyword = "";
		
		if("".equals(searchCondition) || "0".equals(searchCondition))
			saleVO.setProdNo("%" + searchKeyword + "%");
		else
			saleVO.setProdName("%" + searchKeyword + "%");
		if(searchVO.getSearchTranStatusCode()!=null && !"A".equals(searchVO.getSearchTranStatusCode()))
			saleVO.setTranStatusCode(searchVO.getSearchTranStatusCode());
		
		if(searchVO.getSearchSellerId() != null && !"".equals(searchVO.getSearchSellerId()))
			saleVO.setSellerId(searchVO.getSearchSellerId());
		
		RowBounds rowBounds = new RowBounds((pageIndex * 3) - 3, 3);		
		ArrayList<SaleVO> saleList = (ArrayList<SaleVO>)getSqlSession().selectList("Sale.getSaleList", saleVO, rowBounds);
		Integer saleListCnt = (Integer)getSqlSession().selectOne("Sale.getSaleListCnt", saleVO);		
		Page resultPage = new Page(saleList, pageIndex, saleListCnt, 5, 3);
		
		return resultPage;
	}
}










