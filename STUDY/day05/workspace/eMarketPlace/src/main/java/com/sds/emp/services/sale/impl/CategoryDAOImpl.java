package com.sds.emp.services.sale.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.sale.CategoryDAO;
import com.sds.emp.services.sale.vo.CategoryVO;
import com.sds.emp.view.paging.Page;

@Repository("categoryDAO")
public class CategoryDAOImpl extends SqlSessionDaoSupport implements CategoryDAO{
	public void addCategory(CategoryVO categoryVO) throws Exception {
		System.out.println(categoryVO);
		getSqlSession().insert("Category.addCategory", categoryVO);
	}

	public void updateCategory(CategoryVO categoryVO) throws Exception {
		getSqlSession().update("Category.updateCategory", categoryVO);
	}
	
	public CategoryVO getCategory(String categoryNo) throws Exception {
		return (CategoryVO) getSqlSession().selectOne("Category.getCategory", categoryNo);
	}

	public Page getCategoryList(SearchVO searchVO) throws Exception {
		CategoryVO categoryVO = new CategoryVO();
		
		String searchCondition = searchVO.getSearchCondition();
		if(searchCondition == null)
			searchCondition = "";
		
		String searchKeyword = searchVO.getSearchKeyword();
		if(searchKeyword == null)
			searchKeyword = "";
		
		if("".equals(searchCondition) || "0".equals(searchCondition))
			categoryVO.setCategoryNo("%" + searchKeyword + "%");
		else
			categoryVO.setCategoryName("%" + searchKeyword + "%");
		
		if(searchVO.getSearchUseYn()!= null && !"A".equals(searchVO.getSearchUseYn()))
			categoryVO.setUseYn(searchVO.getSearchUseYn());
		
		RowBounds rowBounds = new RowBounds((searchVO.getPageIndex() * 3) - 3, 3);	
		ArrayList<CategoryVO> categoryList = (ArrayList) getSqlSession().selectList("Category.getCategoryList", categoryVO, rowBounds);
		Integer categoryListCnt = (Integer)getSqlSession().selectOne("Category.getCategoryListCnt", categoryVO);

		Page resultPage = new Page(categoryList, searchVO.getPageIndex(), categoryListCnt, 5, 3);
		return resultPage;
	}
	
	public ArrayList<CategoryVO> getDropDownCategoryList() throws Exception {
		return (ArrayList) getSqlSession().selectList("Category.getDropDownCategoryList", new Object[] {});
	}
}
