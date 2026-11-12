package fixture

import java.nio.file.Files
import java.nio.file.Paths
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ReportExportController {

    @GetMapping("/report")
    fun report(@RequestParam("name") reportName: String): ByteArray {
        val path = Paths.get("/var/app/reports/" + reportName)
        return Files.readAllBytes(path)
    }
}
