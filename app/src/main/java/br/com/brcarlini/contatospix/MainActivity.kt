package br.com.brcarlini.contatospix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.brcarlini.contatospix.adapter.ContatosPixAdapter
import br.com.brcarlini.contatospix.dao.ContatosDao
import br.com.brcarlini.contatospix.model.ContatosPixModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val dao = ContatosDao()
    private val adapter = ContatosPixAdapter(context = this, contatos = dao.exibirTodos())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecycler()
        configurarFab()
    }


    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.exibirTodos())
    }




    // Configura o click do Botão flutuante da Activity Main
    fun configurarFab(){
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            navegarParaForm()
        }
    }


    // Navega para a Activity de Formulario
    fun navegarParaForm(){
        val intent = Intent(this, FormActivity::class.java)
        startActivity(intent)
    }


    // Configura/ Preenche o RecyclerView
    fun configuraRecycler(){
        val reciclerView = findViewById<RecyclerView>(R.id.recyclerMain)
        reciclerView.adapter = adapter
    }





}

