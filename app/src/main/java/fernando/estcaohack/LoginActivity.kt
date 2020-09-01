package fernando.estcaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Executando o clique do botao entrar
        btnLoginEntrar.setOnClickListener {

            //capturar dados digitados pelo usuario
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = edtLoginSenha.text.toString().trim()

            //validacao dos campos
            if (email.isEmpty()){
                edtLoginEmail.error = "Campo Obrigatorio"
                edtLoginEmail.requestFocus()
            }else if (senha.isEmpty()){
                edtLoginSenha.error = "Campo obrigatorio"
                edtLoginSenha.requestFocus()
            }else{
                //acessando o arquivo de preferencias compartilhadas
                val sheredPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                //recuperando dados no arquivo shared preferences
                val emailPrefs = sheredPrefs.getString("EMAIL", "")
                val senhaPrefs = sheredPrefs.getString("SENHA", "")

                //Verificando email e senha que o usuario colocou
                if(email == emailPrefs && senha == senhaPrefs){
                    Toast.makeText(this, "usuario logado com sucesso", Toast.LENGTH_LONG).show()

                    //abrindo o MainActivity
                    val mIntent = Intent(this, MainActivity::class.java)

                    //Passando informacoes atraves da Intent
                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()
                }else{
                    //Apresentar mensagem de erro
                    Toast.makeText(this,"email ou senha ivalido", Toast.LENGTH_LONG).show()
                }

            }

            /*else{
                //aprensentar uma mensagem de erro ao usuario
                Toast.makeText(this, "email ou senha invalido", Toast.LENGTH_LONG).show()
            }*/
        }

        //executando o clique do botao cadastar
        btnLoginCadastrar.setOnClickListener {

            //abrindo a tela de cadastro
            val mIntent= Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
        }
    }
}