package kg.itacademy.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name="orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {
    int id;
    Category category;
    int amount;
    String description;
    User user;
    Wallets wallets;
    boolean is_expense;
    LocalDateTime date_created;

public Orders(){}


    public Orders(int id, Category category, int amount, String description, User user, Wallets wallets, boolean is_expense, LocalDateTime date_created) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.user = user;
        this.wallets = wallets;
        this.is_expense = is_expense;
        this.date_created = date_created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Wallets getWallets() {
        return wallets;
    }

    public void setWallets(Wallets wallets) {
        this.wallets = wallets;
    }

    public boolean isIs_expense() {
        return is_expense;
    }

    public void setIs_expense(boolean is_expense) {
        this.is_expense = is_expense;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }
}
