package com.clockwork53.distancecalculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText originLatitudeBox,originLongitudeBox,
            destinationLatitudeBox,destinationLongitudeBox; //defining edittext instances for inputs
    private Spinner unitTypeSelector;                       //defining spinner for selecting unit types(m,km,mile)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        originLatitudeBox = findViewById(R.id.originLatitude);             //
        originLongitudeBox = findViewById(R.id.originLongitude);           //
        destinationLatitudeBox = findViewById(R.id.destinationLatitude);   //referencing inputs to java variables
        destinationLongitudeBox = findViewById(R.id.destinationLongitude); //
        unitTypeSelector = findViewById(R.id.unitTypeSpinner);             //

        ArrayAdapter<CharSequence> unitTypes = ArrayAdapter.createFromResource(
                this, R.array.unitType,android.R.layout.simple_spinner_item);     //  fills the spinner with values

        unitTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//  sets spinner type to drop down
        unitTypeSelector.setAdapter(unitTypes);

    }

    /**
     *
     * @param view
     *
     * calculates the distance based on inputs when the calculate button is pressed
     */
    public void calculateResult(View view)
    {
        Double OriginLatitude = Double.parseDouble(originLatitudeBox.getText().toString().trim());              //stores origin latitude in a double
        Double OriginLongitude = Double.parseDouble(originLongitudeBox.getText().toString().trim());            //stores origin longitude in a double
        Double DestinationLatitude = Double.parseDouble(destinationLatitudeBox.getText().toString().trim());    //stores destination latitude in a double
        Double DestinationLongitude = Double.parseDouble(destinationLongitudeBox.getText().toString().trim());  //stores destination longitude in a double

        String unitType = unitTypeSelector.getSelectedItem().toString();            // stores selected unit type in a string
        TextView Result = findViewById(R.id.Result);                                //references output to a java variable

        distanceCalc NewDistanceCalc = new distanceCalc();                          //creates a new distanceCalc class instance
        Float Distance = NewDistanceCalc.calculateDistance(OriginLatitude,OriginLongitude,DestinationLatitude,DestinationLongitude);
        //calculates the distance between two coordinates in Meters

        CharSequence temp = "";

        switch (unitType) {
            case "Meters":
                temp = Distance + " Meters";    //builds the output string

                break;
            case "Kilometers":
                Distance /= 1000;                       //converts meters to kilometers

                temp = Distance + " KiloMeters";         //builds the output string

                break;
            case "Miles":
                Distance *= (float) 1609.344;            //converts meters to miles

                temp = Distance + " Miles";               //builds the output string

                break;
        }

        Result.setText(temp);                       //show result in output textbox
    }

}
