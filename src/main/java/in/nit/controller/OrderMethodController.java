package in.nit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	private IOrderMethodService service;

	@Autowired
	public OrderMethodController(IOrderMethodService service) {
		this.service = service;
	}

	// 1. registration page
	@GetMapping("/register")
	public String orderMethodRegister(Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	// 2. save order
	@PostMapping("/save")
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod, Model model) {
		Integer id = service.saveOrderMethod(orderMethod);
		String msg = "Oder with '" + id + "' saved successfully ..";
		model.addAttribute("message", msg);
		// clear form
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	// show all data
	@GetMapping("/all")
	public String showAllOrderMethods(Model model) {
		List<OrderMethod> list = service.findAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}

	// 3. edit order
	@GetMapping("/edit/{id}")
	public String editOrderMethod(@PathVariable Integer id, Model model) {
		String page = null;
		Optional<OrderMethod> opt = service.findOrderMethodById(id);
		if (opt.isPresent()) {
			model.addAttribute("orderMethod", opt.get());
			page = "OrderMethodEdit";
		} else {
			page = "redirect:../all";
		}
		return page;
	}

	// 4. update order
	@PostMapping("/update")
	public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod, Model model) {
		service.updateOrderMethod(orderMethod);
		model.addAttribute("message", "Your OrderMethod with '" + orderMethod.getId() + "' is updated successfully.. ");
		List<OrderMethod> list = service.findAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}

	// 5. delete order
	@GetMapping("/delete/{id}")
	public String deleteOrderMethod(@PathVariable Integer id, Model model) {
		String msg = null;
		if (service.isOrderMethodExist(id)) {
			service.deleteOrderMethodById(id);
			msg = "OrderMethod with '" + id + "' is deleted successfully ...";
		} else {
			msg = "OrderMethod with '" + id + "' is not Exist!!!";
		}

		model.addAttribute("message", msg);
		List<OrderMethod> list = service.findAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}

	// 6. view one order
	@GetMapping("/view/{id}")
	public String viewOrderMethod(@PathVariable Integer id, Model model) {
		String page = null;
		Optional<OrderMethod> opt = service.findOrderMethodById(id);
		if (opt.isPresent()) {
			model.addAttribute("ob", opt.get());
			page = "OrderMethodView";
		} else {
			page = "redirect:../all";
		}
		return page;
	}
}
