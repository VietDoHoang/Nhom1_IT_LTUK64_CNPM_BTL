package struct;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Tran Duc Viet & Dinh Duc Lam
 * is a list Device of either Laptop or Phone (use 2 DeviceList, one for Laptop, one for Phone)
 * perform the functions: adding, removing, modifing, searching in List
 */ 
public class DeviceList {
	private List<Device> dvList = new ArrayList<Device>();
	
	public void add(Device newDv) {
		if (dvList.contains(newDv)) {
			int i = dvList.indexOf(newDv);
			dvList.get(i).amount += newDv.amount;
		}
		else dvList.add(newDv);
	}

	public void rm(Device dv) {
		dvList.remove(dv);
	}
	
	public void modify(Device dv, Device dvModified) {
		int indx = dvList.indexOf(dv);
		dvList.remove(dv);
		dvList.add(indx, dvModified);
	}
	
	// Author: Dinh Duc Lam
	public List<Device> searchByBrandAndName(String make, String name, int status) {
		List<Device> searchedList = new ArrayList<>();
		int minDv = status; 
		/*
		 * status = 0 <=> all <=> amount of Device >= 0
		 * status = 1 <=> stocking <=> amount of Device >= 1
		 * => temporary: minDv = status  
		 * */
		for (Device dv : dvList) 
			if (dv.amount >= minDv && dv.name.toUpperCase().contains(name.toUpperCase()) && dv.brand.toUpperCase().contains(make.toUpperCase())) searchedList.add(dv);
		
		return searchedList;
	}
	
}
