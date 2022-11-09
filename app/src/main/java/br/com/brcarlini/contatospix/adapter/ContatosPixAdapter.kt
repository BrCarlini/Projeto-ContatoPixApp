package br.com.brcarlini.contatospix.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brcarlini.contatospix.R
import br.com.brcarlini.contatospix.model.ContatosPixModel

class ContatosPixAdapter(
    val context: Context,
    contatos: List<ContatosPixModel>
): RecyclerView.Adapter<ContatosPixAdapter.ViewHolder>() {

    private val contatos = contatos.toMutableList()


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun vincula(contato: ContatosPixModel){

            val campoNome = itemView.findViewById<TextView>(R.id.nome_contato)
            campoNome.text = contato.nome

            val campoInstituicao = itemView.findViewById<TextView>(R.id.nome_instituicao)
            campoInstituicao.text = contato.instituicao

            val campoAgencia = itemView.findViewById<TextView>(R.id.agencia_contato)
            campoAgencia.text = contato.agencia

            val campoConta = itemView.findViewById<TextView>(R.id.conta_contato)
            campoConta.text = contato.conta

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_contato, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contato = contatos[position]
        holder.vincula(contato)
    }


    override fun getItemCount(): Int {
        return contatos.size
    }


    fun atualiza(contatos: List<ContatosPixModel>) {
        this.contatos.clear()
        this.contatos.addAll(contatos)
        notifyDataSetChanged()
    }

}