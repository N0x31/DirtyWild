package fr.wcs.blablacrade;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText depart = (EditText) findViewById(R.id.editTextDeparture);
        final EditText destination = (EditText) findViewById(R.id.editTextDestination);
        final EditText date = (EditText) findViewById(R.id.editTextDate);
        final Button buttonSearch = (Button) findViewById(R.id.searchButton);


        final Calendar calendrier = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view,int year,int month,int day){
                calendrier.set(Calendar.YEAR, year);
                calendrier.set(Calendar.MONTH, month);
                calendrier.set(Calendar.DAY_OF_MONTH, day);
            }
        };

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this, datePicker,
                        calendrier.get(Calendar.YEAR),
                        calendrier.get(Calendar.MONTH),
                        calendrier.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departString = depart.getText().toString();
                String destinationString = destination.getText().toString();

                if (departString.isEmpty() || destinationString.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast),
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

                else {
                    SearchRequestModel searchRequest = new SearchRequestModel(
                            departString,
                            destinationString,
                            calendrier.getTime());
                    Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                    intent.putExtra("searchRequest", searchRequest);
                    startActivity(intent);
                }
            }
        });
    }

    private void UpdateLabel(EditText date, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        date.setText(sdf.format(myCalendar.getTime()));
    }


}
