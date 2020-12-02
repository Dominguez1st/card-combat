package edu.cnm.deepdive.cardcombat.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.cardcombat.model.entity.User;
import edu.cnm.deepdive.cardcombat.service.GoogleSignInService;
import edu.cnm.deepdive.cardcombat.service.UserRepository;

/**
 * Serves as the ViewModel for all fragments except the GameFragment.
 */
public class MainViewModel extends AndroidViewModel {

  private final MutableLiveData<User> currentUser;
  private final GoogleSignInService signInService;
  private final UserRepository userRepository;

  /**
   * The constructor initializes repositories, services, and other elements needed by the
   * ViewModel.
   *
   * @param application The CardCombat application.
   */
  public MainViewModel(
      @NonNull Application application) {
    super(application);
    signInService = GoogleSignInService.getInstance();
    userRepository = new UserRepository(application);
    currentUser = new MutableLiveData<>();
    userRepository.getOrCreate(signInService.getAccount())
        .subscribe(
            (user) -> currentUser.postValue(user),
            (throwable) -> {/* TODO Save throwable */}
        );
  }
}
