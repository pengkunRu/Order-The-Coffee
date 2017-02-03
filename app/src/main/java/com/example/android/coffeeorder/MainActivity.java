package com.example.android.coffeeorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
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
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        int price = calculatePrice();
        String orderSummary = createOrderSummary(price,hasWhippedCream);
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
     * This method display the given text on the screen
     */
    private void disPlayMessage(String Message){
        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(Message);
    }

    /**
     * This method create the Order Summary
     *
     * @param price of the order
     * @param addWhippedCream to the order
     * @return: text summary
     */
    private String createOrderSummary(int price,boolean addWhippedCream){
        String customerName = "Katherine Kuan";
        String priceMessage = "\nTotal: $"+price;
        priceMessage += "\nThank you!";

        String orderSummary = "Name: " + customerName;
        orderSummary += "\nAdd Whipped cream? "+addWhippedCream;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += priceMessage;
        return orderSummary;
    }
}
