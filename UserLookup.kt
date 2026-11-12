package fixture

import java.sql.DriverManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserSearchController {

    @GetMapping("/users")
    fun search(@RequestParam("name") name: String): List<String> {
        val connection = DriverManager.getConnection(System.getenv("DB_URL"))
        val statement = connection.createStatement()
        val result = statement.executeQuery("SELECT email FROM users WHERE name = '" + name + "'")

        val emails = mutableListOf<String>()
        while (result.next()) {
            emails.add(result.getString("email"))
        }
        return emails
    }
}
