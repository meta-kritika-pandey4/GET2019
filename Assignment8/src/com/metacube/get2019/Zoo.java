package com.metacube.get2019;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is the class that manages the zoo
 * @author Kritika
 *
 */
public class Zoo {
	
	static int id = 0;
	static ArrayList<Zone> zoneList = new ArrayList<Zone>(); 
	static ArrayList<Cage> cageList = new ArrayList<Cage>(); 
	static ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	
	/**
	 * It is a main method
	 * @param args unused
	 */
	public static void main(String[] args) {
		boolean isExit = false;
		Zone Z1;
		Scanner sc = new Scanner(System.in);
		try {
			do{
				System.out.println("1-Ädd Zone");
				System.out.println("2-Add Cage");
				System.out.println("3-Add Animal");
				System.out.println("4-Remove Animal");
				System.out.println("5-Show Animal");
				System.out.println("6-Exit");
				System.out.println("-----------------------");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
	    		sc.nextLine();
				switch(choice){
				    case 1:
				    {	
				    	if(zoneList.size() < 3) {
							System.out.println("-----------------------");
				    		System.out.print("Enter Catergory of Zone among Reptile, Mammal and Bird : ");
					    	String category = sc.nextLine();
					    	category.toUpperCase();
					    	System.out.print("Enter Cage Capacity of Zone : ");
					    	int cageCapacity = sc.nextInt();
					    	sc.nextLine();
							System.out.println("-----------------------");
					    	switch(category) { 
					    	
					    	   case "MAMMAL":
					    		   Z1 = createZone("Mammal",cageCapacity);
					    		   zoneList.add(Z1);
					    		   System.out.println("Zone added successfully!!");
					    		   break;
					    	   case "REPTILE":
					    		   Z1 = createZone("Reptile",cageCapacity);
					    		   zoneList.add(Z1);
					    		   System.out.println("Zone added successfully!!");
					    		   break;
					    	   case "BIRD":
					    		   Z1 = createZone("Bird",cageCapacity);
					    		   zoneList.add(Z1);
					    		   System.out.println("Zone added successfully!!");
					    		   break;
					    	}
				    	} else {
				    		System.out.println("Zone Full");
				    	}
				    	break;
				    }
				    
				    case 2:
				    {
				    	if(zoneList.size() == 0) {
							System.out.println("-----------------------");
				    		System.out.println("Please Create Zone!!!!");
							System.out.println("-----------------------");
				    	} else {
							System.out.println("-----------------------");
				    		System.out.print("Enter Type of Cage : ");
					    	String cageType =sc.nextLine();
					    	cageType.toUpperCase();
					    	System.out.print("Enter animal Capacity of cage : ");
					    	int animalCapacity =sc.nextInt();
							System.out.println("-----------------------");
					    		if ("LION".equals(cageType)){
					    			String zoneType = Lion.class.getSuperclass().getSimpleName();
					    			insertIntoTheCage(zoneType , animalCapacity , cageType);
						    		System.out.println("Cage added successfully!!");
					    		}
					    		else if ("CROCODILE".equals(cageType)){
					    			String zoneType = Crocodile.class.getSuperclass().getSimpleName();
					    			insertIntoTheCage(zoneType , animalCapacity , cageType);
						    		System.out.println("Cage added successfully!!");
					    		}
					    		else if ("PEACOCK".equals(cageType)){
					    			String zoneType = Peacock.class.getSuperclass().getSimpleName();
					    			insertIntoTheCage(zoneType , animalCapacity , cageType);
						    		System.out.println("Cage added successfully!!");
					    		} else {
					    			System.out.println("-----------------------");
					    			System.out.println("We dont't Have Your Choise");
					    			System.out.println("-----------------------");
					    		}
				    	}
				    	break;
				    }
				    
				    case 3:
				    	if(zoneList.size() == 0){
							System.out.println("-----------------------");
				    		System.out.println("Please Create Zone!!");
							System.out.println("-----------------------");
				    	}
				    	else if(cageList.size() == 0){
							System.out.println("-----------------------");
				    		System.out.println("Please Create Cage!!!");
							System.out.println("-----------------------");
				    	}
				    	else{
							System.out.println("-----------------------");
				    		System.out.print("Enter Type of Animal : ");
					    	String animalType = sc.nextLine();
					    	animalType.toUpperCase();
					    	System.out.print("Enter name of Animal : ");
					    	String animalName = sc.nextLine();
							System.out.println("-----------------------");
					    	for (int i = 0; i < cageList.size(); i++) {
								Cage CageObj = cageList.get(i);
								if (animalType.equals(CageObj.cageType)) {
									if(CageObj.animalCapacity > 0){
										CageObj.animalCapacity = CageObj.animalCapacity-1;
										Animal A1 = addAnimal(id++,animalName,animalType);
										animalList.add(A1);
										System.out.println("-----------------------");
										System.out.println("Animal Added successfully!!!");
										System.out.println("-----------------------");
									} else {
										System.out.println("-----------------------");
										System.out.println("Capacity full");
										System.out.println("-----------------------");
									}
								}
							}
				    	}
				    	break;
				    case 4:
				    	sc.nextLine();
						System.out.println("-----------------------");
				    	System.out.println("Enter name of Animal");
				    	String animalName = sc.nextLine();
						System.out.println("-----------------------");
				    	for (int i = 0; i < animalList.size(); i++) {
							Animal A1 = animalList.get(i);
							if (animalName.equals(A1.name)) {
								animalList.remove(i);
							}
						}
				    	break;
				    	
				    case 5:
				    	sc.nextLine();
						System.out.println("-----------------------");
				    	System.out.println("Enter name of Animal");
				    	String animalName1 =sc.nextLine();
						System.out.println("-----------------------");
				    	for (int i = 0; i < animalList.size(); i++) {
							Animal A1 = animalList.get(i);
							if (animalName1.equals(A1.name)) {
								System.out.println("-----------------------");
								System.out.println("Name of Animal : "+A1.name);
								System.out.println("Id of Animal : "+A1.id);
								System.out.println("Sound Of Animal : "+A1.getSound());
								System.out.println("-----------------------");
							} else {
								System.out.println("-----------------------");
								System.out.println("Animal Not Found");
								System.out.println("-----------------------");
							}
						}
				    	break;
				    case 6:
				    	isExit = true;
						System.out.println("-----------------------");
				    	System.out.println("Thanks For Comming");
						System.out.println("-----------------------");
						break;
					default:
						System.out.println("Invalid input!!!");
				    	
				}
			}while(!isExit);
		}catch (InputMismatchException e) {
			System.out.println("Input mismatch");
		}
		catch(NullPointerException e) {
			System.out.println("Null value inserted.");
		}
		finally{
			sc.close();
		}
	}
		

	/**
	 * It is a method to add cage into the zone.
	 * @param zoneType 
	 * @param animalCapacity
	 * @param cageType
	 */
	private static void insertIntoTheCage(String zoneType, int animalCapacity,String cageType)
	{
		for(int i=0;i<zoneList.size();i++){
			Zone zoneListObj = zoneList.get(i);
			if(zoneType.equals(zoneListObj.category)){
				if(zoneListObj.cageCapacity>0){
					zoneListObj.cageCapacity = zoneListObj.cageCapacity-1;
					Cage c1 = createCage(cageType,animalCapacity);
					cageList.add(c1);
					
				}else{
					System.out.println("Cage Size Full");
				} 
				break;
			} else {
				System.out.println("ZoneType and cageType do not matched!!!");
			}
		}
		
	}


	/**
	 * It is a method to create a zone
	 * @param zoneType
	 * @param cageCapacity
	 * @return zone
	 */
	private static Zone createZone(String zoneType , int cageCapacity) {
			return new Zone(zoneType,cageCapacity);
	}
	
	/**
	 * It is a method create a cage
	 * @param CageType
	 * @param animalCapacity 
	 * @return cage
	 */
	private static Cage createCage(String CageType , int animalCapacity) {
		return new Cage(CageType,animalCapacity);
	}
	
	/**
	 * It is method to create an animal
	 * @param id id of animal.
	 * @param name name of animal
	 * @param type type of animal.
	 * @return
	 */
	private static Animal addAnimal(int id , String name, String type) {
		if ("LION".equals(type)) {
			return new Lion(id, name);
		}
		else if ("CROCODILE".equals(type)) {
			return new Crocodile(id, name);
		}
		else if ("PEACOCK".equals(type)) {
			return new Peacock(id, name);
		} else {
			System.out.println("No Animal Found");
			return null;
		}
	}
	
	

}
