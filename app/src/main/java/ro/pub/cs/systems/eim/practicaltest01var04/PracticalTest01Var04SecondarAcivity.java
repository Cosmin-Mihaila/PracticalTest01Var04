package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var04SecondarAcivity extends Activity {
    Button okButton, cancelButton;
    TextView textViewNume, textViewGrupa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);
        okButton = findViewById(R.id.button2);
        textViewNume = findViewById(R.id.textViewNume);
        textViewGrupa = findViewById(R.id.textViewGrupa);
        cancelButton = findViewById(R.id.button3);
        okButton.setOnClickListener(v -> {
            setResult(RESULT_OK, null);
            finish();
        });
        cancelButton.setOnClickListener(v -> {
            setResult(RESULT_CANCELED, null);
            finish();
        });

        Intent intent = getIntent();

        if (intent != null && intent.getExtras().containsKey("nume")) {
            String numberOfClicks = intent.getStringExtra("nume");
            textViewNume.setText(numberOfClicks);
        }

        if (intent != null && intent.getExtras().containsKey("grupa")) {
            String numberOfClicks2 = intent.getStringExtra("grupa");
            textViewGrupa.setText(numberOfClicks2);
        }
    }
}
