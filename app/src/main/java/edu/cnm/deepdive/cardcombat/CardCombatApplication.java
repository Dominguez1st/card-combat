package edu.cnm.deepdive.cardcombat;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class CardCombatApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
