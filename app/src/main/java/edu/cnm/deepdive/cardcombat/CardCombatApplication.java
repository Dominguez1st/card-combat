package edu.cnm.deepdive.cardcombat;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.cardcombat.service.CardCombatDatabase;
import edu.cnm.deepdive.cardcombat.service.GoogleSignInService;
import io.reactivex.schedulers.Schedulers;

public class CardCombatApplication extends Application {

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
