package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.model.OrderMethod;
import in.nit.repo.OrderMethodRepository;
import in.nit.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	private OrderMethodRepository repo;

	@Autowired
	public OrderMethodServiceImpl(OrderMethodRepository repo) {
		this.repo = repo;
	}

	// save
	@Transactional
	public Integer saveOrderMethod(OrderMethod om) {
		Integer id = repo.save(om).getId();
		return id;
	}

	// update
	@Transactional
	public void updateOrderMethod(OrderMethod om) {
		repo.save(om);
	}

	// delete by id
	@Transactional
	public void deleteOrderMethodById(Integer id) {
		repo.deleteById(id);
	}

	// get one obj
	@Transactional(readOnly = true)
	public Optional<OrderMethod> findOrderMethodById(Integer id) {
		Optional<OrderMethod> opt = repo.findById(id);
		return opt;
	}

	// get all objs
	@Transactional(readOnly = true)
	public List<OrderMethod> findAllOrderMethod() {
		List<OrderMethod> list = repo.findAll();
		return list;
	}

	// check record exist or not
	@Transactional(readOnly = true)
	public boolean isOrderMethodExist(Integer id) {
		boolean exist = repo.existsById(id);
		return exist;
	}

}
