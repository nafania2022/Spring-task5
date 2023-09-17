package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import web.service.CarService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CarsController {

    CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    public String getCars(ModelMap model, HttpServletRequest request) {
        String count  =request.getParameter("count");
        if (count == null ){
            model.addAttribute("cars", carService.listAllCars());
        }else {
            model.addAttribute("cars", carService.listCar(Integer.parseInt(count)));
        }
        return "car";
    }
}
