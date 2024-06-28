package it.poliba.cmg.sscentry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QueryResultVisualization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_result_visualization);
        Intent intent = getIntent();
        String queryResult = intent.getStringExtra("queryResult");
        TextView textView = findViewById(R.id.textView2);
        textView.setText(queryResult);
    }
}