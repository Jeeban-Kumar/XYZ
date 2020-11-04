package in.nit.service;

import java.util.List;

import in.nit.model.UOM;

public interface IUOMService {
	String saveUOM(UOM u);
	void updateUOM(UOM u);
	void deleteByIdUOM(String uid);
	UOM getUOMById(String uid);
	List<UOM> getAllUOM();
	boolean isUOMExist(String uid);
}
