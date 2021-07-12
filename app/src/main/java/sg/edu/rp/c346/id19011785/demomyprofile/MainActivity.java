package sg.edu.rp.c346.id19011785.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editName);
        etGPA = findViewById(R.id.editGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Step 1(a): Get user input from EditText and store it in a variable
        String strName = etName.getText().toString();
        float fgpa = Float.parseFloat(etGPA.getText().toString());

        // Step 1(b): Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 1(c): Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        // Step 1(d): Add key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", fgpa);

        // Step 1(e): Call commit() to save the changes into SharedPreferences
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Step 2(a): Obtain an instance of SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 2(b): Retrieve saved data from SharedPreferences object
        String strName = prefs.getString("name", "");
        float fgpa = prefs.getFloat("gpa", 0);
        String inputGPA = etGPA.getText().toString();
        float gpa1 = 0f; /*Float.parseFloat(etGPA.getText().toString());*/
        if (inputGPA.length() > 0) {
            gpa1 = Float.parseFloat(inputGPA);
        }
        String strGPA = String.valueOf(gpa1);

        // Step 2(c): Update UI element with the value
        etName.setText(strName);
        etGPA.setText(strGPA);
    }
}