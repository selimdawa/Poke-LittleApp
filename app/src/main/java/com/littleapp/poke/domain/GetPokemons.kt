package com.littleapp.poke.domain

import com.littleapp.poke.data.PokeRepository
import com.littleapp.poke.domain.model.PokeItem

class GetPokemons {

    private val repository = PokeRepository()

    suspend fun listAll(): List<PokeItem> {
        return repository.getAllPokemons()
    }
}