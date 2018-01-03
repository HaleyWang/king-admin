package com.oukingtim.util.export.excel;


/**
 * <p></p>
 *
 * @author <a href="mailto:lingyuanbo@foresee.com.cn">lingyuanbo</a>
 * @version $LastChangedRevision: 0 $
 */

public class ExportServicesRecordList extends AbstractReport {

//	表头   
    private static final String[] tableHeader = {"客服人员名称","客服工号","客户名称","客户号","服务时段","服务时长","评价","应答"};
    
   //表头的单元格个数目   
    private static final short cellNumber = (short)tableHeader.length; 
    
	/* (non-Javadoc)
	 * @see com.foresee.export.AbstractReport#getCellNumber()
	 */
	protected short getCellNumber() {
		return cellNumber;
	}

	/* (non-Javadoc)
	 * @see com.foresee.export.AbstractReport#getCells()
	 */
	protected String[] getCells() {
		String[] cells = new String[]{"serviceName"};
		return cells;
	}

	/* (non-Javadoc)
	 * @see com.foresee.export.AbstractReport#getTableHeader()
	 */
	protected String[] getTableHeader() {
		return tableHeader;
	}

}