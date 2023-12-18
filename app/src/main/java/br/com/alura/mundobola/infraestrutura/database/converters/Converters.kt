package br.com.alura.mundobola.infraestrutura.database.converters

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeParseException

class Converters {
    @TypeConverter
    fun deLocalDateTimeParaString(data: LocalDateTime?):String?{
        return data?.toString()
    }
    @TypeConverter
    fun deStringParaLocalDateTime(data:String?):LocalDateTime?{
        return data?.let {
            try {
                LocalDateTime.parse(it)
            }
            catch (e: DateTimeParseException){
                return null
            }
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