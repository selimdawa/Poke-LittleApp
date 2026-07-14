package com.littleapp.poke.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.littleapp.poke.data.database.entities.PokeDetailEntity
import com.littleapp.poke.data.database.entities.PokeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokeDao {

    @Query("SELECT * FROM pokemon_table ORDER BY id ASC")
    fun getAllPokemons(): Flow<List<PokeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokeEntity>)

    @Query("DELETE FROM pokemon_table")
    suspend fun clearTable()

    // Details
    @Query("SELECT * FROM pokemon_detail_table WHERE id_int = :id")
    suspend fun getPokemonDetails(id: Int): PokeDetailEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetail(pokemon: PokeDetailEntity)
}
