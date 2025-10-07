package com.example.emilya6
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Long = 0, // ID gerado automaticamente
    val name: String,   // Nome do produto
    val price: Double   // Preço do produto
)
