Tehty:
	Salauksilla on nyt 2 boolean-muuttujaa, jotka kertovat onko avain käyttäjän asetettavissa salatessa ja purkaessa.
		Ohjelma lakkasi toimimasta lisäyksiä tehdessä ja syyn selvittäminen vei varsin pitkään. Useat samaan aikaan tehdyt lisäykset haittasivat syyn selvittämistä.
		Ongelma havaittu:
			Erästä Logic-luokan muuttujaa (keyAvailable)  pyrittiin käyttämään ennen sen alustamista.
		Ongelma korjattu:
			Muuttujalle asetetaan arvo nyt luokan konstruktorissa.
	Saatu OTP-salaus toimimaan halutulla tavalla.
		OTP-salaus generoi salatessa myös avaimensa sen sijaan, että käyttäjä asettaisi sen.
		Salausta purettaessa avain asetetaan, kuten useimmissa muissakin salauksissa.
		Satunnaislukuja generoidaan tällä hetkellä Javan SecureRandom-luokalla.
	Uusi .jar-tiedosto.

Edistyminen:
	Rikottu ohjelma ja saatu se taas toimimaan.
	Avaimen muuttaminen voidaan poistaa salaukselta käytöstä. Tämä ei edellyttänyt muutoksia aiempiin salauksiin, vaan ainoastaan lisätään, jos käyttäjä ei saa muuttaa tai asettaa avainta.
	OTP-salaus vaikuttaa toimivan, avaimen generointi mukaan lukien.
		Nykyinen menetelmä on hyvin raskas, mutta riittävän nopea, ettei se näy ohjelman nykyisessä käyttötavassa. Optimaalisempi ratkaisu edellyttäisi taulukon korvaamista, esimerkiksi taulukkolistalla.
	Luotu uusi .jar-tiedosto (ei vielä lopullinen, mutta edellinen .jar oli edellisen projektin ajalta).

Oppiminen:
	Kertausta taas siitä, ettei liian montaa asiaa pitäisi muuttaa yhdellä kertaa. Kun jotain menee pieleen, on vaikea havaita ongelman syytä, sillä ohjelma kaatui heti suorituksen alussa. Javan "BUILD SUCCESSFUL" -teksti hämmensi tätä selvittäessä entisestään.

Vaikeuksia:
	Ohjelma lakkasi toimimasta pitkäksi aikaa, ilman mitään selkeää kääntämisvaiheen ongelmaa. Tämä saatiin lopulta korjattua. Nyt kaikki tuntuu taas sujuvan. Projekti on lähes valmis.

Seuraavaksi:
	Vaadittavat dokumentit
	OTP:n testit
