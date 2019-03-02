package kg.itacademy.service;

import kg.itacademy.dao.UserDao;
import kg.itacademy.dao.WalletDao;
import kg.itacademy.model.Wallets;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/wallets")
public class WalletService {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Wallets> getWallets_JSON(@HeaderParam("user-key") String login,
                                         @HeaderParam("password-key") String password){
        if(!UserDao.authorize(login,password)){
            return null;
        }
        System.out.println("Getting Wallets");
        List<Wallets> wallets = getWalletsByUser(login,password);
        return wallets;
    }

    @GET
    @Path("/{walletId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Wallets getWallet(@PathParam("walletId") Integer walletId) {
        return WalletDao.getWallet(walletId);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Wallets addWallet(Wallets wallets) {
        return WalletDao.addWallet(wallets);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Wallets updateWallet(Wallets wallets) {
        return WalletDao.updateWallet(wallets);
    }

    @DELETE
    @Path("/{walletId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteWallet(@PathParam("walletId") Integer walletId) {
        WalletDao.deleteWallet(walletId);
    }
    public List<Wallets> getWalletsByUser(String login, String password){
        if(!UserDao.authorize(login,password)){
            return null;
        }
        List<Wallets>result=new ArrayList<>();
        List<Wallets> categories= WalletDao.getAllWallets();
        for(Wallets wat: categories){
            if(wat.getUser().getName().equals(login)){
                result.add(wat);
            }
        }
        return result;
    }
}

