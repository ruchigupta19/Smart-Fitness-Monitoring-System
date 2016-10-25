/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Order;

import business.Drug.Drug;
import java.util.ArrayList;

/**
 *
 * @author ruchi
 */
public class Order {

    private static int count = 0;
    private int orderNum;
    private ArrayList<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<OrderItem>();
        orderNum = ++count;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }

    public OrderItem addOrderItem(Drug drug, int quantity, String spn, String cn) {
        OrderItem orderItem = new OrderItem();
        orderItemList.add(orderItem);
        orderItem.setDrug(drug);
        orderItem.setQuantity(quantity);
        orderItem.setSalesPersonName(spn);
        orderItem.setCustomerName(cn);
        return orderItem;
    }

    public OrderItem searchOrderItemByProduct(Drug drug) {
        for (OrderItem orderItem : orderItemList) {
            if ((orderItem.getDrug() == drug)) {
                return orderItem;
            }
        }
        return null;
    }
}
