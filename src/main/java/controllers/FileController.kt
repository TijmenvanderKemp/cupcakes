package controllers

import repos.SaleRepo
import tornadofx.*
import java.io.File
import kotlin.streams.asSequence

class FileController : Controller() {

    private val saleRepo: SaleRepo by di()

    fun uploadFiles(files: List<File>) {
        if (files.isEmpty()) {
            return
        }
        val file = files[0]
        val earnings = file.bufferedReader().lines()
                .asSequence()
                .mapNotNull(String::toIntOrNull)
                .toList()
        saleRepo.persist(earnings)
    }
}