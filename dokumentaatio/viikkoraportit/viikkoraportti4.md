Tehty:
	Aloitettu OTP-salauksen toteuttaminen ja lisätty se käyttöliittymän valikkoon.
	Muutettu käyttöliittymä estämään avaimen laittaminen OTP-salauksella salatessa (tietokone generoi itse avaimen).
		Huomioitavaa: Nykyinen ratkaisu on varsin kömpelö. Lienee parempi korvata Logic-luokan suora muuttaminen salaukselle asetettavalla arvolla, joka kertoo, mikäli salaukselle voi asettaa avaimen kummassakin tilassa. Nykyisellään OTP-salauksen salaustila ja Atbash-salaus ovat ainoat, joissa avainta ei aseteta manuaalisesti, mutta laajennettavuuden kannalta olisi parempi, jos tämän voisi määrätä salauskohtaisesti.
	Kommentoitu yllä olevat muutokset. Toistaiseksi OTP-salaukselle asetetaan salatessakin avain manuaalisesti joukkona latinalaisia aakkosia. (Se on siis lähestulkoon täysin sama kuin Vigènere-salaus. Avainta ei vain käytetä uudelleen, vaan viestin kirjoittaminen estyy.

Edistyminen:
	OTP-salauksen pääpiirteet toimivat. Salaus ei kuitenkaan toistaiseksi generoi avainta itse, vaan se syötetään sille. Se on siis lähinnä muutaman rivin muunnoksella toteutettu Vigènere-salaus. OTP-salauksen testit toteutetaan, kun salaus on valmiimpi.

Oppiminen:
	Laajennettavuuden ja selkeyden takaamiseksi luokkiin pitää aikaa myöten lisätä näemmä kasvava määrä ominaisuuksia. Sellaista asiaa kuin valmis luokka ei näemmä ole, aina on jotain muutettavaa.

Vaikeuksia:
	Ei mitään ylitsepääsemätöntä.

Seuraavaksi:
	Vertaisarviointi
	OTP-salauksen valmiiksi saaminen.
	OTP-salauksen avaimen generointi.
		Suunnitteilla oleva OTP-salauksen avaimen generointimenetelmä vaatii käyttöliittymää muuttamaan (tarkkaan ottaen jatkamaan) avainta, ilman sen uudelleen kirjoittamista (helpompi toteuttaa, mutta tehoton ratkaisu). Tämän vaatimista muutoksista on otettava selvää.
		Voisi olla harkittavissa tehdä tämä vaihtoehdoksi kaikille salauksille, esimerkiksi ylimääräisenä nappina, jota painamalla ohjelma tuottaa automaattisesti salaukselle sopivan avaimen.
		OTP-salaus toimii monilta osin lähes samalla tavoin kuin Vigènere, katsotaan voisiko OTP hyödyntää Vignere-luokkaa järkevästi.
	OTP-salauksen testaus
	Salausluokkien muuttaminen siten, että niihin sisältyy tieto siitä, milloin avainta käytetään.
