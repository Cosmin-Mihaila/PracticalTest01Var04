package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04 extends AppCompatActivity {
    private Button button1, button2;
    private TextView textView;
    private CheckBox checkBox1, checkBox2;
    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        button1  = (Button)findViewById(R.id.button);
        button2 = findViewById(R.id.button4);
        textView = findViewById(R.id.textView);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        checkBox1 = findViewById(R.id.checkBox1);

        checkBox2 = findViewById(R.id.checkBox2);

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondarAcivity.class);
            String nume = editText1.getText().toString();
            intent.putExtra("nume", nume);
            String grupa = editText2.getText().toString();
            intent.putExtra("grupa", grupa);
            startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
        });

        button1.setOnClickListener(v -> {
            String full = "";
            if(checkBox1.isChecked()){
                String firstText = editText1.getText().toString();
                if(firstText.equals("") || firstText == null){
                    Toast.makeText(this, "Eroare la textul 1", Toast.LENGTH_LONG).show();
                }
                else{
                    full = full + firstText;
                }
            }
            if(checkBox2.isChecked()){
                String secondText = editText2.getText().toString();
                if(secondText.equals("") || secondText == null){
                    Toast.makeText(this, "Eroare la textul 2", Toast.LENGTH_LONG).show();
                }
                else{
                    full = full + secondText;
                }
            }
            textView.setText(full);

            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04Service.class);
            intent.putExtra("nume", editText1.getText().toString());
            intent.putExtra("grupa", editText2.getText().toString());
            getApplicationContext().startService(intent);
//                serviceStatus = Constants.SERVICE_STARTED;
        });

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("nume")){
                editText1.setText(savedInstanceState.getString("nume"));
            } else {
                editText1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("grupa")){
                editText2.setText(savedInstanceState.getString("grupa"));
            } else {
                editText2.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("textView")){
                textView.setText(savedInstanceState.getString("textView"));
            } else {
                textView.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("checkbox1")){
                checkBox1.setChecked(Boolean.parseBoolean(savedInstanceState.getString("checkbox1")));
            } else {
                checkBox1.setChecked(false);
            }
            if (savedInstanceState.containsKey("checkbox2")){
                checkBox2.setChecked(Boolean.parseBoolean(savedInstanceState.getString("checkbox2")));
            } else {
                checkBox2.setChecked(false);
            }

        } else {
            editText1.setText(String.valueOf(0));
            editText2.setText(String.valueOf(0));
            textView.setText(String.valueOf(0));
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("nume")){
                editText1.setText(savedInstanceState.getString("nume"));
            } else {
                editText1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("grupa")){
                editText2.setText(savedInstanceState.getString("grupa"));
            } else {
                editText2.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("textView")){
                textView.setText(savedInstanceState.getString("textView"));
            } else {
                textView.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("checkbox1")){
                checkBox1.setChecked(Boolean.parseBoolean(savedInstanceState.getString("checkbox1")));
            } else {
                checkBox1.setChecked(false);
            }
            if (savedInstanceState.containsKey("checkbox2")){
                checkBox2.setChecked(Boolean.parseBoolean(savedInstanceState.getString("checkbox2")));
            } else {
                checkBox2.setChecked(false);
            }

        } else {
            editText1.setText(String.valueOf(0));
            editText2.setText(String.valueOf(0));
            textView.setText(String.valueOf(0));
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
        }
    }

    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("RECEIVER-COSMIN", intent.getStringExtra(Constants.BROADCAST_RECEIVER_EXTRA));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("nume", editText1.getText().toString());
        savedInstanceState.putString("grupa", editText2.getText().toString());
        savedInstanceState.putString("textView", textView.getText().toString());
        savedInstanceState.putString("checkbox1", String.valueOf(checkBox1.isChecked()));
        savedInstanceState.putString("checkbox2", String.valueOf(checkBox2.isChecked()));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}