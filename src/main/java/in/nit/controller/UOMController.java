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

import in.nit.model.UOM;
import in.nit.service.IUOMService;

@Controller
@RequestMapping("/uom")
public class UOMController {
	@Autowired
	private IUOMService service;
	@GetMapping("/uomregister")
	public String showUOMRegister() {
		return "UOMRegister";
	}
	
	@PostMapping("/saveUOM")
	public String saveUOM(@ModelAttribute UOM uom,Model model) {
		String id = service.saveUOM(uom);
		String msg = "UOM is saved at id no : "+id;
		model.addAttribute("msg",msg);
		return "UOMRegister";
	}
	
	@GetMapping("/alluom")
	public String fetchAllUOM(Model model) {
		List<UOM> list = service.getAllUOM();
		model.addAttribute("list",list);
		return "UOM_all_data";
	}
	
	@GetMapping(value="/delete/{uid}")
	public String removeByUID(@PathVariable String uid,Model model) {
		String msg = null;
		if(service.isUOMExist(uid)) {
			service.deleteByIdUOM(uid);
			msg="UOM with '"+uid+"' is deleted successfully !!";
			
		}else {
			msg="UOM with '"+uid+"' is not exist..";
		}
		//show the list
		List<UOM> list = service.getAllUOM();
		model.addAttribute("message", msg);
		model.addAttribute("list", list);
		return "UOM_all_data";
	}
}
