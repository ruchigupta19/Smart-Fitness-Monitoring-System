/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Order;

import java.util.ArrayList;

/**
 *
 * @author ruchi
 */
public class ChkOutOrder {

    private ArrayList<OrderItem> ChkoutOrderList;

    public ChkOutOrder() {
        this.ChkoutOrderList = new ArrayList<>();
    }

    public ArrayList<OrderItem> getChkoutOrderList() {
        return ChkoutOrderList;
    }

    public void setChkoutOrderList(ArrayList<OrderItem> ChkoutOrderList) {
        this.ChkoutOrderList = ChkoutOrderList;
    }

    public void addOrderItem(OrderItem orderI) {
        ChkoutOrderList.add(orderI);

    }

}
