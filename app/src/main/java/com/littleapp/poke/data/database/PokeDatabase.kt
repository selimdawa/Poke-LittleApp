package com.littleapp.poke.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.littleapp.poke.data.database.dao.PokeDao
import com.littleapp.poke.data.database.entities.PokeDetailEntity
import com.littleapp.poke.data.database.entities.PokeEntity

@Database(entities = [PokeEntity::class, PokeDetailEntity::class], version = 1)
abstract class PokeDatabase : RoomDatabase() {
    abstract fun getPokeDao(): PokeDao
}