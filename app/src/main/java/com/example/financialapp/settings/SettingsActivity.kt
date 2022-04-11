package com.example.financialapp.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.financialapp.R
import com.example.financialapp.profile.ProfileActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        title = "Menu Setting"
        val btnsave = findViewById<Button>(R.id.btnsimpan)
        val nama = findViewById<EditText>(R.id.etnamalkp)
        val nim = findViewById<EditText>(R.id.etnim)
        val mail = findViewById<EditText>(R.id.etemail)
        val nope = findViewById<EditText>(R.id.etnohp)
        val pass = findViewById<EditText>(R.id.etpasword)
        val rgjk = findViewById<RadioGroup>(R.id.rgkelamin)
        val spiner = findViewById<Spinner>(R.id.spiner)
        val amcc = findViewById<CheckBox>(R.id.amcc)
        val hmssi = findViewById<CheckBox>(R.id.hmmsi)
        val bem = findViewById<CheckBox>(R.id.bem)
        val togglebtn = findViewById<ToggleButton>(R.id.togglebtn)

        btnsave.setOnClickListener {
            val cekjk = rgjk.checkedRadioButtonId
            val jk = findViewById<RadioButton>(cekjk)

            val org = StringBuilder()
            if(amcc.isChecked){
                org.append("AMCC\n")
            }
            if(hmssi.isChecked){
                org.append("HMSSI\n")
            }
            if(bem.isChecked){
                org.append("BEM AMIKOM")
            }

            val bundle = Bundle()
            bundle.putString("nama",nama.text.toString())
            bundle.putString("nim",nim.text.toString())
            bundle.putString("mail",mail.text.toString())
            bundle.putString("nope",nope.text.toString())
            bundle.putString("jkel","${jk.text}")
            bundle.putString("prodi",spiner.selectedItem.toString())
            bundle.putString("org",org.toString())
            bundle.putString("status",togglebtn.text.toString())

            if(Patterns.EMAIL_ADDRESS.matcher(mail.text.toString()).matches()){
                mail.error = "Masukan email dengan benar"
            }
            else if (pass.length()==0){
                pass.error = "Password Tidak Boleh Kosong"
            }
            else{
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Peringatan..!!!")
                alertDialogBuilder.setMessage("Apakah Data Anda Sudah Benar..?")
                    .setCancelable(false)
                    .setPositiveButton("Yes"){
                        dialogInterface, i ->
                        val intent = Intent(this, ProfileActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this, "Data Profil Berhasil Tersimpan", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No"){
                        dialogInterface, i -> dialogInterface.cancel()
                    }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()

            }
        }


    }
}