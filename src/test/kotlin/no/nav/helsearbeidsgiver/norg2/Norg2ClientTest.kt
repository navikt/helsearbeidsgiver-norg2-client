package no.nav.helsearbeidsgiver.norg2

import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Norg2ClientTest {
    private lateinit var norgClient: Norg2Client

    @Test
    fun hentAlleArbeidsfordelinger() {
        runBlocking {
            val respons = Json.encodeToString(lagResponse())
            norgClient = buildClient(respons, HttpStatusCode.OK)
            val arbeidsfordelinger = norgClient.hentAlleArbeidsfordelinger(lagRequest(), "123")
            assertEquals(1, arbeidsfordelinger.size)
            assertEquals("1234", arbeidsfordelinger[0].enhetNr)
        }
    }
}
