package id.sch.smktelkom_mlg.tugas1.xiirpl4014.form_pendaftaran_bimbel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNM, etAL, etNOS, etNOO, etAS, etKL;
    Button bOK;
    TextView tvNM, tvAL, tvNOS, tvNOO, tvAS, tvTS, tvKL, tvJAM, tvHari, tv9;
    RadioGroup rgTingkat;
    RadioButton rbSD, rbSMP, rbSMA, rbSMK;
    CheckBox cbSenin, cbSelasa, cbRabu, cbKamis, cbJumat, cbSabtu;
    Spinner spJM;
    int nHari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNM = (EditText) findViewById(R.id.editTextNM);
        etAL = (EditText) findViewById(R.id.editTextAL);
        etNOS = (EditText) findViewById(R.id.editTextNOS);
        etNOO = (EditText) findViewById(R.id.editTextNOO);
        etAS = (EditText) findViewById(R.id.editTextAS);
        etKL = (EditText) findViewById(R.id.editTextKL);

        rgTingkat = (RadioGroup) findViewById(R.id.radiogroupTS);
        rbSD = (RadioButton) findViewById(R.id.radioButtonSD);
        rbSMP = (RadioButton) findViewById(R.id.radioButtonSMP);
        rbSMA = (RadioButton) findViewById(R.id.radioButtonSMA);
        rbSMK = (RadioButton) findViewById(R.id.radioButtonSMK);

        bOK = (Button) findViewById(R.id.buttonOk);

        tvNM = (TextView) findViewById(R.id.textViewHSnama);
        tvAL = (TextView) findViewById(R.id.textViewHSalamat);
        tvNOS = (TextView) findViewById(R.id.textViewHSnosis);
        tvNOO = (TextView) findViewById(R.id.textViewHSnoortu);
        tvAS = (TextView) findViewById(R.id.textViewHSasal);
        tvTS = (TextView) findViewById(R.id.textViewHStingkat);
        tvKL = (TextView) findViewById(R.id.textViewHSkelas);
        tvJAM = (TextView) findViewById(R.id.textViewHSjam);
        tvHari = (TextView) findViewById(R.id.textViewHShari);
        tv9 = (TextView) findViewById(R.id.textView9);

        cbSenin = (CheckBox) findViewById(R.id.checkBoxSenin);
        cbSelasa = (CheckBox) findViewById(R.id.checkBoxSelasa);
        cbRabu = (CheckBox) findViewById(R.id.checkBoxRabu);
        cbKamis = (CheckBox) findViewById(R.id.checkBoxKamis);
        cbJumat = (CheckBox) findViewById(R.id.checkBoxJumat);
        cbSabtu = (CheckBox) findViewById(R.id.checkBoxSabtu);

        cbSenin.setOnCheckedChangeListener(this);
        cbSelasa.setOnCheckedChangeListener(this);
        cbRabu.setOnCheckedChangeListener(this);
        cbKamis.setOnCheckedChangeListener(this);
        cbJumat.setOnCheckedChangeListener(this);
        cbSabtu.setOnCheckedChangeListener(this);


        spJM = (Spinner) findViewById(R.id.spinnerJM);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNM.getText().toString();
            String alamat = etAL.getText().toString();
            String nosiswa = etNOS.getText().toString();
            String noortu = etNOO.getText().toString();
            String asal = etAS.getText().toString();
            String kelas = etKL.getText().toString();

            tvNM.setText(nama);
            tvAL.setText(alamat);
            tvNOS.setText(nosiswa);
            tvNOO.setText(noortu);
            tvAS.setText(asal);
            tvKL.setText(kelas);

        }
    }

    private boolean isValid() {
        boolean valid = true;
        String hasil = null;

        if (rbSD.isChecked()) {
            hasil = rbSD.getText().toString();
            tvTS.setText("SD");
            valid = true;

        } else if (rbSMP.isChecked()) {

            tvTS.setText("SMP");

        } else if (rbSMA.isChecked()) {

            tvTS.setText("SMA");

        } else if (rbSMK.isChecked()) {

            tvTS.setText("SMK");

        } else {
            tvTS.setText("Anda Belum Memilih Tingkat Sekolah");
        }

        String nama = etNM.getText().toString();
        String alamat = etAL.getText().toString();
        String nosiswa = etNOS.getText().toString();
        String noortu = etNOO.getText().toString();
        String asal = etAS.getText().toString();
        String kelas = etKL.getText().toString();
        if (nama.isEmpty()) {
            etNM.setError("Nama Belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNM.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            tvNM.setText(nama);
        }
        if (alamat.isEmpty()) {
            etAL.setError("Alamat Belum diisi");
            valid = false;
        } else {
            tvAL.setText(alamat);
        }
        if (nosiswa.isEmpty()) {
            etNOS.setError("Nomor Siswa Belum diisi");
            valid = false;
        } else {
            tvNOS.setText(nosiswa);
        }
        if (noortu.isEmpty()) {
            etNOO.setError("Nomor Orangtua Belum diisi");
            valid = false;
        } else {
            tvNOO.setText(noortu);
        }
        if (asal.isEmpty()) {
            etAL.setError("Asal Sekolah Belum diisi");
            valid = false;
        } else {
            tvAS.setText(alamat);
        }
        if (kelas.isEmpty()) {
            etKL.setError("Kelas Belum diisi");
            valid = false;
        } else {
            tvKL.setText(kelas);
        }

        String hari = "";
        int startlen = hari.length();
        if (cbSenin.isChecked()) hari += cbSenin.getText() + ", ";
        if (cbSelasa.isChecked()) hari += cbSelasa.getText() + ", ";
        if (cbRabu.isChecked()) hari += cbRabu.getText() + ", ";
        if (cbKamis.isChecked()) hari += cbKamis.getText() + ", ";
        if (cbJumat.isChecked()) hari += cbJumat.getText() + ", ";
        if (cbSabtu.isChecked()) hari += cbSabtu.getText() + ", ";

        if (hari.length() == startlen) hari += "Anda Belum Memilih Hari";

        tvHari.setText(hari);

        tvJAM.setText(spJM.getSelectedItem().toString());


        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nHari += 1;
        else nHari -= 1;
        tv9.setText("Pilihan Hari Bimbel (" + nHari + " terpilih)");
    }
}
