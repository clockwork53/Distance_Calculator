package com.clockwork53.distancecalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText originLatitudeBox,originLongitudeBox,
            destinationLatitudeBox,destinationLongitudeBox;
    private Spinner unitTypeSelector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        originLatitudeBox = findViewById(R.id.originLatitude);
        originLongitudeBox = findViewById(R.id.originLongitude);
        destinationLatitudeBox = findViewById(R.id.destinationLatitude);
        destinationLongitudeBox = findViewById(R.id.destinationLongitude);
        unitTypeSelector = findViewById(R.id.unitTypeSpinner);

        ArrayAdapter<CharSequence> unitTypes = ArrayAdapter.createFromResource(this,
                R.array.unitType,android.R.layout.simple_spinner_item);

        unitTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitTypeSelector.setAdapter(unitTypes);

    }

    public void calculateResult(View view)
    {
        Double OriginLatitude = Double.parseDouble(originLatitudeBox.getText().toString().trim());
        Double OriginLongitude = Double.parseDouble(originLongitudeBox.getText().toString().trim());
        Double DestinationLatitude = Double.parseDouble(destinationLatitudeBox.getText().toString().trim());
        Double DestinationLongitude = Double.parseDouble(destinationLongitudeBox.getText().toString().trim());

        String unitType = unitTypeSelector.getSelectedItem().toString();
        TextView Result = findViewById(R.id.Result);

        distanceCalc NewDistanceCalc = new distanceCalc();
        Float Distance = NewDistanceCalc.calculateDistance(OriginLatitude,OriginLongitude,DestinationLatitude,DestinationLongitude);

        CharSequence temp = "";

        if(unitType.equals("Meters")) {
            temp = Distance + " Meters";
        }
        else if(unitType.equals("Kilometers")) {
            Distance /= 1000;
            temp =  Distance+" KiloMeters";
        }
        else if(unitType.equals("Miles")) {
            Distance *= (float)1609.344;
            temp = Distance+" Miles";
        }

        Result.setText(temp);
    }

}
