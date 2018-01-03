package com.oukingtim.util.export.excel;

import java.util.ArrayList;
import java.util.List;


/**
 * <p></p>
 *
 * @author <a href="mailto:lingyuanbo@foresee.com.cn">lingyuanbo</a>
 * @version $LastChangedRevision: 0 $
 */

public class HeaderImpl {

	/**
	 * header
	 */
	private ReportHeader header = null;
	
	/**
	 * headerImpl
	 */
	private static HeaderImpl headerImpl=new HeaderImpl();
	

	/**
	 * 私有类
	 * <p></p>
	 */
	private HeaderImpl(){
		
	}
	
	/**
	 * 获取类的实例
	 * <p>@return</p>
	 */
	public static HeaderImpl getInstance(){
		return headerImpl;
	}
	


	public List getRecordListReportHeader(String[] content) {
		List recordListReportHeaderList = new ArrayList();
		StringBuffer headerTitle = new StringBuffer();
		for (int i = 0; null != content && i < content.length; i++) {
			headerTitle.append(content[i]);
			header = new ReportHeader(headerTitle.toString(), headerTitle
					.toString(), 20000);
		}
		recordListReportHeaderList.add(header);
		return recordListReportHeaderList;

	}
}