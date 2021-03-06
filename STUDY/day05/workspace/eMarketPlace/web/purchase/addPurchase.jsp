<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sds.emp.common.util.EmpUtil"%>
<%@ page import="com.sds.emp.services.purchase.vo.DeliveryCompanyVO" %>
<%@ page import="com.sds.emp.services.code.vo.CodeVO" %>
<%@ page import="com.sds.emp.common.vo.SearchVO" %>
<%@ page import="com.sds.emp.services.sale.vo.ProductVO"%>

<%
	ProductVO productSearchVO = (ProductVO)request.getAttribute("resultProductSearchVO");
	
	ArrayList<DeliveryCompanyVO> deliveryCompanyList = (ArrayList)request.getAttribute("deliveryCompanyList");
	if (deliveryCompanyList == null) deliveryCompanyList = new ArrayList();
	
	ArrayList paymentOptionList = (ArrayList)request.getAttribute("paymentOptionList");
	if (paymentOptionList == null) paymentOptionList = new ArrayList();
	
%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<title>구매 등록</title>
<link rel="stylesheet" href="/css/admin.css" type="text/css">
<script language="javascript" src="/javascript/calendar.js"></script>
<script language="javascript" src="/javascript/CommonScript.js"></script>
<script language="JavaScript">
<!--
function fncAddPurchase() {
	// Form 유효성 검증
	if(FormValidation(document.detailForm) != false) {		
	    document.detailForm.action='/addPurchase.do';
	    document.detailForm.submit();
	} 
}

function check_receiptYn(checkReceiptYn) {
	if (checkReceiptYn.checked) {
		document.detailForm.receiptYn.value = "Y";
	} else {
		document.detailForm.receiptYn.value = "N";
	}
}

function resizeImgWidth(imgObj, width) {
    var oldWidth = imgObj.width;
    var oldHeight = imgObj.height;
    if (oldWidth > width) {
        var newWidth = width;
        var newHeight = Math.round(oldHeight * newWidth / oldWidth);
        imgObj.wdith = newWidth;
        imgObj.height = newHeight;
    }
}

function resetData() {
	document.detailForm.reset();
}
-->
</script>


</head>

<body bgcolor="#ffffff" text="#000000">
 
<form name="detailForm"  method="post" enctype="multipart/form-data"> 
<input type="hidden" name="sellerId" value="<%=productSearchVO.getSellerId()%>"/>
<!--************************** 컨텐츠 S *****************************-->

<!-- 타이틀 시작 -->
<table width="100%" height="37" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif" width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="93%" class="ct_ttl01">구매 등록</td>
				<td width="20%" align="right">&nbsp;</td>
			</tr>
		</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif" width="12" height="37"></td>
	</tr>
</table>
<!-- 타이틀 끝 -->

<!-- 상품 상세 정보 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:13px;">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">상품번호</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">
						<%= EmpUtil.null2str(productSearchVO.getProdNo()) %>
						<input type="hidden" name="prodNo" value="<%=productSearchVO.getProdNo()%>">
					</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">상품명</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01" colspan="2">
						<%= EmpUtil.null2str(productSearchVO.getProdName()) %>
					</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">상품분류</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">
						<%= EmpUtil.null2str(productSearchVO.getCategoryNo()) %>
					</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">제조일자</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">
						<%= EmpUtil.toDateStr(productSearchVO.getManufactureDay()) %>
					</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">상세정보</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">
						<%= EmpUtil.null2str(productSearchVO.getProdDetail()).replaceAll("\n", "<br>") %> 
					</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">판매수량</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01"> 
					    <%= EmpUtil.null2str(productSearchVO.getSellQuantity()) %>
					</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">판매금액</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">
						<%= EmpUtil.null2str(productSearchVO.getSellAmount()) %>
					</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
				<tr>
					<td width="104" class="ct_write">A/S 가능여부</td>
					<td bgcolor="D6D6D6" width="1"></td>
					<td class="ct_write01">
						<%= "Y".equals( EmpUtil.null2str(productSearchVO.getAsYn()) ) ? "가능" : "불가" %>
					</td>
				</tr>
				<tr>
					<td height="1" colspan="3" bgcolor="D6D6D6"></td>
				</tr>
			</table>
		</td>
			
		<td width="300">
			<div style="width:300px;overflow:hidden">
				<img src="<%= EmpUtil.null2str(productSearchVO.getImageFile()) %>" alt="상품 이미지" border="0" onError="this.width=0;" onLoad="resizeImgWidth(this,250)">
			</div>
		</td>
	</tr> 
</table>

<!-- 등록 테이블시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:13px;">
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
  	    <td width="104" class="ct_write">수령자 <img src="/images/ct_icon_red.gif" width="3" height="3"></td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<input type="text" name="receiverId" class="ct_input_g" style="width:150px; height:19px">
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
  	    <td width="104" class="ct_write">연락처 <img src="/images/ct_icon_red.gif" width="3" height="3"></td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<input type="text" name="receiverPhone" class="ct_input_g" style="width:150px; height:19px">
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>	
	<tr>
	<td width="104" class="ct_write">배송희망일</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<input type="text" name=dlvyExpectDay class="ct_input_g" style="width:100px; height:19px">
			<a href="javascript:show_calendar('document.detailForm.dlvyExpectDay', document.detailForm.dlvyExpectDay.value)" id="iconCalendar"><img src="/images/ct_icon_date.gif" width="16" height="18" border="0"></a>
		</td>
	</tr>	
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
  	    <td width="104" class="ct_write">배송지주소 <img src="/images/ct_icon_red.gif" width="3" height="3"></td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<input type="text" name="dlvyAddr" class="ct_input_g" style="width:150px; height:19px">
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">배송업체 <img src="/images/ct_icon_red.gif" width="3" height="3"></td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<select name="dlvyCompNo" class="ct_input_g" style="width:100px">
			<%  for(int i=0; i < deliveryCompanyList.size(); i++) { 
					DeliveryCompanyVO deliveryCompanyVO = (DeliveryCompanyVO)deliveryCompanyList.get(i);
			%>
				<option value="<%= deliveryCompanyVO.getDlvyCompNo() %>" ><%= deliveryCompanyVO.getDlvyCompName() %></option>
			<% } %>
			</select>
		</td>
	</tr>	
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">배송시 유의사항</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<textarea name="dlvyRequest" cols="50" rows="5"></textarea>
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
  	    <td width="104" class="ct_write">결재방식 </td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<%  for(int i=0; i < paymentOptionList.size(); i++) { 
					CodeVO codeVO = (CodeVO)paymentOptionList.get(i); 
			%>
				<%= codeVO.getCodeName() %><input type="radio" name="paymentOption" value="<%= codeVO.getCode() %>" <%=(i==0)?"checked":""%> %> &nbsp;&nbsp;&nbsp;				
			<% } %>
		
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">영수증 발급여부</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01"> 
			<input type="checkbox" name="checkReceiptYn" checked onChange="check_receiptYn(this)"> 영수증 발급합니다.
			<input type="hidden" name="receiptYn" value="Y">
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
</table>
<!-- 등록테이블 끝 -->

<!-- 기존 목록조회 화면의 검색조건 유지 -->
<%-- 
<input type="hidden" name="searchCondition" value="<%= EmpUtil.null2str(searchVO.getSearchCondition()) %>">
<input type="hidden" name="searchKeyword" value="<%= EmpUtil.null2str(searchVO.getSearchKeyword()) %>">
<input type="hidden" name="pageIndex" value="<%= searchVO.getPageIndex() %>">
--%>
<!-- 버튼 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="margin-top:10px;">
	<tr>
		<td width="53%">
		
		</td>
		<td align="right">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;"><a href="javascript:fncAddPurchase();">등록</a></td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>

					<td width="30"></td>
															
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;"><a href="javascript:resetData();">취소</a></td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 버튼 끝 -->

</form>

</body>
</html>
