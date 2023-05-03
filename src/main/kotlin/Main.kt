import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.cookies.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

suspend fun main() {
    val client = HttpClient(CIO) {
        install(HttpCookies) {}
    }
    val httpResponse: HttpResponse = client.get("https://nutrition.sa.ucsc.edu/shortmenu.aspx?sName=UC+Santa+Cruz+Dining&locationNum=40&locationName=College+Nine%2fJohn+R.+Lewis+Dining+Hall&naFlag=1") {
        cookie(name = "WebInaCartDates", value = "")
        cookie(name = "WebInaCartLocation", value = "40")
        cookie(name = "WebInaCartMeals", value = "")
        cookie(name = "WebInaCartQtys",value = "")
        cookie(name = "WebInaCartRecipes",value = "")

    }
    val stringBody: String = httpResponse.body()
    println(stringBody)
    client.close()
}