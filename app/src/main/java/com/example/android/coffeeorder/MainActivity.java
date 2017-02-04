package com.example.android.coffeeorder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view){
        //Figure out if the user wants the whipped cream
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Figure out if the user wants the chocolate
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        //Find the user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String orderSummary = createOrderSummary(price,hasWhippedCream,hasChocolate,name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method is called when the increment button is clicked
     */
    public void increment(View view) {
        //input checking if the quantity more than 100
        if (quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffee",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked
     */
    public void decrement(View view) {
        //input checking if the quantity less than 1
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order
     *
     * @param addWhippedCream to the coffer?
     * @param addChocolate to the coffee?
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream,boolean addChocolate){
        //price 1 cup of coffee
        int basePrice = 5;

        //Add 1$ if the user wants whipped cream
        if(addWhippedCream){
            basePrice += 1;
        }

        //Add 2$ if the user wants chocolate
        if(addChocolate){
            basePrice += 2;
        }

        //caculate the total order price by multiplying the quantity
        return basePrice * quantity;
    }
    /**
     * This method display the given quantity value on the screen
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method create the Order Summary
     *
     * @param price of the order
     * @param addWhippedCream to the order
     * @param addChocolate to the order
     * @return: text summary
     */
    private String createOrderSummary(int price,boolean addWhippedCream,boolean addChocolate,
                                      String addCustomerName){

        String orderSummary = "Name: " + addCustomerName;
        orderSummary += "\nAdd Whipped cream? "+addWhippedCream;
        orderSummary += "\nAdd Chocolate? "+addChocolate;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nTotal: $"+price;
        orderSummary += "\nThank you!";
        return orderSummary;
    }
}
