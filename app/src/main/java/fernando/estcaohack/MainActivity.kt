package fernando.estcaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recuperando o email passado por meio da Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        //acessar o arquivo de preferencias compartilhadas (facam sozinhos usem a LoginActivity.kt como base)
        val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

        //recuperar dados no arquivo Shared Prefereces(facam sozinhos)
        val nome = sharedPrefs.getString("NOME", "")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val genero = sharedPrefs.getString("GENERO", "")

        //Exibir os dados recuperados na tela
        txvMainNome.text = "$nome $sobrenome"
        txvMainEmail.text = email
        txvMainGenero.text = genero

        //Executando o botao sair
        btnMainSair.setOnClickListener {
            //criando um alerta
            AlertDialog.Builder(this)
                .setTitle("Atenção!")
                .setMessage("Você realmente deseja sair?")
                .setPositiveButton("Sim"){_,_->
                    //Executando o clique no botao sim
                    val mIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mIntent)
                    finishAffinity()
                }
                .setNeutralButton("Cancelar"){_,_->}
                    //serve para que o usuario nao saia do alerla clicando fora do alerta
                .setCancelable(false)
                .create()
                .show()
        }

        //executem o botão site cellep
        btnMainSite.setOnClickListener {
            val mdt = Intent(this, WebActivity::class.java)
            startActivity(mdt)
        }
    }
}