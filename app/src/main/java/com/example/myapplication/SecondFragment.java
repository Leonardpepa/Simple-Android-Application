package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Integer count = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
        String javaFormatString = getActivity().getString(R.string.hello_second_fragment);
        String substitutedString = String.format(javaFormatString, count);
        binding.headerTextview.setText(substitutedString);

        binding.textviewSecond.setText(String.valueOf(getRandomNumber(count)));
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public int getRandomNumber(int limit){
        if(limit == 0){
            return 0;
        }
        Random rand = new Random();
        Integer randomInt = rand.nextInt(limit);
        while (randomInt == 0){
            randomInt = rand.nextInt(limit);
        }
        return randomInt;
    }


}