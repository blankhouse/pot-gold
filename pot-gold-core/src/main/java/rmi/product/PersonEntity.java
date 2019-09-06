package rmi.product;

import java.io.Serializable;

public class PersonEntity implements Serializable {
    /**
	 * TODO
	 */
	private static final long serialVersionUID = -2206344039170469020L;
	private int id;
    private String name;
    private int age;
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getId() {
        return id;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public int getAge() {
        return age;
    }

}