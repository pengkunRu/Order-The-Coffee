package com.example.android.coffeeorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view){
        int price = calculatePrice();
        String orderSummary = createOrderSummary(price);
        disPlayMessage(orderSummary);
    }

    /**
     * This method is called when the increment button is clicked
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked
     */
    public void decrement(View view){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order
     *
     * @return total price
     */
    private int calculatePrice(){
        return quantity * 5;
    }
    /**
     * This method display the given quantity value on the screen
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method display the given quantity value on the screen
     */
    private void displayPrice(int number){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(java.text.NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method display the given text on the screen
     */
    private void disPlayMessage(String Message){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(Message);
    }

    /**
     * This method create the Order Summary
     *
     * @param price of the order
     * @return: text summary
     */
    private String createOrderSummary(int price){
        String customerName = "Katherine Kuan";
        String priceMessage = "\nTotal: $"+price;
        priceMessage += "\nThank you!";

        String orderSummary = "Name: " + customerName;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += priceMessage;
        return orderSummary;
    }
}
