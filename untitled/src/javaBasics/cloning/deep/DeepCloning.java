package javaBasics.cloning.deep;

class Address implements Cloneable{
     String city;

    public Address(String city) {
        this.city = city;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable {

     String name;
     Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(this.name,(Address) this.address.clone());//Deep Cloning
    }



}
public class DeepCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person person1 = new Person("John",address);
        Person person2 = (Person) person1.clone();
        System.out.println(person1.getName()+" "+person1.getAddress().city);
        System.out.println(person2.getName()+" "+person2.getAddress().city);
        System.out.println(person1.getAddress().equals(person2.getAddress()));
        person2.getAddress().city = "Los Angeles";
        System.out.println(person1.getName()+" "+person1.getAddress().city);
        System.out.println(person2.getName()+" "+person2.getAddress().city);

    }
}
