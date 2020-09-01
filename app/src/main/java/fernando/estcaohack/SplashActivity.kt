package fernando.estcaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    //É um dos metodos presente no ciclo de vida da activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Abrir a MainActivity após 5 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            //Iniciar uma intent - transmicao da tela splash para a tela main
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 5000)
    }
}