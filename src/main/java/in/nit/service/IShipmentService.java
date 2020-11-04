package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentService {
	Integer saveShipmentType(ShipmentType st);
	void updateShipmentType(ShipmentType st);
	void deleteShipmentType(Integer id);
	ShipmentType getByShipmentType(Integer id);
	List<ShipmentType> getAllShipmentType();
	boolean isShipmentTypeExist(Integer id);
}	
