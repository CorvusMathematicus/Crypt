Salausluokkia ja niiden algoritmeja on testattu JUnit-testauksella, mutta valtaosa testauksesta on suoritettu käyttämällä ohjelmaa. Myös valtaosa JUnit-testauksen testaamista asioista on testattu käytännössä.
	Ohjelmaa on testattu kaikilla salauksilla, sekä salaus- että purkutilassa syöttämällä avain ja salattava tai purettava teksti ja tarkastelemalla tulostuvaa tekstiä. Normaalisti ohjelmaa on käytetty ensin salaustilassa ja tämän jälkeen saatu tuloste on syötetty ohjelmalle purkutilassa samalla avaimella, jolloin havaitaan, jos salaus ja purkaminen eivät kumoa toisiaan.
	Jos on epäilty ettei algoritmi toimi oikein, tai haluttu varmistaa toimivuus on laskettu käsin, mitä tulostettavien merkkien tulisi olla ja verrattu niitä tulostuneisiin merkkeihin. Tällöin avaimena on useimmiten merkkijono "abc".
	OTP-salauksen salauspuolta ei ole testattu JUnit-testeillä, sillä avain on satunnainen, eikä tulos ole näin ollen etukäteen pääteltävissä. Tämän sijaan ohjelmaa on ajettu salaustilassa ja tarkistettu sen toimiminen halutulla tavalla.
	OTP-salauksesta on JUnit-testauksen sijaan manuaalisesti tarkastettu:
	-Salauksen tulos normaalitilanteessa
	-Salauksen tulos, kun lopputulos on aakkosissa aiempana kuin salattava merkki (esim merkin o salaaminen merkillä z, jolloin lopputuloksena on merkki n)
	-Salaus tuottaa avainta sitä mukaa kun tekstiä kirjoitetaan
	-Avainmerkki z tuottaa tuloksena saman merkin (z:n lukuarvo on 26=0)

Ohjelma toimii ja sitä voi käyttää, tähänastisen käytön perusteella kaikki salausalgoritmit toimivat oikein.
