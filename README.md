# SearchVehicles-Stajcell

Bu projede daha onceden verilen bir dosyadan belli olan araclar arasinda arama yapilmaktadir. Arama icin string girilmesi gerekmekte ve araclarin ozellikleri icerisinde bu dizinin gecmesi durumunda da bu araclarin bilgileri web sayfasina yansitilacaktir. Bu arama 4 farkli sekilde gerceklesebilmektedir. 

1 - Butun araclar arasindan arama "localhost:8080/search".

2 - Araclarin markasina gore arama "localhost:8080/searchbymarka".

3 - Araclarin modeline gore arama "localhost:8080/searchbymodel".

4 - Araclarin sinifina gore arama "localhost:8080/searchbysinif".

Bu arama sayfalarinin yaninda ana sayfa "localhost:8080" ve butun araclarin siralandigi bir sayfa bulunmakta "localhost:8080/all".

Verilen dosyadaki arac bilgileri Oracle Database ile tutuldu ve web sayfasinin olusturulmasi icin de Spring Boot kullanildi, build icin de Maven.

Girilen stringin araclarin ozellikleri arasinda aranma surecinde de Knuth–Morris–Pratt algoritmasi kullanilmistir. 
N : toplam arac sayisi , M : araclarin ozelliklerinin karakter sayisi olarak tanimlarsak aramanin zaman karmasikligi da O( NxM ) olmaktadir.

Bu ozellikleri test ederkenden SoapUI uygulamasinin yardimiyla da yukaridaki bahsedilen linklerde gerekli GET ve POST talepleriyle de REST API uygulama test edildi.

Not : Kodda database icin gerekli yerlere database, username, ve password girilmesi gerekli. Application.java ve application.properties dosyalarinda gerekli yerler belirtilmistir. pom.xml'de de ojdbc jarinin yuklenebilmesi icin bilgisayarinizda bulundugu konumu eklemelisiniz.
