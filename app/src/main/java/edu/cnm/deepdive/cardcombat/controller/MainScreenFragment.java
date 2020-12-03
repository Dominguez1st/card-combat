package edu.cnm.deepdive.cardcombat.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.cardcombat.R;
import edu.cnm.deepdive.cardcombat.databinding.FragmentMainScreenBinding;
import edu.cnm.deepdive.cardcombat.service.GoogleSignInService;

/**
 * The main screen fragment is the main navigation hub, and allows the user to go to battle options,
 * qr code, deck editor, or logout.
 */
public class MainScreenFragment extends Fragment {

  private FragmentMainScreenBinding binding;

  private Button playButton;

  public static MainScreenFragment createInstance(/* Parameters to pass to fragment */) {
    MainScreenFragment fragment = new MainScreenFragment();
    Bundle args = new Bundle();
    // Add parameter values to args, using args.put???().
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    // Do whatever is necessary with args.
  }

  /**
   * Initializes display text and navigation.
   *
   * @param inflater A {@code LayoutInflater}.
   * @param container A {@code ViewGroup}.
   * @param savedInstanceState A {@code Bundle}.
   * @return A {@code View}.
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentMainScreenBinding.inflate(inflater);
    // Access references in binding to set contents of view objects, as appropriate
    binding.navToBattleOptionsButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(getView()).navigate(R.id.action_mainScreenFragment_to_battleOptionsFragment);
      }
    });
    binding.navToEditorButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(getView()).navigate(R.id.action_mainScreenFragment_to_deckEditorFragment);
      }
    });
    binding.navToQrButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(getView()).navigate(R.id.action_mainScreenFragment_to_qrCodeFragment);
      }
    });
    binding.signOutButton.setOnClickListener((v) -> GoogleSignInService.getInstance().signOut().addOnCompleteListener((ignore) -> {
      Intent intent = new Intent(getContext(), LoginActivity.class)
          .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
    }));
    binding.testName.setText(GoogleSignInService.getInstance().getAccount().getDisplayName());
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // Get reference to a ViewModel instance, set observers on LiveData.
  }
}
