Käsin on testattu:
-Ohjelman yleistä toimintaa (salaus- ja purkutila vaihtuvat nappia painaessa, saalaus vaihtuu, ohjelma reagoi niin kuin sen odotetaan reagoivan)
-Salausten toimintaa (salausalgoritmien tulokset, avainten asettaminen, salaus ja purku)
-Käyttöliittymän toimintaa (oikeat ikkunat ovat muokattavissa, teksti kirjoitetaan minne pitäisikin)

Käsin suoritettu testaus kokonaisuudelle:
1. Ohjelma suoritetaan ja tarkastetaan käyttöliittymän ulkonäkö.
2. Ohjelmalle annetaan salausavain.
3. Ohjelmalla salataan tekstiä ja tarkistetaan, että salattu teksti vastaa salauksen tulosta.
4. Vaihdetaan tila salauksen purkamiseen.
5. Tyhjennetään tekstikentät
6. Kirjoitetaan salattua tekstiä ja tarkistetaan, että purettu teksti on mitä käytössä olevalla avaimella pitäisikin.
7. Toteutetaan kohdat 2. ja 3./6. uudella avaimella ja tarkistetaan avaimen vaihdon toimivuus.
8. Vaihdetaan salausmuotoa.
9. Toteutetaan kohdat 2.-7. toisella salauksella ja varmistetaan senkin toimivuus.

Käsin on suoritettu myös pienempiä testejä, jotka ovat kattaneet vain osia ohjelmasta.

Tuloksia:
Askelpalautin tuottaa ongelmia.
Vignere-salaus on hankala käyttää, sillä se ei nollaudu.
