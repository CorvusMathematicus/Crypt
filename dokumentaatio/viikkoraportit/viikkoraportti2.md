Tehty:
	Estetty avaimen asettaminen Atbash-salaukselle. Aiemmin avaimen pystyi asettamaan, mutta atbash-salaus ei käytä avainta, joten se ei tehnyt mitään.
	Asetettu Caesar-salaus uudelleen oletussalaukseksi.
	Aloitettu Autokey-salauksen toteuttaminen.
		Salaus on käytettävissä, mutta ei välttämättä toimi oikein. Testaus puuttuu.
	Korjattu javadoc-kommentteja yhtenäisemmiksi, taas.
	Vigénere-salauksen testeihin lisätty testi rivinvaihdon (tekstikentän tyhjentäminen) yhteydessä tapahtuvaa avaimen alkuun palauttamista varten.
	Havaittu ongelma käsiteltäessä merkkejä, jotka eivät ole latinalaisen aakkoston pieniä kirjaimia: Ohjelman ei tulisi salata tällaisia merkkejä, vaan laittaa ne viestiin sellaisenaan. Ohjelma kuitenkin käsitteli ne palauttaen yleensä yhtä ja tiettyä merkkiä kaikelle soveltumattomalle.
		Ongelma on korjattu: Ohjelma tulostaa salauksille soveltumattomat merkit sellaisenaan, kuten oli tarkoituskin.
		Tätä varten luotiin kaksi uutta metodia Cipher-luokalle. preEncrypt ja preDecrypt joita kutsutaan encrypt ja decrypt-metodien sijaan. Nämä metodit tarkistavat onko merkki salattava ja ohjaavat sen encrypt tai decrypt-metodille tällöin. Muuten ne palauttavat merkin sellaisenaan.
		encrypt ja decrypt-metodit on muutettu julkisista suojatuiksi ja niiden kutsut on muutettu preEncrypt ja preDecrypt-metodien kutsuiksi.
	Havaittu ongelma tyhjällä avaimella: Ohjelma kaatuu. Ongelmaa ei ole toistaiseksi korjattu.

Edistyminen:
	Autokey-salaus on pääpiirteissään valmis, mutta ei vielä toimi täysin oikein. Autokey-salaus tarvitsee myös testit. Muita osia paranneltu.

Oppiminen:
	Vaikka jokin asia testattaisiin ja havaittaisiin toimivaksi, se ei takaa, että asia toimisi käytännössä, sillä muiden osien virheet voivat yhä vaikuttaa siihen. Uudet preEncrypt ja preDecrypt-metodit estivät alkuun rivinvaihdon välittymisen salauksille, mikä esti Vigènere- ja Autokey-salausten avainten alkuunpalaamisen, vaikka testit osoittivat sen toimivan. Tämä oli seurausta preEncrypt ja preDecrypt-metodien testien puuttumisesta.

Vaikeuksia:
	Tyhjä avain kaataa ohjelman, sillä salaukset eivät atbashia lukuunottamatta toimi ilman avainta. Ratkaisu olisi luultavasti asettaa kaikille salauksille oletusavain ja olla hyväksymättä tyhjää avainta.

Seuraavaksi:
	Autokey-salaus loppuun ja sen testaus
	Cipher-luokan metodien testit
	Aloitetaan OTP-salausta jos ehditään
