package edu.cnm.deepdive.cardcombat.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.cardcombat.databinding.FragmentBattleBinding;
import edu.cnm.deepdive.cardcombat.service.GoogleSignInService;

/**
 * The battle option fragment is where the user will play with their deck against the computer's deck.
 */
public class BattleFragment extends Fragment {

  private FragmentBattleBinding binding;

  public static BattleFragment createInstance(/* Parameters to pass to fragment */) {
    BattleFragment fragment = new BattleFragment();
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
    binding = FragmentBattleBinding.inflate(inflater);
    // Access references in binding to set contents of view objects, as appropriate
    binding.testName.setText(GoogleSignInService.getInstance().getAccount().getDisplayName());
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // Get reference to a ViewModel instance, set observers on LiveData.
  }

}
