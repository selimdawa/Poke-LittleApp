package com.littleapp.poke.domain

import com.littleapp.poke.data.PokeRepository
import com.littleapp.poke.domain.model.PokeItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemons @Inject constructor(private val repository: PokeRepository) {

    val pokemonList: Flow<List<PokeItem>> = repository.pokemonListFlow

    suspend fun refresh() {
        repository.fetchAndStorePokemons()
    }
}
