package com.project.SearchVehicle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	@Autowired
	private VehicleDao vehicleDao;
	
	public List<Vehicle> getAllVehicles(){
		return this.vehicleDao.findAll();
	}
	
	public List<Vehicle> search(String s){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		List<Vehicle> allVehicles = this.vehicleDao.findAll();
		
		for( int i = 0; i<allVehicles.size(); i++) {
			if( allVehicles.get(i).search(s)) {
				vehicles.add( allVehicles.get(i));
			}
		}
		return vehicles;
	}
	
	public List<Vehicle> searchbymarka(String s){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		List<Vehicle> allVehicles = this.vehicleDao.findAll();
		
		for( int i = 0; i<allVehicles.size(); i++) {
			if( allVehicles.get(i).searchbymarka(s)) {
				vehicles.add( allVehicles.get(i));
			}
		}
		return vehicles;
	}
	
	public List<Vehicle> searchbymodel(String s){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		List<Vehicle> allVehicles = this.vehicleDao.findAll();
		
		for( int i = 0; i<allVehicles.size(); i++) {
			if( allVehicles.get(i).searchbymodel(s)) {
				vehicles.add( allVehicles.get(i));
			}
		}
		return vehicles;
	}
	
	public List<Vehicle> searchbysinif(String s){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		List<Vehicle> allVehicles = this.vehicleDao.findAll();
		
		for( int i = 0; i<allVehicles.size(); i++) {
			if( allVehicles.get(i).searchbysinif(s)) {
				vehicles.add( allVehicles.get(i));
			}
		}
		return vehicles;
	}
	/*public Vehicle addVehicle(Vehicle vehicle) {
        return this.vehicleDao.save(vehicle);
    }*/
}