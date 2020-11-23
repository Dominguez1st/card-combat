package edu.cnm.deepdive.cardcombat;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.cardcombat.service.CardCombatDatabase;
import io.reactivex.schedulers.Schedulers;

public class CardCombatApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    CardCombatDatabase.setContext(this);
    CardCombatDatabase.getInstance().getGameDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    GoogleSignService.setContext(this);
  }
}
