package com.sds.emp.services.purchase.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.purchase.DeliveryCompanyDAO;
import com.sds.emp.services.purchase.vo.DeliveryCompanyVO;
import com.sds.emp.services.sale.vo.CategoryVO;
import com.sds.emp.view.paging.Page;

@Repository
public class DeliveryCompanyDAOImpl extends SqlSessionDaoSupport implements DeliveryCompanyDAO {
	public void addDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception {
		getSqlSession().insert("DeliveryCompany.addDeliveryCompany", deliveryCompanyVO);
	}

	public void updateDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception {
		getSqlSession().update("DeliveryCompany.updateDeliveryCompany", deliveryCompanyVO);
	}
	
	public DeliveryCompanyVO getDeliveryCompany(DeliveryCompanyVO deliveryCompanyVO) throws Exception {
		return (DeliveryCompanyVO) getSqlSession().selectOne("DeliveryCompany.getDeliveryCompany", deliveryCompanyVO);
	}

	public Page getDeliveryCompanyList(SearchVO searchVO) throws Exception {
		DeliveryCompanyVO deliveryCompanyVO = new DeliveryCompanyVO();
		
		String searchCondition = searchVO.getSearchCondition();
		if(searchCondition == null)
			searchCondition = "";
		
		String searchKeyword = searchVO.getSearchKeyword();
		if(searchKeyword == null)
			searchKeyword = "";
	
		if("".equals(searchCondition) || "0".equals(searchCondition))
			deliveryCompanyVO.setDlvyCompNo("%" + searchKeyword + "%");
		else
			deliveryCompanyVO.setDlvyCompName("%" + searchKeyword + "%");
		
		if(searchVO.getSearchUseYn()!= null && !"A".equals(searchVO.getSearchUseYn()))
			deliveryCompanyVO.setUseYn(searchVO.getSearchUseYn());		
		
		RowBounds rowBounds = new RowBounds((searchVO.getPageIndex() * 3) - 3, 3);	
		ArrayList<CategoryVO> deliveryCompanyList = (ArrayList) getSqlSession().selectList("DeliveryCompany.getDeliveryCompanyList", deliveryCompanyVO, rowBounds);
		Integer deliveryCompanyListCnt = (Integer)getSqlSession().selectOne("DeliveryCompany.getDeliveryCompanyListCnt", deliveryCompanyVO);

		Page resultPage = new Page(deliveryCompanyList, searchVO.getPageIndex(), deliveryCompanyListCnt, 5, 3);
		return resultPage;
	}
}
