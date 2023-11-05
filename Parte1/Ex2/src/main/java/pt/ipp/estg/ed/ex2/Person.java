
package pt.ipp.estg.ed.ex2;

/**
 * Classe que representa uma pessoa
 * @author SandroCunha8200785
 */
public class Person implements Comparable<Person>{
    
    private String name;
    private int age;
    private double weight;
    
    /**
     * Construtor vazio
     */
    public Person() {
        this.age = 0;
        this.name = "";
        this.weight = 0.0;
    }
    
    /**
     * Contrutor com atributos
     * @param pName nome
     * @param pAge idade
     * @param pWeight peso
     */
    public Person(String pName, int pAge, double pWeight) {
        this.name = pName;
        this.age = pAge;
        this.weight = pWeight;
    }
    
    /**
     * Construtor copia
     * @param pPerson pessoa a copiar
     */
    public Person(Person pPerson){
        
        this.name = pPerson.getName();
        this.age = pPerson.getAge();
        this.weight = pPerson.getWeight();
        
    }
    
    /**
     * devolve nome
     * @return nome
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @param name novo nome a definir
     */
    public void setName(String name) {
        this.name = name;
    }
     /**
      * 
      * @return idade 
      */
    public int getAge() {
        return age;
    }
    
    /**
     * 
     * @param age idade a definir 
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * 
     * @return peso 
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * 
     * @param weight ñovo peso a definir
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    /**
     * 
     * @return Textualização do objeto 
     */
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder("Person ->");
        
        sb.append("\tName: "); sb.append(this.name);
        sb.append("\tAge: "); sb.append(this.age);
        sb.append("\tWeight: "); sb.append(this.weight);
        
        return sb.toString();
    }
    
    /**
     * 
     * @return deep copy do objeto
     * @throws CloneNotSupportedException 
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        
        return new Person(this);
    }
    
    /**
     * 
     * @param obj pessoa a comparar
     * @return true se tiverem mesmo nome, idade e peso
     */
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

    /**
     * Compara duas pessoas atraves da idade
     * @param pPerson pessoa a comparar
     * @return -1 se mais nova, 1 se for mais velha, 0 da mesma idade
     */
    @Override
    public int compareTo(Person pPerson) {
        
        if(this.age < pPerson.getAge()) return -1;
        if(this.age > pPerson.getAge()) return 1;
        else return 0;
    }
    
    
    
    
}
