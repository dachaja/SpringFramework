package com.sds.emp.services.sale;

import java.util.ArrayList;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.sale.vo.CategoryVO;
import com.sds.emp.view.paging.Page;

public interface CategoryDAO {
	public void addCategory(CategoryVO categoryVO) throws Exception;
	public void updateCategory(CategoryVO categoryVO) throws Exception;
	public CategoryVO getCategory(String categoryNo) throws Exception;
	public Page getCategoryList(SearchVO searchVO) throws Exception;
	public ArrayList<CategoryVO> getDropDownCategoryList() throws Exception;
}
