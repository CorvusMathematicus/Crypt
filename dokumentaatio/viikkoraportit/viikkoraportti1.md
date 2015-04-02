Tehty:
	Lisätty atbash-salaus (käännetään aakkosten järjestys päinvastaiseksi) ja sen vaatimat testit.
	Lisätty atbash-salaus käyttöliittymään ja korjattu muutamia kirjoitusvirheitä (lähinnä muutettu Vigènere-salauksen oikeaan muotoon, aiemmin ohjelma käytti muotoa Vignere).
	Yhtenäistetty vanhoja JavaDoc-kommentteja.
	Lisätty Cipher-luokkaan metodi merkin muuttamiseksi luvuksi ja toisin päin (ei ascii-arvoksi vaan järjestysluvuksi aloittaen arvolla a=0. Aiemmin tämä toteutettiin vaadituissa algoritmin kohdissa, mutta kopioidun koodin välttämiseksi luotiin operaatioille omat metodit joita kaikki salaukset voivat käyttää.
	Varmistettu vanhojen salausten toimivuus cipher-luokan muunnoksilla.
		Havaittiin ongelma Vigènere-salauksen kanssa: Jos viesti tyhjennetään, salauksessa käytettävä avaimen merkki ei nollaudu, mistä seuraa viestin salautuminen eri tavalla riippuen avaimen vaiheesta viestin alussa. Virhe on korjattu ja sen tarkistus on lisätty testeihin.

Edistyminen:
	Saatu aikaan uusi salaus dokumentteineen ja testeineen. Salaus oli tosin yksinkertainen ja testit sen mukaisia. Dokumentaatiotakin tuli lopulta vain vähän, sillä salaus vain lähinnä yliajaa Cipher-luokan metodeja.

Oppiminen:
	Ohjelman pilkkominen osiin aiemmin kannatti oikeasti. Uusien salausten lisääminen on helppoa, sillä aiemmin tehty pohja toimii yhä ja on (ainakin minulle) ymmärrettävissä.

Vaikeuksia:
	Cipher-luokka on abstrakti, mutta osaa sen metodeista pitäisi silti testata. Tämän voisi ehkä toteuttaa jollain Cipher-luokalta perityn luokan testeissä.

Seuraavaksi:
	Autokey-salaus (miten jatkuvasti muuttuvan avain kannattaa toteuttaa edellyttää vielä pohtimista).
