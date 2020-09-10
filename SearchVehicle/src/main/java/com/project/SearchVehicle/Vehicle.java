package com.project.SearchVehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "MELIKE_VEHICLES")
public class Vehicle{
	//variables
	
	//@Autowired
    //private VehicleService vehicleService;
	
	@Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "marka", nullable = true, length = 50)
	private String marka;
	@Column(name = "model", nullable = true, length = 50)
	private String model;
	@Column(name = "sinif", nullable = true, length = 50)
	private String sinif;
	
	private static int noOfVehicles = 0;
	
	//constructors
	public Vehicle(){
			
		marka = "";
		model = "";
		sinif = "";
	}
	
	public Vehicle (String s) {
		id = noOfVehicles +1;
		noOfVehicles++;
			
		marka = "";
		model = "";
		sinif = "";
		
		int i = 0;
		while( s.charAt(i) != ';' && i < s.length() ) i++;
		marka = s.substring( 0, i);
		i++;
		
		int j = i;
		while( s.charAt(j)!= ';' && j < s.length() ) j++;
		model = s.substring(i,j);
		j++;
		
		sinif = s.substring(j);
		
		//vehicleService.addVehicle(this);
	}
	
	public Vehicle( String marka, String model, String sinif) {
		id = noOfVehicles +1;
		noOfVehicles++;
			
		this.marka = marka;
		this.model = model;
		this.sinif = sinif;
	}
	
	//methods
	public String getMarka() {	return this.marka; }
	
	public String getModel() {	return this.model; }
	
	public String getSinif() {	return this.sinif; }
	 
	public Integer getId() {	return id; }
	
	public void setMarka( String marka) {	this.marka = marka; }
	
	public void setModel( String model) {	this.model = model; }
	
	public void setSinif( String sinif) {	this.sinif = sinif; }
	
	public String print() {
		String s = "Arac no : "+ id +"\nmarka : " + marka +" \nmodel : " + model +" \nsinif : "+sinif+"\n" ;
		return s;
	}
	
	public boolean search(String s) {
		
		int [] prefArr = findPrefArr(s);
		//KMP
		int i = 0, j = 0;
		while( i < marka.length()){
			if( isEqual( marka.charAt(i),s.charAt(j)) ){
				i++;
				j++;
			}
			if( j == s.length()){
				return true;
			}
			else{
				if( i<marka.length() && !isEqual( s.charAt(j),marka.charAt(i))){
					if(j!=0){
						j = prefArr[j-1];
					}
					else{
						i++;
					}
				}
			}
		}

		i = 0;
		j = 0;
		while( i < model.length()){
			if( isEqual( model.charAt(i),s.charAt(j)) ){
				i++;
				j++;
			}
			if( j == s.length()){
				return true;
			}
			else{
				if( i<model.length() && !isEqual( s.charAt(j),model.charAt(i))){
					if(j!=0){
						j = prefArr[j-1];
					}
					else{
						i++;
					}
				}
			}
		}
		
		i = 0;
		j = 0;
		while( i < sinif.length()){
			if( isEqual( sinif.charAt(i),s.charAt(j)) ){
				i++;
				j++;
			}
			if( j == s.length()){
				return true;
			}
			else{
				if( i<sinif.length() && !isEqual( s.charAt(j),sinif.charAt(i))){
					if(j!=0){
						j = prefArr[j-1];
					}
					else{
						i++;
					}
				}
			}
		}
		return false;
	}

	public boolean searchbymodel(String s) {
		
		int [] prefArr = findPrefArr(s);
		//KMP
		int i = 0, j = 0;
		while( i < model.length()){
			if( isEqual( model.charAt(i),s.charAt(j)) ){
				i++;
				j++;
			}
			if( j == s.length()){
				return true;
			}
			else{
				if( i<model.length() && !isEqual( s.charAt(j),model.charAt(i))){
					if(j!=0){
						j = prefArr[j-1];
					}
					else{
						i++;
					}
				}
			}
		}
		return false;
	}

public boolean searchbymarka(String s) {
	
	int [] prefArr = findPrefArr(s);
	//KMP
	int i = 0, j = 0;
	while( i < marka.length()){
		if( isEqual( marka.charAt(i),s.charAt(j)) ){
			i++;
			j++;
		}
		if( j == s.length()){
			return true;
		}
		else{
			if( i<marka.length() && !isEqual( s.charAt(j),marka.charAt(i))){
				if(j!=0){
					j = prefArr[j-1];
				}
				else{
					i++;
				}
			}
		}
	}

	
	return false;
}

	public boolean searchbysinif(String s) {
		
		int [] prefArr = findPrefArr(s);
		//KMP
		int i = 0, j = 0;
		while( i < sinif.length()){
			if( isEqual( sinif.charAt(i),s.charAt(j)) ){
				i++;
				j++;
			}
			if( j == s.length()){
				return true;
			}
			else{
				if( i<sinif.length() && !isEqual( s.charAt(j),sinif.charAt(i))){
					if(j!=0){
						j = prefArr[j-1];
					}
					else{
						i++;
					}
				}
			}
		}
		return false;
	}
	
	private int [] findPrefArr( String s) {
		int [] prefArr = new int[s.length()];
		int length = 0;
		for( int i= 0;i<s.length();i++ ) {
			prefArr[i] = 0;
		}
		for( int i= 1;i<s.length();i++ ){
			if( isEqual(s.charAt(i), s.charAt(length)) ){
				length++;
				prefArr[i] = length;
			}
			else{
				if(length!=0){
					length = prefArr[length-1];
					i--;
				}
			}
		}
		return prefArr;
	}
	
	private boolean isEqual( char c1, char c2) {
		if(c1 >= 'A' && c1 <= 'Z') {
			c1 = (char)(c1 - 'A' + 'a');
		}
		if(c2 >= 'A' && c2 <= 'Z') {
			c2 = (char)(c2 - 'A' + 'a');
		}
		return (c1 == c2);
	}
}