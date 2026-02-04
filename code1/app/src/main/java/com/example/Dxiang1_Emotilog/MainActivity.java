package com.example.Dxiang1_Emotilog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.Dxiang1_Emotilog.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /* Main Activity Handles the fragments and the navigation between them also
    * holds the main arrays used, one with the emotion names and the other
    * with the emotion objects. The button for the daily summary is also here  */
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ArrayList<Emotion> emotions = new ArrayList<Emotion>();
    private String[] emotionsNames = new String[]{"Happy","Sad","Angry","Anxious","Calm","Tired"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //navigation stuff idk, all of this is from the basic views template
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //Summary fragment button
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SummaryFragment().newInstance(emotions,emotionsNames).show(getSupportFragmentManager(), "Summary");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() { //navigation? part of template
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public ArrayList<Emotion> getEmotions() {
        //getter for the emotions array
        return emotions;
    }

    public String[] getEmotionsNames() {
        //getter for the names array
        return emotionsNames;
    }

}