package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentService;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {
	@Autowired
	private IShipmentService service;
	@GetMapping(value = "/register")
	public String showRegister(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	//save one record
	@PostMapping(value = "/save")
	public String save(@ModelAttribute ShipmentType shipmentType,Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String message = "Your ShipmentType "+id+" has saved successfully..";
		model.addAttribute("shipmentType", new ShipmentType());
		model.addAttribute("message", message);
		return "ShipmentTypeRegister";
	}
	
	//fetch all records
	@GetMapping(value = "/all")
	public String fetchAll(Model model) {
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
	//delete by id
	@GetMapping(value="/delete/{id}")
	public String removeByID(@PathVariable Integer id,Model model) {
		String msg = null;
		if(service.isShipmentTypeExist(id)) {
			service.deleteShipmentType(id);
			msg = "ShipmentType '"+id+"' is removed successfully !!";
		}else {
			msg = "ShipmentType with this '"+id+"' is not exist..";
		}
		//showing the other rows
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		model.addAttribute("message", msg);
		return "ShipmentTypeData";
		/**
		 * redirect mechanism
		*return "redirect:../all";
		*/
	}
	
	//edit operation
	@GetMapping(value = "/edit/{id}")
	public String editShipmentType(@PathVariable Integer id,Model model) {
		String page = null;
		boolean flag = service.isShipmentTypeExist(id);
		if(flag) {
			ShipmentType shipmentType = service.getByShipmentType(id);
			model.addAttribute("shipmentType", shipmentType);
			page = "ShipmentTypeEdit";
		}else {
			page = "redirect:../all";
		}
		return page;
	}
	
	//update operation
	@PostMapping("/update")
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
		service.saveShipmentType(shipmentType);
		model.addAttribute("message", "ShipmentType with '"+shipmentType.getId()+"' is updated successfully ..");
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
}
