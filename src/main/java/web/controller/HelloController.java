package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.CarDao;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	private CarDao carDao;

	@Autowired
	public HelloController(CarDao carDao) {
		this.carDao = carDao;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		if (carDao.listAllCars().size() == 0) {
			carDao.add(new Car("BMW", "X7", "Black"));
			carDao.add(new Car("ALFA ROMEO", "Spider", "Read"));
			carDao.add(new Car("BUICK", "VERANO", "Withe"));
			carDao.add(new Car("ASTON MARTIN", "RAPIDE", "Blue"));
			carDao.add(new Car("BENTLEY", "BENTAYGA", "Black"));
		}
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}
	
}