package carRental;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> stores, List<User> users) {

        this.storeList = stores;
        this.userList = users;
    }

    public Store getStore(Location location) {
        return storeList.stream()
                .filter(store -> store.getLocation().equals(location))
                .findFirst()
                .orElse(null); // or throw custom StoreNotFoundException
    }


    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    public void addStore(Store store) {
        storeList.add(store);
    }

    public void removeStore(Store store) {
        storeList.remove(store);
    }


}
