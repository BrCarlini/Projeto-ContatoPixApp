package br.com.brcarlini.contatospix.dao

import br.com.brcarlini.contatospix.model.ContatosPixModel

class ContatosDao {

    companion object{
        private val contatos = mutableListOf<ContatosPixModel>()
    }


    fun adicionar(contato: ContatosPixModel){
        contatos.add(contato)
    }


    fun exibirTodos(): List<ContatosPixModel>{
        return contatos.toList()
    }

}