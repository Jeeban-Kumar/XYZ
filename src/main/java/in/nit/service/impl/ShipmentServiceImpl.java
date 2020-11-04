package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.model.ShipmentType;
import in.nit.repo.ShipmentTypeRepository;
import in.nit.service.IShipmentService;

@Service
public class ShipmentServiceImpl implements IShipmentService {
	@Autowired
	private ShipmentTypeRepository repo;
	
	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
		Integer id = repo.save(st).getId();
		return id;
	}

	@Transactional
	public void updateShipmentType(ShipmentType st) {
		repo.save(st);
	}

	@Transactional
	public void deleteShipmentType(Integer id) {
		repo.deleteById(id);
	}

	@Transactional(readOnly = true)
	public ShipmentType getByShipmentType(Integer id) {
		Optional<ShipmentType> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType> list = repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public boolean isShipmentTypeExist(Integer id) {
		boolean exist = repo.existsById(id);
		return exist;
	}

}
