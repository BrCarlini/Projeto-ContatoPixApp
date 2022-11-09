package br.com.brcarlini.contatospix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import br.com.brcarlini.contatospix.dao.ContatosDao
import br.com.brcarlini.contatospix.model.ContatosPixModel
import com.google.android.material.textfield.TextInputEditText

class FormActivity : AppCompatActivity(R.layout.activity_form) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        botaoVoltar()
        botaoSalvar()
    }





    fun botaoSalvar(){
        val botaoSalvar = findViewById<Button>(R.id.buttonSave_form)
        val dao = ContatosDao()

        botaoSalvar.setOnClickListener {
            val novoContato = criarContato()
            dao.adicionar(novoContato)
            finish()
        }
    }

    fun criarContato(): ContatosPixModel{

        val campoNome = findViewById<TextInputEditText>(R.id.nome_form2)
        val nome = campoNome.text.toString()

        val campoInstituicao = findViewById<TextInputEditText>(R.id.instituicao_form2)
        val instituicao = campoInstituicao.text.toString()

        val campoAgencia = findViewById<TextInputEditText>(R.id.agencia_form2)
        val agencia = campoAgencia.text.toString()

        val campoConta = findViewById<TextInputEditText>(R.id.conta_form2)
        val conta = campoConta.text.toString()

        return ContatosPixModel(
            nome = nome,
            instituicao = instituicao,
            agencia = "Agência: $agencia ",
            conta = "Conta: $conta"
        )
    }


    fun botaoVoltar(){
        val botaoVoltar = findViewById<ImageButton>(R.id.button_back)

        botaoVoltar.setOnClickListener {
            navegarParaMain()
        }
    }

    fun navegarParaMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}