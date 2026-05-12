package com.littleapp.poke.domain

import com.littleapp.poke.data.PokeRepository
import com.littleapp.poke.domain.model.PokeItemDetails

class GetDetails {

    private val repository = PokeRepository()

    suspend fun fromPokemon(id: Int): PokeItemDetails? {
        return repository.getPokeDetails(id)
    }
}