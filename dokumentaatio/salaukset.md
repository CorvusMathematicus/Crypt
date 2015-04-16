Salaukset:
Huomaa:
Avaimena käyttettävä kirjain on muutettavissa luvuksi ja luku kirjaimeksi (jos se ei ylitä aakkosten pituutta).
Nämä salaukset eivät yleensä sovellu tiedon salaamiseen vakavassa mielessä.
Ohjelma sisältää Caesar- ja Vignere-salaukset.

Kirjaimia vastaavat numerot:
A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26


Caesar:
Caesar-salauksessa teksti salataan korvaamalla jokainen aakkosten kirjain kirjaimella, joka on avainluvun verran edempänä aakkosissa, aloittaen alusta aakkosten loppuessa.
Salaus on varsin heikko ja helppo murtaa, tiheysanalyysillä tai yksinkertaisesti kokeilemalla avaimia, joita on aakkosia vastaava määrä (26, kun ääkkösiä ei käytetä).

Caesar-salauksen avaimena toimii luku.

Esimerkki:
Avain:	3
Salaamaton teksti:	SALATTAVATEKSTI
Salattu teksti:		VDODWWDZDWHNVWL


Atbash:
Atbash-salaus on alunperin heprealaiselle aakkostolle tarkoitettu salaus, jossa aakkosten kukin merkki korvataan vastaavalla merkillä aakkoston lopusta alkaen laskettuna. Salaus ei käytä mitään avainta ja näin ollen sen murtaminen edellyttää vain tietoa (tai arvausta) siitä, että salausta käytetään.

Atbash-salauksessa ei ole avainta.

Esimerkki:
Aakkosten vastaavuudet latinalaisessa aakkostossa:
	ABCDEFGHIJKLMNOPQRSTUVWXYZ
	ZYXWVUTSRQPONMLKJIHGFEDCBA

Salaamaton teksti:	SALATTAVATEKSTI
Salattu teksti:		HZOZGGZEZGVPHGR


Autokey:
Autokey- eli itseavainsalauksessa salattava viesti itse toimii avaimena yhdessä avainsanan kanssa. Salaus tapahtuu laskemalla yhteen salattavan viestin ja avaimen vastaavien merkkien lukuarvot. Laskun tulos muutetaan taas merkiksi. Purku vastaavasti tapahtuu vähentämällä salatun viestin merkin vastaavan avainmerkin lukuarvo. Jos luku on suurempi kuin 26 vähennetään siitä 26 ja jos luku on pienempi kuin nolla, lisätään siihen 26 merkin lukuarvon saamiseksi. Salaus ei ole erityisen vahva, sillä jos on mahdollista arvata edes osa viestin sisällöstä, voidaan sillä paljastaa lisää viestin sisällöstä käyttämällä sitä avaimena ja viestin toimiessa avaimena jokainen viestistä paljastuva merkki paljastaa lisää merkkejä viestistä.

Autokey-salauksen avaimena toimii avainsana ja salattava viesti itse.

Esimerkki:
Avainsana:		AVAIN
Salaamaton teksti:	SALATTAVATEKSTI
Avain:			AVAINSALATTAVAT
Salattu teksti:		TWMJHMBHBNYLHUM


Vigenère:
Vigenère-salaus koostuu useista limittäisistä Caesar-salauksista. Jokainen avainsanan kirjaimista muutetaan luvuksi, joka toimii Caesar-salauksen avaimena. Kun kaikki avaimet on käytetty aloitetaan alusta.

Vigenère-salauksen avaimena toimii avainsana.

Esimerkki:
Avain:			AVAIN
Salaamaton teksti:	SALATTAVATEKSTI
Avain:			AVAINAVAINAVAIN
Salattu teksti:		TWMJHUWWJHFGTCW


Playfair:
Playfair-salauksessa salataan kirjainpareja. Jos viestin pituus on pariton, lisätään loppuun Q. Jos kirjainpari koostuisi kahdesta samasta merkistä, lisätään niiden väliin Q.

Playfair-salauksen avain on 5x5-ruudun taulukko, joka sisältää aakkoset.
J-kirjain tulkitaan I:ksi, jotta aakkosten pituudeksi saadaan 25 merkkiä.

Säännöt avaimen käyttöön:
Jos salattavat kirjaimet ovat samoja, tai kirjaimia on vain yksi:
	Lisätään ensimmäisen kirjaimen perään Q (jälkimmäinen samoista kirjaimista siirtyy seuraavaan pariin).
Jos salattavat kirjaimet ovat samalla vaakarivillä:
	Salattu kirjain on kummankin kirjaimen oikealla puolella sijaitseva kirjain palaten tarvittaessa rivin alkuun.
Jos salattavat kirjaimet ovat samalla pystyrivillä:
	Salattu kirjain on kummankin kirjaimen alla sijaitseva kirjain palaten tarvittaessa rivin alkuun.
Jos kirjaimet ovat eri vaaka- ja pystyriveissä:
	Muodostetaan suorakaide, jonka kulmissa salattavat kirjaimet ovat. Salattu kirjain on saman rivin vastakkaisessa kulmassa sijaitseva kirjain.

Esimerkki:
Avain:	T A M O N
	K E V I S
	Y B C D F
	G H J L Q
	R U W X Z
Salaamaton viesti:	SALATTAVATEKSTI
Salattu viesti:		NEHONGAMMEAKEKOK


OTP:
OTP-salauksessa (One-Time Pad), merkit muutetaan ensin niitä vastaaviksi luvuiksi ja tämän jälkeen niihin lisätään avaimen vastaavassa kohdassa esiintyvä luku.
Tulos muutetaan jälleen merkiksi. Jos luku ylittää käytettävän merkistön pituuden aloitetaan alusta.
Salaus puretaan vähentämällä kutakin merkkiä vastaavasta luvusta avaimen vastaavan kohdan luku ja muuttamalla tulos merkiksi. Jos luku alittaa nollan, palataan merkistön loppuun.
Salaus on oikein toteutettuna erittäin vahva ja periaatteessa mahdoton murtaa, sillä oikeaa tulosta ei voi erottaa väärästä tuntematta viestin sisältöä etukäteen.
Salausta on kuitenkin hankala hyödyntää käytännössä, sillä avaimet ovat pitkiä (vähintään yhtä pitkä kuin viesti), niiden on oltava aidosti satunnaisia, eikä niitä voi käyttää kuin kerran vaarantamatta salausta.

OTP-salauksen avain on lukujono, jonka pituus on vähintään yhtä suuri kuin käytettävän merkistön.

Esimerkki:
Avain:					23 12 9  7  26 2  14 15 21 1  9  15 4  26 2
Salaamaton teksti:			S  A  L  A  T  T  A  V  A  T  E  K  S  T  I
Salaamatonta tekstiä vastaavat luvut:	19 1  12 1  20 20 1  22 1  20 5  11 19 20 9
Salattua tekstiä vastaavat luvut:	42 13 21 8  46 22 15 37 22 21 14 26 23 46 11
					16 13 21 8  20 22 15 11 22 21 14 26 23 20 11
Salattu teksti:				P  M  U  H  T  V  O  K  V  U  N  Z  W  T  K
