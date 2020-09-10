package com.project.SearchVehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

	
	@Autowired
    VehicleService vehicleService;
	
	@GetMapping(value = "/")
	public static String hello(){
		return "Butun araclari goruntulemek icin \"localhost:8080/all\". "
				+ "Butun araclarda arama yapmak icin \"localhost:8080/search\". "
				+ "Modele gore arama yapmak icin \"localhost:8080/searchbymodel\"."
				+ "Markaya gore arama yapmak icin \"localhost:8080/marka\". "
				+ "Sinifa gore arama yapmak icin \"localhost:8080/sinif\".";
	}
	
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
    
    @RequestMapping( method = RequestMethod.POST,value = "/search")
    public List<Vehicle> search( @RequestBody String s) {
        return vehicleService.search(s);
    }
    
    @RequestMapping( method = RequestMethod.POST,value = "/searchbymarka")
    public List<Vehicle> searchbymarka( @RequestBody String s) {
        return vehicleService.searchbymarka(s);
    }
    
    @RequestMapping( method = RequestMethod.POST,value = "/searchbymodel")
    public List<Vehicle> searchbymodel( @RequestBody String s) {
        return vehicleService.searchbymodel(s);
    }
    
    @RequestMapping( method = RequestMethod.POST,value = "/searchbysinif")
    public List<Vehicle> searchbysinif( @RequestBody String s) {
        return vehicleService.searchbysinif(s);
    }
    
}