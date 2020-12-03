package edu.cnm.deepdive.cardcombat.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.cardcombat.R;

/**
 * The main activity hosts all of the fragments needed for navigation.
 */
public class NavigationActivity extends AppCompatActivity {


  /**
   * Inflates the xml file and sets the content view.
   * @param savedInstanceState A {@code Bundle}
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_navigation);
  }
}