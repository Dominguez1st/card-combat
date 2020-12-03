package edu.cnm.deepdive.cardcombat.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import edu.cnm.deepdive.cardcombat.R;
import edu.cnm.deepdive.cardcombat.databinding.ActivityLoginBinding;
import edu.cnm.deepdive.cardcombat.service.GoogleSignInService;
import edu.cnm.deepdive.cardcombat.service.UserRepository;

/**
 * The launcher activity that allows the user to sign in with Google Sign In.
 */
public class LoginActivity extends AppCompatActivity {

  private static final int LOGIN_REQUEST_CODE = 1000;

  private GoogleSignInService service;
  private ActivityLoginBinding binding;
  private UserRepository userRepository;

  @SuppressLint("CheckResult")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    service = GoogleSignInService.getInstance();
    userRepository = new UserRepository(this);
    //noinspection ResultOfMethodCallIgnored
    service.refresh()
        .subscribe(
            this::updateAndSwitch,
            (throwable) -> {
              binding = ActivityLoginBinding.inflate(getLayoutInflater());
              binding.signIn.setOnClickListener((v) -> service.startSignIn(this, LOGIN_REQUEST_CODE));
              setContentView(binding.getRoot());
            }
        );
  }

  /**
   * Completes signin, if possible.
   *
   * @param requestCode A code that indicates a type of request.
   * @param resultCode  A code that indicates a type of result.
   * @param data        An intent.
   */
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == LOGIN_REQUEST_CODE) {
      service.completeSignIn(data)
          .addOnSuccessListener(this::updateAndSwitch)
          .addOnFailureListener((throwable) ->
              Toast.makeText(this, R.string.login_failure_message, Toast.LENGTH_LONG).show());
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }

  private void updateAndSwitch(GoogleSignInAccount account) {
    //noinspection ResultOfMethodCallIgnored
    userRepository.getOrCreate(account)
        .subscribe(
            (user) -> {
              Intent intent = new Intent(this, NavigationActivity.class)
                  .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
            },
            (throwable) -> {
              // TODO Remove this after development complete.
              Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
              throw new RuntimeException(throwable);
            }
        );
  }

}