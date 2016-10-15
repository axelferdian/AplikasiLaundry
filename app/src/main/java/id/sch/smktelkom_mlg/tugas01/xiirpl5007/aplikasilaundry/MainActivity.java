package id.sch.smktelkom_mlg.tugas01.xiirpl5007.aplikasilaundry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etAlamat, etNomor;
    TextView tvHasil;
    Button btOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        tvHasil = (TextView) findViewById(R.id.textView);
        btOk = (Button) findViewById(R.id.buttonOK);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String nomor = etNomor.getText().toString();

        if (isValid()) {
            tvHasil.setText("Nama Anda : " + nama +
                    "\nAlamat : " + alamat +
                    "\nNomor Telepon : " + nomor);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String namaa = etNama.getText().toString();
        String alamatt = etAlamat.getText().toString();
        String nomorr = etNomor.getText().toString();

        if (namaa.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (alamatt.isEmpty()) {
            etAlamat.setError("Alamat belum diisi");
            valid = false;
        } else if (nomorr.isEmpty()) {
            etNomor.setError("Nomor Telepon belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
            etAlamat.setError(null);
            etNomor.setError(null);
        }

        return valid;
    }
}
