package sabel.com.tannebaum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edHoehe;
    private Button btnZeichen;
    private TextView tvAusgabe;
    private int hoehe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edHoehe = findViewById(R.id.edHoehe);
        btnZeichen = findViewById(R.id.btnZeichnen);
        tvAusgabe = findViewById(R.id.tvAusgabe);
        tvAusgabe.setMovementMethod(new ScrollingMovementMethod());

        btnZeichen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoehe = Integer.parseInt(edHoehe.getText().toString());
                StringBuilder ausgabe = new StringBuilder();
                hoehe *= 2;
                ausgabe.append("@\n");
                for (int i = 0; i <= hoehe; i++) {
                    if ((i % 2) != 0) {
                        if (i >= 1 && i < hoehe - 1) {
                            ausgabe.append("i");
                        }
                        for (int a = 0; a < i; a++) {
                            ausgabe.append("*");
                        }
                        if (i >= 1 && i < hoehe - 1) {
                            ausgabe.append("i");
                        }
                        ausgabe.append( String.format("%n"));
                    }
                }
                hoehe /= 8;
                for (int i = 0; i <= hoehe; i++) {
                    ausgabe.append("#" + String.format("%n"));
                }
                tvAusgabe.setText(ausgabe);
            }
        });
    }
}
