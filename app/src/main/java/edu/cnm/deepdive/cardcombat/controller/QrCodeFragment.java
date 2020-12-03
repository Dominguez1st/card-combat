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
import edu.cnm.deepdive.cardcombat.databinding.FragmentQrCodeBinding;

/**
 * The qr code fragment is the that will allow the user to scan qr codes using the device's camera.
 */
public class QrCodeFragment extends Fragment {

  private FragmentQrCodeBinding binding;

  public static QrCodeFragment createInstance(/* Parameters to pass to fragment */) {
    QrCodeFragment fragment = new QrCodeFragment();
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
    binding = FragmentQrCodeBinding.inflate(inflater);
    // Access references in binding to set contents of view objects, as appropriate
    binding.navToMainButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(getView()).navigate(R.id.action_qrCodeFragment_to_mainScreenFragment);
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
