Ohjelmalla voidaan toteuttaa yksinkertaisia salauksia kirjoitetulle tekstille.
Käyttö:
1. Tarkista vasemmalta, että salaustila (salaus tai purku) ja salaus ovat haluamiasi.
2. Paina Set key -nappia oikealla.
3. Kirjoita avain Key: -kenttään. Lopeta painamalla rivinvaihtoa.
4. Avainkentässä tulisi nyt näkyä kirjoittamasi avain. Jos näin ei ole ei avain ole hyväksyttyä muotoa (katso salaukset.md salausten käyttämiä avaimia varten).
5. Kirjoita tekstiä Plaintext: tai Ciphertext -kenttään. Ohjelma salaa tai purkaa tekstin reaaliajassa.

Voit vaihtaa salaustilaa, salausta ja avainta milloin tahansa. On kuitenkin suotavaa tyhjentää kentät tämän jälkeen. Aiemmin kirjoitettuja merkkejä ei salata uudelleen avaimen tai salauksen muuttuessa.

Huomioitavaa:
Rivinvaihto tyhjentää salaus- ja purkukentät.
Ohjelma salaa vain pieniä kirjaimia välillä a-z, ei mitään muuta.
Ohjelma ei salaa esimerkiksi välilyöntejä, erikoismerkkejä tai isoja kirjaimia, nämä merkit siirtyvät salaamattomina.
Askelpalautin ei toimi odotetulla tavalla, jos teet virheen, kannattaa tyhjentää kentät rivinvaihdolla.
Vignere-salauksen tila ei nollaudu automaattisesti, mikä voi johtaa avaimen toimimattomuuteen, jos ohjelma ei ala purkamaan salausta oikeasta kohdasta.
