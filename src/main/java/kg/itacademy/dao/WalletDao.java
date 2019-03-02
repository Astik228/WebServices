package kg.itacademy.dao;

import kg.itacademy.model.Wallets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletDao {

        private static final Map<Integer, Wallets> walletMap = new HashMap<>();

        static {
            initWallets();
        }

        private static void initWallets() {
           Wallets wallet1=new Wallets(1,"QIWI", UserDao.getUser(1),true);
           Wallets wallet2=new Wallets(2,"WebMoney", UserDao.getUser(2),true);
           Wallets wallet3=new Wallets(3,"PayPal", UserDao.getUser(3),true);
            walletMap.put(wallet1.getId(), wallet1);
            walletMap.put(wallet2.getId(), wallet2);
            walletMap.put(wallet3.getId(), wallet3);
        }

        public static Wallets getWallet(Integer id) {
            return walletMap.get(id);
        }

        public static Wallets addWallet(Wallets wallet) {
            walletMap.put(wallet.getId(), wallet);
            return wallet;
        }

        public static Wallets updateWallet(Wallets wallet) {
            walletMap.put(wallet.getId(), wallet);
            return wallet;
        }

        public static void deleteWallet(Integer id) {
            walletMap.remove(id);
        }

        public static List<Wallets> getAllWallets() {
//        System.out.println("in GetAllUsers");
//        Collection<User> users = userMap.values();
//        List<User> list = new ArrayList<>();
//        list.addAll(users);
//        System.out.println(list);
//        return list;
            return new ArrayList<Wallets>(walletMap.values());
        }

    }

