package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.helper.MyDataBaseHelper;

import java.util.Map;

public class AnalysisFragment extends Fragment {

    private MyDataBaseHelper db;
    private TextView analysisTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_analaysis, container, false);
        analysisTextView = view.findViewById(R.id.analysis_text_view);

        db = new MyDataBaseHelper(getContext());
        showAnalysis();

        return view;
    }

    private void showAnalysis() {
        Map<String, Double> totalPricePerDay = db.getTotalPricePerDay();
        StringBuilder analysisText = new StringBuilder();

        for (Map.Entry<String, Double> entry : totalPricePerDay.entrySet()) {
            analysisText.append("Date: ").append(entry.getKey()).append(" - Total Price: ").append(entry.getValue()).append("\n");
        }

        analysisTextView.setText(analysisText.toString());
    }
}
