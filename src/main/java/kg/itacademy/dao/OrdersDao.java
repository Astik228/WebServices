package kg.itacademy.dao;

import kg.itacademy.model.Orders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersDao {
    private static  final Map<Integer, Orders> ordersMap=new HashMap<>();

    static {
        initOrder();
    }
    static  void initOrder(){
        Orders order1=new Orders(1, CategoryDao.getCategory(1),1,"Order of toy",
                UserDao.getUser(1), WalletDao.getWallet(1),true, LocalDateTime.now());

        ordersMap.put(order1.getId(),order1);
    }
    public static Orders getOrder(Integer id){
        return ordersMap.get(id);
    }
    public static Orders addOrder(Orders orders){
        ordersMap.put(orders.getId(),orders);
        return orders;
    }
    public static Orders updateOrder(Orders orders){
        ordersMap.put(orders.getId(),orders);
        return orders;
    }
    public static void deleteOrder(Integer id ){
        ordersMap.remove(id);
    }
    public  static List<Orders> getAllOrders(){
        System.out.println("in GetAllOrders");
        return new ArrayList<Orders>(ordersMap.values());
    }


}
