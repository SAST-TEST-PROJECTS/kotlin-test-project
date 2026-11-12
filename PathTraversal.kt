package fixture

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FileDownloadController {

    @GetMapping("/download")
    fun download(@RequestParam("file") fileName: String): String {
        val file = File("/var/app/uploads/" + fileName)
        return file.readText()
    }

    @GetMapping("/export")
    fun export(): String {
        val reader = BufferedReader(FileReader("/var/app/config/export-target.txt"))
        val target = reader.readLine()
        return File("/var/app/exports/" + target).readText()
    }
}
