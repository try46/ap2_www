/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en11;

/**
 *
 * @author try
 */
public class Item {

    private int item_id;
    private String itemname;
    private int price;
    private int stock;

    public Item(int item_id, String itemname, int price, int stock) {
        this.item_id = item_id;
        this.itemname = itemname;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Item{" + "item_id=" + item_id + ", itemname=" + itemname + ", price=" + price + ", stock=" + stock + '}';
    }

    /**
     * @return the item_id
     */
    public int getItem_id() {
        return item_id;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @return the itemname
     */
    public String getItemname() {
        return itemname;
    }

}
