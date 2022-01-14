package co.edu.usbcali.projectmanager.model.utils;

import co.edu.usbcali.projectmanager.model.commons.PageSetting;
import co.edu.usbcali.projectmanager.model.commons.PagedCustom;

public class FcdUtil {

	protected PageSetting buildPageSetting(int numPage, int numReg) {
		PageSetting pageSetting = new PageSetting();
		pageSetting.setNumPage(numPage);
		pageSetting.setNumReg(numReg);
		return pageSetting;
	}

	protected PagedCustom buildPageCustom(int totalPages, int number, boolean first, boolean last) {
		PagedCustom pagedCustom = new PagedCustom();
		pagedCustom.setTotalPages(totalPages);
		pagedCustom.setNumber(number);
		pagedCustom.setFirst(first);
		pagedCustom.setLast(last);
		return pagedCustom;
	}

}
