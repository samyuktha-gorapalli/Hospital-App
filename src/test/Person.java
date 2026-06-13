package test;

public class Person {
	
	private String name; 
	private int age; 
	private String gender; 
	
	// CONSTRUCTOR 
	public Person(String name, int age, String gender){
		this.name = name; 
		this.age = age; 
		this.gender = gender; 
	}
	
	
	//GETTER METHODS 
	public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

}
