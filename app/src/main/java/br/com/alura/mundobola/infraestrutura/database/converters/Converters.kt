package br.com.alura.mundobola.infraestrutura.database.converters

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.time.LocalDateTime

class Converters {
    @TypeConverter
    fun deLocalDateTimeParaString(data: LocalDateTime?):String?{
        return data?.toString()
    }
    @TypeConverter
    fun deStringParaLocalDateTime(data:String?):LocalDateTime?{
        return data?.let {
            LocalDateTime.parse(it)
        }
    }
    @TypeConverter
    fun deBigDecimalParaDouble(preco: BigDecimal):Double{
        return preco.toPlainString().toDouble()
    }
    @TypeConverter
    fun deDoubleParaBigDecimal(preco: Double):BigDecimal{
        return BigDecimal(preco.toString())
    }
}