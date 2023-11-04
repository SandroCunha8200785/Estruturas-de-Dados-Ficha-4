/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ipp.estg.so.ex1;

/**
 *
 * @author sssan
 */
public class Person implements Comparable<Person>{
    
    private String name;
    private int age;
    private double weight;

    public Person() {
        this.age = 0;
        this.name = "";
        this.weight = 0.0;
    }

    public Person(String pName, int pAge, double pWeight) {
        this.name = pName;
        this.age = pAge;
        this.weight = pWeight;
    }
    
    public Person(Person pPerson){
        
        this.name = pPerson.getName();
        this.age = pPerson.getAge();
        this.weight = pPerson.getWeight();
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder("Person ->");
        
        sb.append("\tName: "); sb.append(this.name);
        sb.append("\tAge: "); sb.append(this.age);
        sb.append("\tWeight: "); sb.append(this.weight);
        
        return sb.toString();
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        
        return new Person(this);
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        } 
        
        else if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        else {
            Person otherPerson = (Person) obj;
            
            return (this.name.equalsIgnoreCase(otherPerson.getName()) &&
                    this.age == otherPerson.getAge() &&
                    this.weight == otherPerson.getWeight() );
        }
    }


    @Override
    public int compareTo(Person pPerson) {
        
        if(this.age < pPerson.getAge()) return -1;
        if(this.age > pPerson.getAge()) return 1;
        else return 0;
    }
    
    
    
    
}
