package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.model.UOM;
import in.nit.repo.UOMRepository;
import in.nit.service.IUOMService;

@Service
public class UOMServiceImpl implements IUOMService {
	@Autowired
	private UOMRepository repo;
	
	@Transactional
	public String saveUOM(UOM u) {
		String uid = repo.save(u).getUid();
		return uid;
	}

	@Transactional
	public void updateUOM(UOM u) {
		repo.save(u);
	}

	@Transactional
	public void deleteByIdUOM(String uid) {
		repo.deleteById(uid);
	}

	@Transactional(readOnly = true)
	public UOM getUOMById(String uid) {
		Optional<UOM> opt = repo.findById(uid);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Transactional(readOnly = true)
	public List<UOM> getAllUOM() {
		List<UOM> list = repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public boolean isUOMExist(String uid) {
		boolean exist = repo.existsById(uid);
		return exist;
	}
	

}
