package com.oukingtim.util.export.excel;


/**
 * <p></p>
 *
 * @author <a href="mailto:lingyuanbo@foresee.com.cn">lingyuanbo</a>
 * @version $LastChangedRevision: 0 $
 */

public class ExportServicesRecordList extends AbstractReport {

//	表头   
    private String[] tableHeader = {};

    String[] cellsFeildNames = {};
    
	/* (non-Javadoc)
	 * @see com.foresee.export.AbstractReport#getCellNumber()
	 */
	protected short getCellNumber() {
		return (short)tableHeader.length;
	}

	/* (non-Javadoc)
	 * @see com.foresee.export.AbstractReport#getCells()
	 */
	protected String[] getCells() {
		return cellsFeildNames;
	}

	/* (non-Javadoc)
	 * @see com.foresee.export.AbstractReport#getTableHeader()
	 */
	protected String[] getTableHeader() {
		return tableHeader;
	}

    public ExportServicesRecordList withTableHeader(String[] tableHeader) {
        this.tableHeader = tableHeader;

        return this;
    }

    public ExportServicesRecordList withCellsFeildNames(String[] cellsFeildNames) {
        this.cellsFeildNames = cellsFeildNames;

        return this;
    }
}