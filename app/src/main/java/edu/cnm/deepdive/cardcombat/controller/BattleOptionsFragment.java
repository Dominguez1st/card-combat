package edu.cnm.deepdive.cardcombat.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.cardcombat.R;
import edu.cnm.deepdive.cardcombat.databinding.FragmentBattleOptionsBinding;

public class BattleOptionsFragment extends Fragment {

  private FragmentBattleOptionsBinding binding;

  public static BattleOptionsFragment createInstance(/* Parameters to pass to fragment */){
    BattleOptionsFragment fragment = new BattleOptionsFragment();
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

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentBattleOptionsBinding.inflate(inflater);
    // Access references in binding to set contents of view objects, as appropriate
    binding.navToMainButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(getView()).navigate(R.id.from_battle_options_to_main_screen);
      }
    });
    binding.navToBattleButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(getView()).navigate(R.id.action_battleOptionsFragment_to_battleFragment);
      }
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // Get reference to a ViewModel instance, set observers on LiveData.
  }
}
