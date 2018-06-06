package com.example.kotlinpoi.poi.entity

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.IOException
import java.util.*

private val COLUMNS = arrayOf<String>( "Id", "Author", "Release Date", "Number of Pages", "Description")
private val books = Arrays.asList(
        Book(2518L, "Will Shake", "Rom e Ju", Date(-2197741789000), 254, "Any coincidence is just a coincidence"),
        Book(58412L, "Paul rabbit", "Alu", Date(1320981011000), 10, "Brief what is the book"),
        Book(8105L, "Peter Cabral", "Brazil the discover", Date(-15204397789000), 15, "Brazil a big forest"),
        Book(8158L, "Luiz Leite Oliveira", "Kotlin + poi", Date(1528244651862), 25, "How to use POI on kotlin"))


@Throws(IOException::class)
fun main(args: Array<String>?) {
    val workbook = XSSFWorkbook()
    val create = workbook.creationHelper
    val sheet = workbook.createSheet("Books")
    val headerFont = workbook.createFont()
    headerFont.bold = true
    val headerCellStyle = workbook.createCellStyle()
    headerCellStyle.setFont(headerFont)
}