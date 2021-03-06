package id.sch.smktelkom_mlg.tugas01.xiirpl5007.aplikasilaundry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etAlamat, etNomor;
    TextView tvHasil;
    Button btOk;
    RadioButton rbCB, rbCK, rbCS;
    CheckBox cbGB, cbCP, cbP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        tvHasil = (TextView) findViewById(R.id.textView);
        btOk = (Button) findViewById(R.id.buttonOK);
        rbCB = (RadioButton) findViewById(R.id.radioButtonCB);
        rbCK = (RadioButton) findViewById(R.id.radioButtonCK);
        rbCS = (RadioButton) findViewById(R.id.radioButtonCS);
        cbGB = (CheckBox) findViewById(R.id.checkBoxGB);
        cbCP = (CheckBox) findViewById(R.id.checkBoxCP);
        cbP = (CheckBox) findViewById(R.id.checkBoxP);

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

        String hasil = null;
        int harga = 0;
        if (rbCB.isChecked()) {
            hasil = rbCB.getText().toString();
            harga = 5000;
        } else if (rbCK.isChecked()) {
            hasil = rbCK.getText().toString();
            harga = 10000;
        } else if (rbCS.isChecked()) {
            hasil = rbCS.getText().toString();
            harga = 15000;
        } else {
            hasil = "Anda belum memilih jenis laundry";
            harga = 0;
        }

        String fasilitas = "";
        int startlen = fasilitas.length();
        int harga2 = 0, harga3 = 0, harga4 = 0;
        if (cbGB.isChecked()) {
            harga2 = 2000;
            fasilitas += cbGB.getText().toString() + ", ";
        }
        if (cbCP.isChecked()) {
            harga3 = 4000;
            fasilitas += cbCP.getText().toString() + ", ";
        }
        if (cbP.isChecked()) {
            harga4 = 6000;
            fasilitas += cbP.getText().toString() + " ";
        }

        int total = harga + harga2 + harga3 + harga4;

        if (isValid()) {
            tvHasil.setText("Nama Anda : " + nama +
                    "\nAlamat : " + alamat +
                    "\nNomor Telepon : " + nomor +
                    "\nJenis Laundry : " + hasil +
                    "\nFasilitas Tambahan : " + fasilitas +
                    "\nTotal Bayar : " + String.valueOf(total));
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
