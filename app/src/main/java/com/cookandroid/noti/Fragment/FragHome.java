package com.cookandroid.noti.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.noti.GameInfoActivity;
import com.cookandroid.noti.MainActivity;
import com.cookandroid.noti.R;

public class FragHome extends Fragment {
    private View view;
    ImageButton gameButton;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.frag_home,container,false);

        gameButton = view.findViewById(R.id.gameButton);

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GameInfoActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);//경기 정보로
            }
        });
        return view;
    }
}
