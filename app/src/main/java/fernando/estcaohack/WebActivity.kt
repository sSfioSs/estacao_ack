package fernando.estcaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //habilitando a execução de codigos javascript
        wbvSite.settings.javaScriptEnabled = true

        //carregando um endereco web
        wbvSite.loadUrl("http://br.cellep.com/estacaohack")

        //definindo o webviw como cliente web padrao
        wbvSite.webViewClient = WebViewClient()
    }
}