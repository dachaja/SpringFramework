<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib uri='/WEB-INF/emp-page.tld' prefix='emp' %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sds.emp.common.util.EmpUtil"%>
<%@ page import="com.sds.emp.services.purchase.vo.DeliveryCompanyVO" %>
<%@ page import="com.sds.emp.common.vo.SearchVO" %>
<%@ page import="com.sds.emp.view.paging.Page"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<title>배송업체 목록 조회</title>
<link rel="stylesheet" href="/css/admin.css" type="text/css">

<%
	Page resultPage = (Page)request.getAttribute("resultPage");
	ArrayList<DeliveryCompanyVO> deliveryCompanyList = (ArrayList)resultPage.getList();
		
	SearchVO searchVO = (SearchVO)request.getAttribute("searchVO");
	String keyword = EmpUtil.null2str(searchVO.getSearchKeyword());
	String condition = EmpUtil.null2str(searchVO.getSearchCondition());
	String useYn = searchVO.getSearchUseYn();
%>

<script language="JavaScript">
<!--
function fncGetDeliveryCompanyList(arg) {
   	document.listForm.action='/getDeliveryCompanyList.do';
   	document.listForm.submit();		
}

function fncGetDeliveryCompany(dlvyCompNo) {
	document.listForm.dlvyCompNo.value = dlvyCompNo;
   	document.listForm.action='/getDeliveryCompany.do';
   	document.listForm.submit();		
}

function fncAddDeliveryCompanyView() {
    document.listForm.action='/addDeliveryCompanyView.do';
    document.listForm.submit();
}
-->
</script>
</head>

<body bgcolor="#ffffff" text="#000000">
<form name="listForm" method="get">
<!-- 타이틀 시작 -->
<table width="100%" height="37" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif" width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">배송업체 목록조회</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif" width="12" height="37"></td>
	</tr>
</table>
<!-- 타이틀 끝 -->

<!-- 검색 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:100px">
				<option value="0" <%= (condition.equals("0") ? "selected" : "")%>>배송업체번호</option>
				<option value="1" <%= (condition.equals("1") ? "selected" : "")%>>배송업체명</option>
			</select>
			<input type="text" name="searchKeyword" value="<%= keyword %>" class="ct_input_g" style="width:150px; height:19px" required fieldTitle="검색어" maxLength="50">
		</td>
		<td align="right">
			사용여부&nbsp;&nbsp;
		</td>
		<td align="left">
			<select name="searchUseYn" class="ct_input_g" style="width:80px">
				<option value="A">전체</option>
				<option value="Y" <%= ("Y".equals(useYn) ? "selected" : "")%>>사용</option>
				<option value="N" <%= ("N".equals(useYn) ? "selected" : "")%>>중지</option>				
			</select>		
		</td>
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetDeliveryCompanyList('1');">검색</a>
					</td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 검색 끝 -->

<!-- 리스트 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td class="ct_list_b" width="50">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">배송업체번호</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="200">배송업체명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">사용여부</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">등록일자</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	<% 
		int no = 0;
		
		for(int i = 0; i < deliveryCompanyList.size(); i++) {
			DeliveryCompanyVO deliveryCompanyVO = (DeliveryCompanyVO)deliveryCompanyList.get(i);
	%>
	<tr class="ct_list_pop">
		<td align="center"><%=++no%></td>
		<td></td>
		<td align="center"><a href="javascript:fncGetDeliveryCompany('<%= deliveryCompanyVO.getDlvyCompNo() %>');"><%= deliveryCompanyVO.getDlvyCompNo() %></a></td>
		<td></td>
		<td align="left"><%= deliveryCompanyVO.getDlvyCompName() %></td>
		<td></td>
		<td align="center" style="padding-right:3px;"><%= "Y".equals(deliveryCompanyVO.getUseYn())? "사용" : "중지" %></td>
		<td></td>
		<td align="center"><%= EmpUtil.toDateStr(deliveryCompanyVO.getRegDate()).substring(0, 10) %></td> 
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>
	<% } %>
</table>
<!-- 선택된 userId 값 -->
<input type="hidden" name="dlvyCompNo" >
<!-- 리스트 끝 -->

<!--  페이지 Navigator 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="margin-top:10px;">
	<tr>
		<td align="center">
             <input type="hidden" name="pageIndex" value="<%=resultPage.getCurrentPage()%>">
             <emp:pagenavigator linkUrl="javascript:fncGetDeliveryCompanyList(2);" 
             	pages="<%=resultPage%>" 
             	formName="listForm"
             	firstImg="${pageContext.request.contextPath}/images/ct_btn_pre.gif"
             	prevImg="${pageContext.request.contextPath}/images/ct_btn_pre01.gif"
             	lastImg="${pageContext.request.contextPath}/images/ct_btn_next.gif" 
	            nextImg="${pageContext.request.contextPath}/images/ct_btn_next01.gif"/>		
    	</td>
	</tr>
</table>
<!-- 페이지 Navigator 끝 -->
<!-- 버튼 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="margin-top:10px;">
	<tr>
		<td align="right">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;"><a href="javascript:fncAddDeliveryCompanyView();">등록요청</a></td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 버튼 끝 -->

</form>
<script language="JavaScript">
document.listForm.searchKeyword.focus();
</script>
</body>
</html>
