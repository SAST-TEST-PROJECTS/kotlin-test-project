package fixture

import java.io.File
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
}
