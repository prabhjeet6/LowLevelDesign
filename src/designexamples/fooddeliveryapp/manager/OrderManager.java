package designexamples.fooddeliveryapp.manager;

import designexamples.fooddeliveryapp.data.Order;
import designexamples.fooddeliveryapp.data.OrderStatus;
import designexamples.fooddeliveryapp.data.Restaurant;
import designexamples.fooddeliveryapp.data.User;
import designexamples.fooddeliveryapp.exception.FoodDileveryAppException;
import designexamples.fooddeliveryapp.permissions.Permission;
import designexamples.fooddeliveryapp.factory.PermissionFactory;
public class OrderManager {
    private OrderStatus orderStatus;
    private final User user;
    private final int orderId;
    private final Restaurant restaurant;

    public OrderManager(User user, int orderId, OrderStatus orderStatus, Restaurant restaurant) {
        this.user = user;
        this.orderId = orderId;
        this.orderStatus=orderStatus;
        this.restaurant = restaurant;
    }

    public Order getOrder(int orderId){
        //TODO: retrieve order from DB
        return null;
    }

    public void updateOrder() throws FoodDileveryAppException {
        Order order=getOrder(this.orderId);
        Permission permission = PermissionFactory.getUpdateOrderPermission(this.user, order, this.orderStatus);
        validatePermission(permission);
        //

    }
    public void placeOrder() throws FoodDileveryAppException {
        Permission permission = PermissionFactory.getPlaceOrderPermission(this.user, this.restaurant);
        validatePermission(permission);
        //

    }
    private void validatePermission(Permission permission) throws FoodDileveryAppException {
        if (!permission.isPermitted()) {
            throw new FoodDileveryAppException("Order Update Permission not Found");
        }
    }



}
