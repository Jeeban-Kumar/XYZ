package in.nit.service;

import java.util.List;
import java.util.Optional;

import in.nit.model.OrderMethod;

public interface IOrderMethodService {
	public Integer saveOrderMethod(OrderMethod om);

	public void updateOrderMethod(OrderMethod om);

	public void deleteOrderMethodById(Integer id);

	public Optional<OrderMethod> findOrderMethodById(Integer id);

	public List<OrderMethod> findAllOrderMethod();

	public boolean isOrderMethodExist(Integer id);
}
