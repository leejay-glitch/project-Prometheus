package com.example.prometheus;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTrainType, spinnerFrom, spinnerTo, spinnerTrainClass, spinnerTime;
    private DatePicker datePicker;
    private Button buttonBookTrain, buttonTicket, buttonAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize spinners
        spinnerTrainType = findViewById(R.id.spinnerTrainType);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        spinnerTrainClass = findViewById(R.id.spinnerTrainClass);
        spinnerTime = findViewById(R.id.spinnerTime);

        // Initialize DatePicker
        datePicker = findViewById(R.id.datePicker);

        // Initialize buttons
        buttonBookTrain = findViewById(R.id.buttonBookTrain);
        buttonTicket = findViewById(R.id.buttonTicket);
        buttonAccount = findViewById(R.id.buttonAccount);

        // Populate spinners with dummy data (you should replace this with actual data)
        ArrayAdapter<CharSequence> trainTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.train_types, android.R.layout.simple_spinner_item);
        trainTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTrainType.setAdapter(trainTypeAdapter);

        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(this,
                R.array.from_locations, android.R.layout.simple_spinner_item);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(fromAdapter);

        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(this,
                R.array.to_locations, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTo.setAdapter(toAdapter);

        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(this,
                R.array.train_classes, android.R.layout.simple_spinner_item);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTrainClass.setAdapter(classAdapter);

        ArrayAdapter<CharSequence> timeAdapter = ArrayAdapter.createFromResource(this,
                R.array.train_times, android.R.layout.simple_spinner_item);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(timeAdapter);

        // Set a click listener for the "Book Train" button
        buttonBookTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code here to handle train booking
                Toast.makeText(MainActivity.this, "Train booked!", Toast.LENGTH_SHORT).show();
            }
        });

        // Set a click listener for the "Ticket" button
        buttonTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code here to navigate to the ticket page
                Toast.makeText(MainActivity.this, "Going to ticket page...", Toast.LENGTH_SHORT).show();
            }
        });

        // Set a click listener for the "Account" button
        buttonAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code here to navigate to the account page
                Toast.makeText(MainActivity.this, "Going to account page...", Toast.LENGTH_SHORT).show();
            }
        });

        // Set a listener for the Train Type spinner to update available times
        spinnerTrainType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the selected train type
                String selectedTrainType = spinnerTrainType.getSelectedItem().toString();

                // Update available times based on the selected train type
                ArrayAdapter<CharSequence> updatedTimeAdapter;

                if (selectedTrainType.equals("Express")) {
                    updatedTimeAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                            R.array.express_train_times, android.R.layout.simple_spinner_item);
                } else if (selectedTrainType.equals("Inter County")) {
                    updatedTimeAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                            R.array.inter_county_train_times, android.R.layout.simple_spinner_item);
                } else {
                    // Default times or error handling if necessary
                    updatedTimeAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                            R.array.default_train_times, android.R.layout.simple_spinner_item);
                }

                updatedTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTime.setAdapter(updatedTimeAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle the case where nothing is selected (if needed)
            }
        });
    }
}
