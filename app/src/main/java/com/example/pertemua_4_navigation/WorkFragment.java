package com.example.pertemua_4_navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import
        com.example.pertemua_4_navigation.databinding.FragmentWorkmanagerBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WorkFragment extends Fragment {
    private FragmentWorkmanagerBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                            @Nullable ViewGroup container, @Nullable Bundle
                                        savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                FragmentWorkmanagerBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        final OneTimeWorkRequest request = new
                OneTimeWorkRequest.Builder(MyWorker.class).build();
        binding.button.setOnClickListener(new
                                                  View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View view) {
                                                          WorkManager.getInstance().enqueueUniqueWork(
                                                                  "Notifikasi", ExistingWorkPolicy.REPLACE,
                                                                  request);
                                                      }
                                                  });
        return view;
    }
}

