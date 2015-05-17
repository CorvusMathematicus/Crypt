Ohjelman luokat:
	Main-luokka, josta ohjelman suoritus käynnistetään
		Ei muokattu harjoitustyön aikana
	Logic-luokka, joka toimii ohjelman runkona
		Toteutettu aiemmin, muokattu jossain määrin harjoitustyön aikana
	GUI-luokka, joka sisältää graafisen käyttöliittymän
		Toteutettu aiemmin, lähinnä lisätty uusien salausten käytön vaatimat painikkeet
	KeyInput-luokka, jonka tehtävä on toteuttaa KeyListener rajapinta
		Ei muokattu harjoitustyön aikana
	Abstrakti Cipher-luokka, josta kaikki salaukset periytetään
		Toteutettu aiemmin, muokattu huomattavasti harjoitustyön aikana
	Cipher-luokasta periytetyt salausluokat (joka salauksella on omansa), jotka toteuttavat kukin kaiken omaan salaukseensa liittyvät operaatiot.
		Caesar- ja Vignere-luokat on toteutettu aiemmin ja Vignere-luokkaa on hieman muokattu harjoitustyön aikana

Ohjelman rakenteen kuvaus:
	Logic-luokka toimii ohjelman runkona ja vuorovaikuttaa aktiivisesti graafisen käyttöliittymän GUI-luokan kanssa. (Molemmat luokat tuntevat toisensa)
	Logic-luokka tuntee kaikki salausluokat ja kutsuu aina kullinkin käytössä olevan salausluokan metodeja. Salausluokat ovat olemassa ja Logic-luokan tiedossa, vaikka ne eivät tuolla hetkellä olisikaan käytössä.

Puutteita & parannettavaa:
	Käyttöliittymää voisi huomattavasti parantaa, niin toiminnallisesti kuin koodinkin osalta. Projekti ei kuitenkaan keskittynyt käyttöliittymään, joten sitä ei muutettu enempää kuin oli tarpeen.
	OTP-salaus luo salatessa jokaisella merkillä avaintaulukon uudelleen, mikä on erittäin tehotonta. Ohjelman tehokkuus paranisi selkeästi, jos avain tallennettaisiin johonkin muuhun tietorakenteeseen, esimerkiksi taulukkolistaan. Myös Autokey-salaus sisältää paljon taulukon käsittelyä ja toimisi tehokkaimmin jonolla. Muita salauksia en usko olevan juuri mahdollista optimoida, ainakaan suuresti.
	Ohjelma kaatuu jos käyttäjä syöttää tyhjän avaimen ja yrittää tämän jälkeen käyttää sitä.
	Ohjelmassa on aika paljon pieniä asioita ehkä hieman erikoisissakin paikoissa, jotka yleensä vaikuttavat tuloksen luettavuuteen (avain kirjoitetaan alusstuksessa manuaalisesti, lukijalle a=1 ja ohjelman sisällä a=0 jne.).

Lähteet:
Salausten tiedot: Wikipedia <en.wikipedia.org>, Learn Cryptography <learncryptography.com>
Ohjelmointiapua: StackOverFlow <www.stackoverflow.com>
