package com.example.kotlinpoi.poi.entity

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

private val COLUMNS = arrayOf<String>( "Id", "Author", "Name", "Release Date", "Number of Pages", "Description")
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

    val headerRow = sheet.createRow(0)
    COLUMNS.indices.forEach { index ->
        val cell =headerRow.createCell(index)
        cell.setCellValue(COLUMNS[index])
        cell.cellStyle = headerCellStyle
    }

    val releaseDateStyle = workbook.createCellStyle()
    releaseDateStyle.setDataFormat(create.createDataFormat().getFormat("yyyy-MM-dd"))

    var rows = 1
    books.forEach{ book ->
        val row = sheet.createRow(rows++)
        row.createCell(0).setCellValue(book.id.toString())
        row.createCell(1).setCellValue(book.author)
        row.createCell(2).setCellValue(book.name)
        val releaseDateRow = row.createCell(3)
        releaseDateRow.cellStyle = releaseDateStyle
        releaseDateRow.setCellValue(book.releaseDate)
        row.createCell(4).setCellValue(book.numerOfPages.toString())
        row.createCell(5).setCellValue(book.description)
    }

    val file = FileOutputStream("books.xlsx")
    workbook.write(file)
    file.close()
    workbook.close()
}