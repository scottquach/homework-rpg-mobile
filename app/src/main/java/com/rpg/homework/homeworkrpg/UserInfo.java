package com.rpg.homework.homeworkrpg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity {
    TextView usernameField;
    TextView bioField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        final Context context = getApplicationContext();

        usernameField = (TextView)findViewById(R.id.usernameText);
        bioField = (TextView)findViewById(R.id.bioText);

        findViewById(R.id.characterCreationRedirect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence username = usernameField.getText();
                CharSequence biography = bioField.getText();

                boolean fieldsFilled = true;
                if (username.toString().equalsIgnoreCase("")) {
                    usernameField.setError("Username cannot be blank");
                    fieldsFilled = false;
                } if (bioField.toString().equalsIgnoreCase("")) {
                    bioField.setError("Bio cannot be blank");
                    fieldsFilled = false;
                } if (!fieldsFilled) {
                    return;
                }

                setPreference(context,"user_name", username.toString());
                setPreference(context,"user_bio", biography.toString());

                startActivity(new Intent(getApplicationContext(), CharacterCreation.class));
            }
        });
    }

    private void setPreference(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPref = context.getSharedPreferences("app_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    private String getPreference(Context context, String preferenceName) {
        SharedPreferences sharedPref = context.getSharedPreferences("app_preferences", MODE_PRIVATE);
        return sharedPref.getString(preferenceName, null);
    }
}
