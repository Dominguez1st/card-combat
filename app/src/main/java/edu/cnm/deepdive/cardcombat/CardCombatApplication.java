package edu.cnm.deepdive.cardcombat;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.cardcombat.service.CardCombatDatabase;
import edu.cnm.deepdive.cardcombat.service.GoogleSignInService;
import io.reactivex.schedulers.Schedulers;

/**
 * This class serves as the entry point for the ScaleScroller application.
 */
public class CardCombatApplication extends Application {

  /**
   * Initializes {@link CardCombatDatabase} and {@link GoogleSignInService}.
   */
  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    GoogleSignInService.setContext(this);
    CardCombatDatabase.setContext(this);
    CardCombatDatabase.getInstance().getGameDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }

}
