package Client;

public class Client {
    private String id;
    private String name;
    private static int newId = 1001;

    //default
    public Client(){
        this.id = "0000";
        this.name = "John Doe";
    }

    //constructor
    public Client(String name){
        this.name = name;
        this.id = "c" + (newId++);
    }

    //copy
    public Client(Client other){
        this.id = "c" + newId++;
        this.name = name;
    }

    //getters
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    //setters
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    //toString
    public String toString(){
        return "Name: " + name + " ID: " + id;
    }

}
