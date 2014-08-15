package com.sds.emp.services.purchase.impl;
 
import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.purchase.PurchaseDAO;
import com.sds.emp.services.purchase.vo.PurchaseVO;
import com.sds.emp.services.sale.vo.CategoryVO;
import com.sds.emp.view.paging.Page;

@Repository
public class PurchaseDAOImpl extends SqlSessionDaoSupport implements PurchaseDAO {
	public int countPurchaseListByDeliveryCompany(String dlvyCompNo) throws Exception {
		Integer cnt = (Integer) getSqlSession().selectOne("Purchase.getPurchaseListByDeliveryCompany", dlvyCompNo);
		return cnt.intValue();
	}
	
	public PurchaseVO getPurchase(String tranNo) throws Exception {
		return (PurchaseVO) getSqlSession().selectOne("Purchase.getPurchase", tranNo);
	}

	public void addPurchase(PurchaseVO purchaseVO) throws Exception {
		String tranStatusCode = "002";  //주문접수
		purchaseVO.setTranStatusCode(tranStatusCode);

		getSqlSession().insert("Purchase.addPurchase", purchaseVO);		
		getSqlSession().update("Purchase.updateProdTranStatusCode", purchaseVO);
	}
		
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		getSqlSession().update("Purchase.updatePurchase", purchaseVO);
	}

	public Page getPurchaseList(SearchVO searchVO) throws Exception {
		PurchaseVO purchaseVO = new PurchaseVO();
		
		String searchCondition = searchVO.getSearchCondition();
		if(searchCondition == null)
			searchCondition = "";
		
		String searchKeyword = searchVO.getSearchKeyword();
		if(searchKeyword == null)
			searchKeyword = "";
	
		if("".equals(searchCondition) || "0".equals(searchCondition))
			purchaseVO.setProdNo("%" + searchKeyword + "%");
		else
			purchaseVO.setProdName("%" + searchKeyword + "%");
		
		if(searchVO.getSearchTranStatusCode()!= null && !"A".equals(searchVO.getSearchTranStatusCode()))
			purchaseVO.setTranStatusCode(searchVO.getSearchTranStatusCode());	

		purchaseVO.setBuyerId(searchVO.getSearchBuyerId());

		RowBounds rowBounds = new RowBounds((searchVO.getPageIndex() * 3) - 3, 3);
		ArrayList<CategoryVO> deliveryCompanyList = (ArrayList) getSqlSession().selectList("Purchase.getPurchaseList", purchaseVO, rowBounds);
		Integer deliveryCompanyListCnt = (Integer)getSqlSession().selectOne("Purchase.getPurchaseListCnt", purchaseVO);
		
		Page resultPage = new Page(deliveryCompanyList, searchVO.getPageIndex(), deliveryCompanyListCnt, 5, 3);
		return resultPage;
	}
}
