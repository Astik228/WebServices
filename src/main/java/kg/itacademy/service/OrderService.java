package kg.itacademy.service;

import kg.itacademy.dao.OrdersDao;
import kg.itacademy.dao.UserDao;
import kg.itacademy.model.Orders;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/orders")
public class OrderService {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Orders> getOrders_JSON(@HeaderParam("user-key") String login,
                                       @HeaderParam("password-key") String password){
        if(!UserDao.authorize(login,password)){
            return null;
        }
        System.out.println("Getting orders");
        List<Orders> orders = getOrdersByUser(login,password);
        return orders;
    }

        @GET
        @Path("/{orderId}")
        @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
        public Orders getOrder(@PathParam("orderId") Integer orderId) {
            return OrdersDao.getOrder(orderId);
        }

        @POST
        @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
        public Orders addCategory(Orders category) {
            return OrdersDao.addOrder(category);
        }

        @PUT
        @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
        public Orders updateOrder(Orders category) {
            return OrdersDao.updateOrder(category);
        }

        @DELETE
        @Path("/{orderId}")
        @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
        public void deleteOrder(@PathParam("orderId") Integer orderId) {
            OrdersDao.deleteOrder(orderId);
        }
        public List<Orders> getOrdersByUser(String login, String password){
            if(!UserDao.authorize(login,password)){
                return null;
            }
            List<Orders>result=new ArrayList<>();
            List<Orders> orders= OrdersDao.getAllOrders();
            for(Orders ord: orders){
                if(ord.getUser().getName().equals(login)){
                    result.add(ord);
                }
            }
            return result;


        }
    }
