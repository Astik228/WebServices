package kg.itacademy.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name="wallet")
@XmlAccessorType(XmlAccessType.FIELD)
public class Wallets {
        private int id;
       private String name;
       private User user;
       private boolean isactive;
     private   LocalDateTime dateCreated;

     public Wallets(){}

    public Wallets(int id, String name, User user, boolean isactive) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.isactive = isactive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}
