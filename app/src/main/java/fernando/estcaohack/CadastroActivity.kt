package fernando.estcaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //Criando uma lista de opçoes para spinner
        val listaGenero= arrayListOf("Selecione o gênero", "Feminino", "Masculino", "Outros")

        //Criando um adptador para lista eo spinner
        val generoAdapter = ArrayAdapter(
            this, //contexto
        android.R.layout.simple_spinner_dropdown_item, //layout
            listaGenero //lista que acabamos de criar
        )

        //Lincar o adaptador no Spinner
        spnCadastroGenero.adapter = generoAdapter

        //executando o click do botao cadastrar
        btnCadastrarCadastro.setOnClickListener {

            //Capturar os dados digitados
            val nome = edtCadastroNome.text.toString().trim()
            val sobrenome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim().toLowerCase()
            val senha = edtCadastroSenha.text.toString().trim()
            val genero = spnCadastroGenero.selectedItem.toString()

            //Validacao dos campos
            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty()|| senha.isEmpty() || genero== listaGenero[0]){
                //apresentando uma mensagem de erro ao usuario
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }else{
                //todos os campos forem preenchidos

                //Criando o arquivo de preferencias compartilhadas
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                //Editar o arquivo de preferencias compatilhadas
                val editPrefs = sharedPrefs.edit()

                //Preparando os dados a serem salvos no arquivo
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)

                //Salvando os dados no arquivo Shared Preferences
                editPrefs.apply()

                //Abrindo a MainActivity
                val mIntet = Intent(this, MainActivity::class.java)

                //Passando informacoes atraves da Intent
                mIntet.putExtra("INTENT_EMAIL", email)
                startActivity(mIntet)

                //Tirando todas as telas do empilhamento
                finishAffinity()
            }

            //Atribuiçao da condicional para verificar se o spinner foi selecionado

        }
    }
}