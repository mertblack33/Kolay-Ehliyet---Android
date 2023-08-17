package com.ehliyet.kolayehliyet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import com.google.android.gms.ads.AdRequest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.Objects;

public class Soru50ana extends AppCompatActivity {

    // DATA
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru1 = {"Aşağıdakilerden hangisi 3. derece yanıkların bir göstergesidir?","Araç gösterge panelinde “ABS” uyarı ışığının yanması, aracın hangi sisteminde arıza olduğunu belirtir?","Şekildeki kara yoluna ne ad verilir?","Motorlu bisiklet, motosiklet ve sürücüleri ile ilgili olarak aşağıda verilenlerden hangisinin yapılması yasaktır?","Aşağıdakilerden hangisi solunum durmasına bağlı olarak dokuların oksijensiz kaldığını gösteren bir belirtidir?","Aksine bir işaret yoksa şekildeki araç için yerleşim yeri dışındaki bölünmüş yollarda azami hız sınırı saatte kaç kilometredir?","Aşağıdakilerden hangisi ilk yardımın hedeflerinden biri değildir?","Solunum yolu tıkanıklığı yaşayan dört kazazedeye ait belirtiler aşağıdaki tabloda verilmiştir.Tabloya göre bu kazazedelerden hangilerine “Heimlich manevrası” uygulanmalıdır? ","Yanık derecesini belirlemede aşağıdakilerden hangisi diğerlerine nazaran daha önemlidir?","Trafikte iki araç yol verme/vermeme konusunda birbirlerine karşı üstünlük kurmaya çalışmaktadır.Böyle bir durum söz konusuyken araç sürücüsünün çok öfkeli olduğu gözlemlenmektedir. Camını indirip öfkesini dışa vurmaya hazırlanırken, diğer araç sürücünün hangi davranışı sergilemesi trafik adabı açısından doğru olur."};
    String[] soru1cevap1 ={"Yanık bölgesinde sinir harabiyetinin olması","Fren","Bölünmüş yol","İkiden fazlasının taşıt yolunun bir şeridinde yan yana sürülmesi","Parmak uçları ve dudaklardan başlayıp yayılan morarma olması","110","Bulaşıcı hastalıkların önlenmesi","III ve IV.","Yanık yüzeyinin genişliği ve yanığın derinliği","Gülümseyerek karşılık vermesi"};
    String[] soru1yanlis1 ={"Kılcal damar uçları ve sinir uçlarının açık olması","Yakıt","Geçiş yolu","Gidiş yönüne göre yolun en sağından seyredilmesi","Göz bebeklerinin küçülmesi","90","Şokun önlenmesi","I ve II.","Yakıcı etkiyi gösteren maddenin miktarı","Aynı şekilde karşılık vermesi"};
    String[] soru1yanlis2 ={"Deri bütünlüğünün bozulmaması ve derinin gergin olması","Yağlama","Tali yol","Tehlikeli madde taşıyan araçların geçilmesi","Kişinin aktif ve huzursuz olması","100","Acil yardım istenmesi","II ve IV.","Yaralının üzerinde bulunan giysilerin cinsi","Küfretmesi"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru2 = {"Aşağıdakilerden hangisi, yolcu taşımacılığında kullanılan ve sürücüsü dahil dokuzdan fazla oturma yeri olan motorlu taşıttır?","Bazı sürücülerin, trafik kurallarına uymamasının en önemli sebebi aşağıdakilerden hangisidir?","Şekilde soru işareti (?) ile gösterilen ve aktarma organlarına güç veren hangisidir?","Aşağıdakilerden hangisinin şehir içindeki araçlarda kullanılması yasaktır?","Aşağıdakilerden hangisi araçlarda egzoz gaz emisyonlarını azaltmak için kullanılır?","Fazla eğimli yollarda karşılaşma hâllerinde; çıkan araç için geçiş güç veya mümkün değilse, güvenli geçişi sağlamak üzere inen araçlar, sığınma cebi de yoksa aşağıdakilerden hangisini yapmak zorundadır?","İnsan faktörünün kazalarda oynadığı rolü belirlemek ve araştırma bulgularından yola çıkarak, kazaları engelleyebilecek önlemler üretmek aşağıdakilerden hangisinin alanına girer?","Aşağıdakilerden hangisi motorun soğutma sisteminde yapılması gereken kontrollerdendir?","1. Işıklı trafik işaret cihazı 2. Trafik levhası ve yer işaretlemeleri 3. Trafik görevlisiYukarıda verilenlerin bir kavşakta bulunması hâlinde, sürücülerin bunlara uymadaki öncelik sıralaması nasıl olmalıdır?","Şekildeki trafik işaretinin anlamı nedir?"};
    String[] soru2cevap1 ={"Otobüs","Trafik kurallarını davranış hâline dönüştürememiş olmaları","Motor","Havalı korna","Katalitik konvertör","Çıkan araç için manevra imkânı bulunmadığının açıkça anlaşılması hâlinde geri gitmek","Trafik psikolojisi","Antifriz kontrolü","3 - 1 - 2 ","Motosiklet hariç motorlu taşıt trafiğine kapalı yol"};
    String[] soru2yanlis1 ={"Çekici","Yanlış algıladıkları kurallara karşı tepki göstermek istemeleri","Rot","Stepne","Egzoz supabı","Motorun çalışmasını durdurup, vitesi boşa alarak inmek","Adli tıp","Yağ seviyesi kontrolü","1 - 2 - 3","Taşıt giremez"};
    String[] soru2yanlis2 ={"Otomobil","Trafik işaret ve levhalarının anlamlarını yeterince bilmemeleri","Diferansiyel","Güneş gözlüğü","Emme manifoldu","Çıkan aracın sürücüsünü ikaz ederek yavaşlatmak","Kazazede","Elektrolit seviyesi kontrolü"," 3 - 2 - 1","Motosiklet giremez"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru3 ={"İlk yardımcı olarak bulunduğunuz güvenli olmayan olay yerinde; kazazedelerden biri başında, boynunda ve sırtında ağrı olduğunu, bacaklarını hareket ettiremediğini söylüyor, ayrıca kazazedenin burnundan ve kulağından kan geliyorsa bu kazazedeyi daha güvenli bir ortama nasıl taşırsınız?","Aracın farlarında arıza giderme veya far değişimi yapıldıktan sonra hangi ayarın yapılması gerekir?","Şekildeki trafik işaretinin anlamı nedir?","Şekilde soru işareti (?) ile gösterilen ve diferansiyelden aldığı hareketi tekerleklere ileten güç aktarma organının adı nedir?","Şekildeki gibi bir kavşakta karşılaşan araçların geçiş hakkı sıralaması nasıl olmalıdır?","I. Dönüş ışıklarının “geç” anlamında kullanılmasıII. Geceleri öndeki aracı yakından takip ederken kısa hüzmeli farların yakılmasıIII. Sis ışıklarının, sis ve kar sebebiyle görüşün yetersiz olduğu haller dışında kullanılmasıAraç ışıkları ile ilgili olarak yukarıda verilenlerden hangileri yanlıştır?","Motorlu bisiklet, motosiklet ve sürücüleriyle ilgili olarak aşağıdakilerden hangisinin yapılması yasaktır?","Aracın gösterge panelinde bulunan şekildeki ikaz ışığı, aşağıdakilerden hangisidir?","Baş yaralanması sebebiyle bayılan ve daha sonra kendine gelen yaralıya, aşağıdakilerden hangisi uygulanır?","Kalbi çalıştığı hâlde solunumu durmuş olanlara yapılacak suni solunuma ne kadar devam edilir?"};
    String[] soru3cevap1 ={"Baş-boyun-gövde ekseni bozulmadan düz pozisyonda sürükleyerek","Far ayarı","Durak","Aks","2 - 1 - 3 - 4","I ve III","Sürücü arkasında yeterli oturma yeri olsa bile bir kişiden fazlasının taşınması","Akü şarj ikaz ışığı","En az 12-24 saat süre ile hekim kontrolünde tutulur.","Hasta kendi kendine soluyuncaya kadar"};
    String[] soru3yanlis1 ={"Kazazedenin gövdesini sağ omuza yerleştirip ağırlığı dizlere vererek","Supap ayarı","Dur","Volan","1 - 2 - 4 - 3","II ve III","Gidiş yönüne göre yolun en sağından seyredilmesi","ABS fren sistemi ikaz ışığı","Başı sıcak su ile yıkanır.","Kalbi daha hızlı çalışana kadar"};
    String[] soru3yanlis2 ={"Omuzdan destek verip yürütmeye çalışarak","Rölanti ayarı","Devam et","Kavrama","2 - 3 - 4 - 1","I ve II","Tehlikeli madde taşıyan araçların geçilmesi","Hava yastığı ikaz ışığı","Bulantı önleyici ve ağrı kesici ilaç verilir.","10 dakika"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru4 ={"Şekle göre aşağıdakilerden hangisi kesinlikle söylenir?","Şoka girmiş bir kazazedede kanın, beyin ve hayati organlara taşınmasını sağlamak amacıyla yapılan uygulama aşağıdakilerden hangisidir?","Sağlıklı yetişkin bir kişinin dakikadaki solunum sayısı kaçtır?","Aşağıdakilerden hangisi atıkların çevreye verdiği zararlardan biri değildir?","Vücudumuzda belli bir işlevi yerine getirmek amacıyla bir araya gelen organların oluşturdukları yapıya ne denir?","Aşağıdakilerden hangisinin aşınması araçta direksiyon boşluğunun fazlalaşmasına neden olur?","Aşağıdakilerden hangisi motorun parçası değildir?","• Ayaklarının pedala sıkışmadığından emin olunur.• Yan tarafından yaklaşılır ve bir elle kolu, diğer elle çenesi kavranarak hafif hareketlerle boynu tespit edilir.• Baş-boyun-gövde hizasını bozmadan araçtan dışarı çekilir.Uygulama basamakları verilen ve kazazedenin araçtan çıkarılmasında kullanılan teknik, aşağıdakilerden hangisidir?","Aşağıdakilerden hangisi, araç kullanırken öfke duygusuna kapılan bir sürücünün kendisini sakinleştirmek için uygulaması gereken yöntemlerden biri değildir?","Hangisi, benzinli motorlarda silindire alınmış olan karışımın sıkıştırma zamanı sonunda tutuşturulabilmesi için gerekli olan elektrik kıvılcımını çıkarır?"};
    String[] soru4cevap1 ={"1 numaralı aracın doğru geçmekte olan 2 numaralı araca yol vermediği","Sırt üstü yatırılarak ayaklarının 30 cm kadar yükseltilmesi","12 - 20","Toplanıp işlenerek tekrar kullanılabilir hâle getirilmesi","Sistem","Rot başlarının","Aks","Rentek manevrası","Karşılaşılan durumla ilgili negatif çözümler üretmesi","Buji"};
    String[] soru4yanlis1 ={"2 numaralı aracın yanlış şeritte seyrettiği","Baş, boyun ve gövde ekseninin korunması","10 - 18","Kötü koku yayması","Doku","Vites kutusunun","Supap","İtfaiyeci yöntemi","Trafik ortamında gerilimli durumların olabileceğini kabul etmesi","Flaşör"};
    String[] soru4yanlis2 ={"1 numaralı aracın dönüş işaretini yanlış kullandığı","Kazazedenin gömlek yakasının ve kemerinin gevşetilmesi","14 - 22","Çirkin görünüm arz etmesi","Hücre","Pistonların","Piston ","Heimlich manevrası","Radyo veya müzik açması","Enjektör"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru5 ={"İnsan vücudunda ağız, yemek borusu, mide, ince ve kalın bağırsakların yer aldığı sistem hangisidir?","Ülkemizde en çok bağışlanarak nakli yapılabilen doku aşağıdakilerden hangisidir?","Şekildeki trafik işareti sürücüye neyi bildirir?","Kara Yolları Trafik Kanunu’na göre “C1, C1E, C, CE, D1, D1E, D ve DE” sınıfı sürücü belgeleri kaç yıl süreyle geçerlidir?","Aşağıdakilerden hangisi yakıt sarfiyatını artırır?","Hususi otomobillere 3 yaş sonunda kaç yılda bir muayene yaptırılması zorunludur?","Şekildeki trafik işareti aşağıdakilerden hangisine yaklaşıldığını bildirir?","Aksine bir işaret yoksa şekildeki aracın yerleşim yeri içindeki azami hızı saatte kaç kilometredir?","İlk yardım çantasında aşağıdakilerden hangisinin bulundurulması zorunlu değildir?","Yağ pompasının pompaladığı yağı süzerek, içindeki yabancı maddeleri temizleyen yağlama sistemi parçası aşağıdakilerden hangisidir?"};
    String[] soru5cevap1 ={"Sindirim sistemi","Kan","Azami hız sınırını","5","Rölanti devrinin yüksek olması","2","Kontrolsüz demir yolu geçidine","50","Kâğıt mendilin","Yağ filtresi"};
    String[] soru5yanlis1 ={"Dolaşım sistemi","Kemik iliği","Taşıtın giremeyeceğini","2","Fren hidroliğinin tamamlanması","1","Kontrollü demir yolu geçidine","80","Çengelli iğnenin","Enjektör"};
    String[] soru5yanlis2 ={"Solunum sistemi","Kornea","Geçme yasağı sonunu","7","Soğutma suyuna antifriz katılması","3","Demir yolu alt geçidine","70","Makasın","Yakıt filtresi"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru6 ={"Tehlikeli madde taşıyan araçlar arızalandığında aşağıdakilerden hangisi yapılmalıdır?","Yakıtı doğrudan doğruya silindirler içersinde yakan ve üretilen ısı enerjisini pistonbiyel mekanizması ile krank miline ileten motorlara ne ad verilir?","Arkadan çarpma şeklindeki trafik kazalarının en önemli sebebi aşağıdakilerden hangisidir?","Aşağıdakilerden hangisi, trafik kazalarının ülke ekonomisine verdiği zararlardan biri değildir?","Kontrollü demir yolu geçidine yaklaşan sürücüler nasıl hareket etmelidir? ","Aşağıdaki temel değerlerden hangisini içselleştirmiş bir sürücü, trafikte kendinden çok başkalarını düşünür ve başkalarının iyiliği için fedakârlık yapar?","Motorlu araçlarda eski ve aşınmış lastiklerin kullanılması, aşağıdakilerden hangisine sebep olur?","Aşağıdakilerden hangisi, delici karın yaralanmalarında yapılan doğru bir ilk yardım uygulamasıdır?","Normal hayatında emniyet kemerinin olası bir kazada hayat kurtardığını bilen ve bu bilinçle emniyet kemerini takan bir kişi, yanında yolculuk ettiği kişinin etkisi ile emniyet kemerini takmayabilir.Yukarıda verilen ifade aşağıdakilerden hangisinin sebebidir?","I. Sis ışıklarının; sis, kar, şiddetli yağmur sebebiyle görüşün yetersiz olduğu hâller dışında kullanılması yasaktır.II. Karşı yönden gelen araç sürücülerinin ve kara yolunu kullanan diğer kişilerin gözlerini kamaştıracak bütün hâllerde, uzun hüzmeli farların yakılması yasaktır.Bu bilgiler için aşağıdakilerden hangisi söylenebilir?"};
    String[] soru6cevap1 ={"Kırmızı ışık veren cihazlarla işaretlenip gözcü bulundurulmalı"," İçten yanmalı motor","Takip mesafesi kurallarına uyulmaması","Trafik suçlarına uygulanan cezaların artırılması"," Hızını azaltıp, bariyerin izin vermesi hâlinde ve başka bir “DUR” emri de yoksa uygun hızla geçmeli","Diğergamlık"," Yağışlı havalarda kaza tehlikesinin artmasına","Organlar dışarı çıkmış ise içeri sokulmayıp, üzerinin temiz ve nemli bir bez ile örtülmesi","Psikolojik etki","Her ikisi de doğrudur."};
    String[] soru6yanlis1 ={"Acil uyarı ışıkları ile diğer araç sürücüleri uyarılmalı","Marş motoru","Görüş mesafesinin kötü olması","Trafik işaretlerinin hasar görmesi","İnmiş bariyer varsa geçide girmeli","Bencillik","Motorun yağ yakmasına","Enfeksiyonu engellemek için yara bölgesinin sıcak sabunlu su ile yıkanması","Diğergamlık","I. doğru II. yanlıştır"};
    String[] soru6yanlis2 ={"Aracın ön ve arkasına büyük boyutlu taşlar dizilmeli","Elektrik motoru","Öndeki aracın yavaşlaması","Kara yollarının zamanından önce yıpranması","Yol açıksa hızlı geçerek uzaklaşmalı","Nezaketsizlik","Egzozdan siyah renkli duman çıkmasına","Kazazedenin bilinci yerinde ise yüz üstü pozisyonda yatırılması","Saygı"," I. yanlış II. doğrudur."};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru7 ={"• Kaza sonrası meydana gelen maddi hasar miktarı• İş gücü kaybının yanı sıra yaralıların tedavi süreçleri ve maliyetiTrafik kazalarıyla ilgili olarak verilenler, aşağıdakilerden hangisini olumsuz yönde etkiler?","Aşağıdakilerin hangisinde şok pozisyonu vermek sakıncalıdır?","I- Sızıntı biçiminde ve hafif olmasıII- Koyu renkli ve taşma tarzında akmasıIII- Kalp atımına uyumlu şekilde fışkırarak çıkmasıVerilenlerden hangileri atardamar kanamalarına ait bir özelliktir?","Aracın motorunda başlayan bir yangını, yangın söndürücü ile söndürmek için ilk olarak aşağıdakilerden hangisi yapılır?","Göğüsteki delici yaradan hava girmemesi için, yara aşağıdakilerden hangisi ile kapatılır?","İlk yardım çantasında aşağıdakilerden hangisinin bulundurulması zorunlu değildir?","Osmaniye'den hareket eden bir araç, haritada görüldüğü gibi önce Malatya'ya oradan da Ankara'ya gitmiştir.","Yağ pompasının pompaladığı yağı süzerek, içindeki yabancı maddeleri temizleyen yağlama sistemi parçası aşağıdakilerden hangisidir?","Şekle göre hangi numaralı yollar tali yoldur?","Aşağıdakilerden hangisi sürüş sırasında aracın bir tarafa çekmesine sebep olur?"};
    String[] soru7cevap1 ={"Ülke ekonomisini","Burnundan ve kulağından kanama olanlarda","Yalnız III","Kaput açılmadan, yangın söndürücü motorun ön ve alt kısmına püskürtülür.","Islak, temiz sargı beziyle","Kâğıt mendilin","Kuzeydoğu-Kuzeybatı","Yağ filtresi","1 - 3","Lastiklerden birinin hava basıncının farklı olması"};
    String[] soru7yanlis1 ={"Kasko sigortasının önemini","Tansiyonu düşük ve nabız alınamayanlarda","Yalnız I","Kaput açılır ve yangın söndürücü alevin üstüne püskürtülür.","Kuru pamukla","Çengelli iğnenin","Batı-Doğu","Enjektör","1 - 2","Aracın hızlı sürülmesi"};
    String[] soru7yanlis2 ={"Bireylerde trafik bilincinin oluşmasını","El bileğinde açık kırık ve kanama olanlarda","Yalnız II","Motora önce su döküp, daha sonra yangın söndürücü püskürtülür.","Atel ile","Steril gazlı bezin","Kuzey-Güney","Hava filtresi","2 - 4","Yayların yağsız kalması"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru8 ={"Yerleşim birimleri dışındaki karayollarında geceleri seyrederken, yeterince aydınlatılmamış tünellere girerken, benzeri yer ve hâllerde - - - - yakılması mecburidir.Verilen ifadede boş bırakılan yere aşağıdakilerden hangisi yazılmalıdır?","İlk yardım çantasında gazlı bez bulundurmanın amacı nedir?","Bayılan hastaya ilk yardım olarak aşağıdakilerden hangisi uygulanmaz?","Yaralıyı araçtan çıkarırken aşağıdakilerden hangisine dikkat edilmelidir?","Aksine bir işaret bulunmadıkça, otoyolda otobüsler için azami hız saatte kaç kilometredir?","Aşağıdakilerin hangisindeki arıza, sinyal lambalarının yanmamasına sebep olur?","Aşağıdakilerden hangisi bir kazazedede soluk yolunun açık ve solunumun yeterli olduğunun göstergesidir?","Yaralı taşımada sedye kullanımı ile ilgili olarak aşağıdakilerden hangisi doğrudur?","Yağ çubuğunun görevi aşağıdakilerden hangisidir?","Kaza yerine ulaşan ilk yardımcının öncelikle yapması gereken nedir?"};
    String[] soru8cevap1 ={"uzağı gösteren ışıkların","Yaraları kapatmak ve sarmak","Soğuk içecekler içirmek","Baş - boyun - gövde hizasının bozulmamasına","100","Flaşördeki","Kazazedenin bilinçli olması ve zorlanmadan konuşabilmesi","Sedye kullanımı her zaman tercih edilmelidir.","Motor yağı seviyesini göstermek","Kendinin ve yaralıların güvenliğini sağlamak"};
    String[] soru8yanlis1 ={"sis ışıklarının","Kalp masajında kullanmak","Şok pozisyonu vermek","Baş tarafından çekilerek çıkarılmasına","110","Distribütördeki","Göğüs kafesinin hareket etmemes","Sadece bacağı kırılanları yatırarak taşımak için tercih edilir.","Elektrolit seviyesini göstermek","Kazayı yetkililere haber vermek"};
    String[] soru8yanlis2 ={"park ışıklarının","Kırıklarda ağrıyı azaltmak","Duyu organlarını uyarmak","Kollarının baş hizasında durmasına","120","Marş motorundaki","Solunumun hırıltılı ve horlama şeklinde olması","Sadece zehirlenme vakalarının taşınmasında kullanılmalıdır.","Soğutma suyu seviyesini göstermek","Yaralıları belirlemek"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru9 ={"Yeni yönetmeliklere göre: “CE” sınıfı sürücü belgesi olan aşağıdakilerden hangisini kullanamaz?","Sürücüler; yaya ve okul geçitlerine yaklaşırken, görüş yetersizliği olan tepe üstü ve dönemeçlerde aşağıdakilerden hangisini yapmalıdır?","Aşağıdaki araçların hangisinde, yangın söndürme cihazı bulundurmak zorunlu değildir?","Aracın belli bir mesafede gidebileceği kadar yakıtın araç üzerinde bulundurulmasına yarayan parça hangisidir?","Dizel motorlar hangi prensibe göre çalışır?","Aşağıdakilerden hangisi elektrik devresindeki sigortanın görevidir?","Önündeki aracı güvenli ve yeterli mesafeden izlemeyen sürücü için aşağıdakilerden hangisi kesinlikle söylenir?","Sürücüler, geceleri yakın ilerisi görülmeyen kavşak, dönemeç ve tepe üstlerine yaklaşırken gelişlerini nasıl haber vermek zorundadır?","Aşağıdaki kemiklerden hangisinde kırık olması durumunda kazazedenin göğüs bölgesine yapılan baskıda şiddetli ağrı, nefes almada güçlük ve öksürük belirtileri görülür?","Şekle göre araçların ışıksız bir kavşakta karşılaşmaları hâlinde ilk geçiş hakkını hangisi kullanmalıdır?"};
    String[] soru9cevap1 ={"Motorlu bisiklet","Hızını azaltmalı","Lastik tekerlekli traktör","Yakıt deposu","Sıkıştırılmış hava üzerine mazot püskürtme","Kısa devre olduğunda sistemi korumak","Trafik kuralına uymadığı","Yakın ve uzağı gösteren ışıkları art arda ve sıra ile yakarak","Kaburga kemiği","2 nolu araç"};
    String[] soru9yanlis1 ={"Kamyon","Öndeki aracı geçmeli","Otobüs","Bagaj","Sıkıştırılmış hava üzerine benzin püskürtme","Aküyü şarj etmek","Çok dikkatli olduğu","Dönüş ışıklarını yakarak","Kol kemiği","1 nolu araç"};
    String[] soru9yanlis2 ={"Tır","En sol şeritten gitmeli","Kamyon","Karter","Sıkıştırılmış mazot-hava karışımını bujiyle ateşleme","Bujilere giden akımı yükseltmek","Çok tecrübeli olduğu","Birkaç defa korna çalarak","Kalça kemiği","Hızı fazla olan araç"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru10 ={"Yerleşim birimleri dışındaki karayollarında geceleri seyrederken, yeterince aydınlatılmamış tünellere girerken, benzeri yer ve hâllerde - - - - yakılması mecburidir.Verilen ifadede boş bırakılan yere aşağıdakilerden hangisi yazılmalıdır?","İlk yardım çantasında gazlı bez bulundurmanın amacı nedir?","Bayılan hastaya ilk yardım olarak aşağıdakilerden hangisi uygulanmaz?","Yaralıyı araçtan çıkarırken aşağıdakilerden hangisine dikkat edilmelidir?","Aksine bir işaret bulunmadıkça, otoyolda otobüsler için azami hız saatte kaç kilometredir?","Aşağıdakilerin hangisindeki arıza, sinyal lambalarının yanmamasına sebep olur?","Aşağıdakilerden hangisi bir kazazedede soluk yolunun açık ve solunumun yeterli olduğunun göstergesidir?","Yaralı taşımada sedye kullanımı ile ilgili olarak aşağıdakilerden hangisi doğrudur?","Yağ çubuğunun görevi aşağıdakilerden hangisidir?","Kaza yerine ulaşan ilk yardımcının öncelikle yapması gereken nedir?"};
    String[] soru10cevap1 ={"uzağı gösteren ışıkların","Yaraları kapatmak ve sarmak","Soğuk içecekler içirmek","Baş - boyun - gövde hizasının bozulmamasına","100","Flaşördeki","Kazazedenin bilinçli olması ve zorlanmadan konuşabilmesi","Sedye kullanımı her zaman tercih edilmelidir.","Motor yağı seviyesini göstermek","Kendinin ve yaralıların güvenliğini sağlamak"};
    String[] soru10yanlis1 ={"sis ışıklarının","Kalp masajında kullanmak","Şok pozisyonu vermek","Baş tarafından çekilerek çıkarılmasına","110","Distribütördeki","Göğüs kafesinin hareket etmemes","Sadece bacağı kırılanları yatırarak taşımak için tercih edilir.","Elektrolit seviyesini göstermek","Kazayı yetkililere haber vermek"};
    String[] soru10yanlis2 ={"park ışıklarının","Kırıklarda ağrıyı azaltmak","Duyu organlarını uyarmak","Kollarının baş hizasında durmasına","120","Marş motorundaki","Solunumun hırıltılı ve horlama şeklinde olması","Sadece zehirlenme vakalarının taşınmasında kullanılmalıdır.","Soğutma suyu seviyesini göstermek","Yaralıları belirlemek"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru11 ={"Manevra yapacak sürücü aşağıdakilerden hangisini yapmalıdır?","Aşağıdakilerden hangisi, kısmi tıkanıklık yaşayan kazazedeye yapılacak ilk yardım uygulamalarından biri değildir?","Omurga kırığı olan yaralılara aşağıdaki uygulamalardan hangisi kesinlikle yapılmaz?","Aşağıdakilerden hangisi Kara Yolları Genel Müdürlüğünün görev ve yetkilerindendir?","110 km/saat hızla seyreden bir aracın, önündeki aracı takip mesafesi en az kaç metre olmalıdır?","Aşağıdakilerden hangisi yakıt sisteminde yapılan kontrellerden biri değildir?","I. Soğutma suyunun donmasını engellemekII. Motorun daha verimli çalışmasını sağlamakIII. Motorda oluşabilecek pas ve korozyonu önlemekYukarıdakilerden hangileri antifrizin görevlerindendir?","Aşağıdakilerden hangisi motorun sarsıntılı çalışmasına sebep olur?","Aksine bir durum yoksa, şekildeki gibi ışıklı trafik işaret cihazında yeşil ışığın yandığını gören sürücü ne yapmalıdır?","Aşağıdakilerden hangisi, bebeklere yapılan suni solunum uygulamasında dikkat edilecek kurallardandır?"};
    String[] soru11cevap1 ={"Ön, arka ve yanlardaki trafiği kontrol etmeli","Öksürmesi engellenir.","Yaralıya dik oturur pozisyon verilir.","Tüm kara yollarındaki işaretleme standartlarını tespit etmek, yayınlamak ve kontrol etmek","55","Antifriz kontrolü","I, II ve III.","Buji kablolarından birinin çıkmış olması","Durmadan dikkatli geçmeli","Solunum yoksa ağzın, bebeğin ağız ve burnunu içine alacak şekilde yerleştirilip ağız dolusu nefes verilmesi"};
    String[] soru11yanlis1 ={"İşaret verdiği anda manevraya başlamalı","Gevşemiş takma dişleri varsa çıkarılır.","Uzun tahta atellerle vücut tespit edilir.","Duran ve akan trafiği düzenlemek ve yönetmek","65","Yakıt filtresi kontrolü","Yalnız I","Akünün şarjlı olması","İlk geçiş hakkını yayalara vermeli","Bebeğin yumuşak bir zemin üzerine, sırt üstü yatırılması"};
    String[] soru11yanlis2 ={"Manevraya başladıktan sonra işaret vermeli","Morarma saptanırsa derhal girişimde bulunulur.","Yaralı sert bir zemine sırt üstü yatırılır.","Çocuk trafik eğitim parklarını yapmak","60","Yakıt kaçağı kontrolü","I ve III.","Yakıt seviyesinin düşük olması","Durup, yolu kontrol ettikten sonra geçmeli","Hava yolu tıkanıklığına neden olan yabancı cisim varsa bebeğin yutmasının sağlanması"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru12 ={"I. Araç içinde savrulma II. Araçtan dışarı fırlama III. Ölüm ve yaralanmalarda artma Verilenlerden hangileri, kaza anında emniyet kemerinin kullanılmaması sonucu meydana gelebilecek durumlardandır?","Donmayı önlemek için radyatöre ne konulur?","Aşağıdakilerden hangisi yağlama sisteminde yapılan kontrollerden biri değildir?","Hareket hâlindeki aracın stop ettirilmeden durdurulabilmesi için aşağıdakilerden hangisinin yapılması gerekir?","Karter aşağıdakilerden hangisine depoluk eder?","Aşağıdakilerden hangisi yakıt tüketiminin artmasında araçtan kaynaklanan kusurdur?","Koma durumundaki kazazedeye aşağıdaki pozisyonlardan hangisi verilmelidir?","Aksine bir işaret bulunmadıkça otoyolda minibüs ve otobüsler için azami hız saatte kaç kilometredir?","Okul taşıtının arkasındaki DUR işaretinin yandığını gören, arkadan gelen sürücü nasıl hareket etmelidir?","Trafikte heyecan ve zevk verici davranışları yapma eğiliminde olan bir sürücünün aşağıdaki davranışlardan hangisini gösterme olasılığı yüksektir?"};
    String[] soru12cevap1 ={"I, II ve III.","Antifriz","Hava filtresi kontrolü","Debriyaj ve fren pedalına birlikte basılması","Motor yağına","Debriyajın kaçırması","Yarı yüzüstü yan yatış","100","Aracını durdurmalıdır.","Sürekli şerit değiştirerek araç kullanma"};
    String[] soru12yanlis1 ={"II ve III.","Asit","Yağ kaçağı kontrolü","Gaz pedalına basılması"," Araç yakıtına","Ani duruş ve kalkış yapılması","Yarı oturuş","90","Dikkatli ve yavaş geçmelidir.","Yayaya yol verme"};
    String[] soru12yanlis2 ={"I ve II."," Yağ","Yağ rengi kontrolü","El freninin çekilmesi","Fren hidroliğine","Aşırı hız yapılması","Dik oturuş","80","Diğer sürücüleri uyarmalıdır","Hız sınırına uyma"};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru13 ={"Aşağıdakilerden hangisi diferansiyelin görevlerindendir?","Akü başka akü ile takviye yapılacaksa kutup başları nasıl bağlanır?","Şekildeki trafik işareti aşağıdakilerden hangisine yaklaşıldığını bildirir?","Aşağıdakilerden hangisi delici göğüs yaralanmalarında kazazedeye yapılan doğru bir ilk yardım uygulamasıdır?","Şekildeki trafik işaretlerine göre 1 numaralı araç sürücü nasıl davranmalıdır?","I. Öz eleştiri yapabilmekII. Risk almaya meyilli olmakIII. Trafikte diğer araç sürücülerini taciz etmekIV. Hata yapan sürücüleri uygun bir dille uyarmakYukarıdakilerden hangileri güvenli sürüşü olumsuz yönde etkileyen kişilik özelliklerindendir?","Araçta yakıt tasarrufu sağlamak için aşağıdakilerden hangisi yapılır?","Şekildeki trafik görevlisinin yapmış olduğu işaretin sürücüler için anlamı nedir?"," I- Şehirler arası yolcu taşıyan otobüslerII- Motorlu bisiklet ve motosikletlerIII- Traktör ve iş makineleriIV- OtomobillerYukarıda verilen araçların hangilerinde ilk yardım çantası bulundurulması zorunludur?","Trafikte hangi temel değere sahip olan sürücü, kendini yaya olan yol kullanıcısının yerine koyar ve aracını kaldırıma park etmekten kaçınır?"};
    String[] soru13cevap1 ={"Vites kutusundan gelen hareketi akslara iletmek","Artı kutup, artı kutupla; eksi kutup, eksi kutupla","Okul geçidine","Bilinci açık ise yarı oturur duruma getirilmesi","Daralan yol kesiminde karşıdan gelen araca yol vermeli","II ve III.","Lastiklerin hava basıncının normal değerde olmasına dikkat edilir.","Hızlan","I ve IV","Empati düzeyi yüksek"};
    String[] soru13yanlis1 ={"Motora ilk hareketi vermek","Artı kutup şasi ile","Yürüyüş yoluna","Ayaklarının yüksekte tutulup yüzüstü yatırılması","Hızını artırmalı","I ve IV.","Motor daima yüksek devirde çalıştırılır.","Yavaşla"," I ve II ","Görgü seviyesi düşük"};
    String[] soru13yanlis2 = {"Motorun durmasını sağlamak","Eksi kutup şasi ile","Gençlik kampına","Ağızdan ılık içecekler verilmesi","Önündeki aracı geçmeli","I, II ve III.","Trafiğin yoğun olduğu yollar seçilir.","Sağa yanaş","II ve III ","Sorumsuz"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru14 ={"Sürücünün aşağıda verilen hangi davranışı çevreyi olumlu etkiler?","Araç motorunun ilk çalıştırılması esnasında, aşağıdakilerden hangisine basılmasında fayda vardır?","I. İp, tel gibi kesici malzemelerin kullanılması II. Uygulamanın yapıldığı saatin bir kâğıda yazılıp kazazedenin üzerine asılması III. Uzvun koptuğu bölgeye en yakın ve deri bütünlüğü bozulmamış olan yere uygulanması Verilenlerden hangileri turnike uygulamasında dikkat edilecek hususlardandır?","Taşıt yolunun karşı tarafına geçecek yayalar, aşağıdakilerden hangisini tercih etmelidirler?","Hareketin motordan tekerlere kadar iletilmesini sağlayan güç aktarma organlarının çalışma sırası aşağıdakilerden hangisinde doğru olarak verilmiştir?","Kırmızı ışıkta beklerken ışık sarıya döner dönmez önündeki araca korna çalan sürücünün, ışığın yeşile dönmesi için 1 saniye bile bekleyememesi durumu, bu sürücünün trafikte hangi temel değere sahip olmadığını gösterir?","Soğutma sistemindeki termostat, aşağıdakilerden hangisinin belirli sıcaklıkta kalmasını sağlar? ","Bebeklerde soluk yoluna herhangi bir cismin kaçması hâlinde çıkartmak için ilk yardım olarak aşağıdakilerden hangisi yapılmalıdır?","I- Araçlarını ve araçlarının etrafını kontrol etmeleri II- Işıkla veya kolla, gerekli hâllerde her ikisi ile çıkış işareti vermeleri III- Görüş alanları dışında kalan yerler varsa uyarılmaları için bir gözcü bulundurmalarıDuraklanan ve park edilen yerden çıkılırken sürücülerin yukarıdakilerden hangilerini yapmaları zorunludur?","Motor hareketinin vites kutusuna iletilmesini sağlayan sistem aşağıdakilerden hangisidir?"};
    String[] soru14cevap1 ={"Aracının bakımını zamanında yaptırması","Debriyaj pedalına","II ve III","Yaya geçitlerini","Kavrama-Vites kutusu-Şaft-Diferansiyel-Aks","Sabır","Soğutma suyunun","Yüz aşağıda olacak şekilde kol üzerine yatırılıp kürek kemiklerinin arasına vurulmalı"," I - II - III","Kavrama"};
    String[] soru14yanlis1 ={"Aracını gereksiz yere çalışır hâlde tutması","Fren pedalına","I ve II","Geçiş yollarını","Vites kutusu-Kavrama-Aks-Şaft-Diferansiyel","İnatlaşma","Fren hidroliğinin","Şekerli su içirilmeli","I - II","Marş"};
    String[] soru14yanlis2 ={"Aracında ucuz ve kalitesiz yakıt kullanması","Vites koluna","Yalnız I","Yaya yollarını","Aks-Vites kutusu-Kavrama-Diferansiyel-Şaft","Öfke","Diferansiyel yağının","Sırtüstü yatırılıp ayakları yükseltilmeli"," I - III","Şarj"};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru15 ={"Aşağıdakilerden hangisi dış kanamalarda yapılan hatalı ilk yardım uygulamalarındandır?","Sürücüler dönüşlerde aşağıdakilerden hangisini yapmak zorundadır?","Çocuklarda yapılan temel yaşam desteği uygulamasında, göğüs kemiği kaç cm aşağı inecek şekilde kalp basısı uygulanır?","Kaza sonuçlarının ağırlaşmasını önlemek için olay yerinin değerlendirilmesini kapsar. En önemli işlem olay yerinde oluşabilecek tehlikeleri belirleyerek güvenli bir çevre oluşturmaktır.Verilen bilgi, ilk yardımın temel uygulamalarından hangisiyle ilgilidir?","Aşağıdakilerden hangisi karterdeki yağı basınçlı olarak motor parçalarına gönderir?","Kalp masajı yapılacak olan kazazede hangi pozisyonda ve nereye yatırılmalıdır?","I- El freninin çekilmesiII- Kontağın kapatılmasıIII- LPG'li ise tüpün vanasının kapatılmasıVerilenlerden hangileri, kazaya uğrayan bir araçta alınması gereken güvenlik önlemlerindendir?","Kazazedeye sözlü uyaranla ya da hafifçe omzuna dokunarak “iyi misiniz?” diye sorularak - - - - değerlendirmesi yapılır. Yukarıdaki açıklamada boş bırakılan yere hangisi yazılmalıdır? ","Şekildeki araç sürücüsü dönel kavşaktan geriye dönüş yapmak için hangi şeridi izlemelidir?","Aşağıdakilerden hangisi diferansiyelin görevlerindendir?"};
    String[] soru15cevap1 ={"Kanayan bölgeyi aşağıya indirmek","Niyetini dönüş lambasıyla önceden bildirmek","5","Koruma","Yağ pompası","Sırtüstü, sert bir zemine","I, II ve III","bilinç durumu","1 numaralı şeridi","Vites kutusundan gelen hareketi akslara iletmek"};
    String[] soru15yanlis1 ={"Kanayan yer üzerine temiz bir bezle bastırmak","Arkadan gelen araçlara yol vermek","2","Bildirme","Radyatör","Yüzüstü, sert bir zemine","I ve II","dolaşım","2 numaralı şeridi","Motorun rölantide çalışmasını sağlamak"};
    String[] soru15yanlis2 ={"Uzuv kopması varsa boğucu sargı (turnike) uygulamak","Dönmeye başladıktan sonra işaret vermek","8","Kurtarma","Distribütör","Sırtüstü, yumuşak bir zemine","II ve III","solunum","3 numaralı şeridi","Motorun durmasını sağlamak"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru16 ={"Aşağıdakilerden hangisi solunum durmasının nedenlerinden biri değildir?","Araçlarda ilk yardım çantası bulundurulmasının amacı aşağıdakilerden hangisidir?","Soluk yoluna yabancı cisim kaçmış bir kazazedenin;konuşamadığını, nefes alamadığını, renginin morardığını ve acı çekerek ellerini boğazına götürdüğünü gözlemlediniz. Bu belirtiler kazazedede hangi tür tıkanma olduğunu gösterir?","Aşağıdakilerden hangisi, öfkeyi başarılı bir şekilde yönetmek için önerilen davranışlardan biri değildir?","Öndeki aracın güvenle takip edildiği uzaklığa ne denir?","Aşağıdakilerden hangisi trafik psikolojisinin hedeflerindendir?","Motorlu bisiklet ve motosiklette bulunan sürücü ile yolcunun koruyucu başlık ve gözlük kullanmaları konusundaki hükümlerden hangisi doğrudur?","I- Kazazede sakinleştirilir, endişeleri giderilir. II- Kanama ciddi ise, kulağı tıkamadan temiz bezlerle kapatılır. III- Kazazede bilinçsiz ise kanayan kulak üzerine yan yatırılır. Kulak kanaması olan bir kazazedeye, yukarıda verilenlerden hangilerinin yapılması doğru bir ilk yardım uygulamasıdır?","Otobüs, kamyon, minibüs, kamyonet ve çekicilere bir yaş sonunda ve devamında kaç yılda bir muayene yaptırılması zorunludur?","Yanık vakalarında uygulanan ilk yardımda aşağıdakilerden hangisinin yapılması yanlıştır?"};
    String[] soru16cevap1 ={"Birinci derece yanıklar","Kazalarda ilk yardım için kullanmak","Tam tıkanma","Alaycı ve aşağılayıcı mizaha başvurulması"," Takip mesafesi","Trafik kazaları nedeniyle insan, araç ve çevrede meydana gelen zararı azaltmak","Sürücü başlık ve gözlük, yolcu sadece başlık kullanmalıdır."," I, II ve III","1","Yanığa bağlı oluşan su dolu kabarcıkların patlatılması"};
    String[] soru16yanlis1 ={"Zehirli gazların solunması","Araç muayenelerinde göstermek","Kısmi tıkanma","Düşünme tarzının yeniden yapılandırılması","Geçiş mesafesi","Trafikte yaya, hasta ve engellilere zorluk çıkarmak","Sürücü sadece başlık, yolcu gözlük ve başlık kullanmalıdır.","II ve III","3","Kazazedenin alevli yanması durumunda hava ile temasının kesilmesi"};
    String[] soru16yanlis2 ={"Solunum yolunun tıkanması","Trafik denetimlerinde göstermek","Damar tıkanması","Nefes egzersizlerinin öğrenilip uygulanması","Görüş mesafesi","Stresli olarak araç kullanmayı teşvik etmek","Sürücü ile yolcu başlık ve gözlük kullanmak mecburiyetindedir.","Yalnız I","2","Kimyasal madde yanıklarında yanan bölgenin bol su ile yıkanması"};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru17 = {"Şekildeki araç sürücüsü, kamu hizmeti yapan yolcu taşıtı durağının en az kaç metre mesafe dışına aracını park edebilir?","Araç hareket hâlindeyken, kontak kapatılmamalı veya kontak anahtarı kontaktan çıkartılmamalıdır. Buna rağmen kontak anahtarı kontaktan çıkartıldığında aşağıdakilerden hangisi olur?","Aşağıdakilerden hangisi, trafik denetim görevlileriyle iletişim kuran sürücünün trafik adabı açısından özen göstermesi gereken davranışlardandır?","Dönel kavşakta, geriye dönüşlerde aşağıdakilerden hangisinin yapılması yasaktır?","Aşağıdakilerden hangisi kalp durmasının belirtilerindendir?","Aşağıdakilerden hangisi motor soğutma suyunun azalmasına sebep olur?","I. Sürülen taşıtın cinsine uygun olmasıII. Yetkililerin istemesi hâlinde gösterilmesiIII. Taşıt sürerken sürücünün yanında bulundurmasıMotorlu taşıt sürücü belgesiyle ilgili olarak yukarıda verilenlerden hangileri zorunludur?","Aşağıdakilerden hangisi klimanın kullanım amaçlarından değildir?","Aşağıdakilerden hangisinin kendiliğinden oluşmuş burun kanamalarında yapılması yanlıştır?","Kaza yapan aracın ön ve arkasına, diğer araç sürücülerini yavaşlatmak ve olası bir kaza tehlikesini önlemek için aşağıdakilerden hangisi yerleştirilmelidir?"};
    String[] soru17cevap1 ={"15","Direksiyon kilitlenir","Karşısındaki kişiye saygı duyarak varlığını kabul etmek","Ada etrafında dönerken gereksiz yere şerit değiştirmek","Göz bebeklerinin büyüyüp sabitlenmesi","Radyatörün su sızdırması","I, II ve III","Yakıt tüketiminin azaltılması","Çeneyi göğüsten uzaklaştırarak başın geriye çekilmesi","Üçgen reflektör"};
    String[] soru17yanlis1 ={"5","Sürüş kolaylaşır","Empati kurmaktan kaçınmak","Sağa ve sola dönüş kurallarına uymak","Solunumun sık ve yüzeysel olması","Debriyajın kaçırması","Yalnız I","Araç içi nem oranının ayarlanması","Temiz bir bez ile yapılan tamponun burna yerleştirilmesi","Yangın tüpü"};
    String[] soru17yanlis2 ={"10","Akü tam şarj olur.","Dinlemeyi etkin şekilde yapmamak","Orta adaya bitişik şeritten dönüşe geçmek","Kan basıncının artması","Isıtma bujilerinin arızalanması","II ve III","Hava sirkülasyonunun sağlanması","Burun üzerine ve enseye buz konulması","Beyaz renkte taş"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru18 ={"Aşağıdaki durumların hangisinde araç trafikten men edilir?","Kamu hizmeti yapan yolcu taşıtlarının yolcu veya hizmetlileri bindirmeleri, indirmeleri veya duraklamaları için yatay ve düşey işaretlerle belirlenmiş yere ne ad verilir?","Aşağıdakilerden hangisi ruhsal yapısı bozuk sürücü davranışlarındandır?","I- Araç üstü tavan bagajı kullanılması II- Tam gazdan ve ani hızlanmalardan kaçınılması III- Tavsiye edilen tip ve ebatlarda araç lastiği kullanılması Verilenlerden hangilerinin yapılması araçta yakıt tasarrufu sağlar?","Aşağıdakilerden hangisi vücudun tamamında faaliyet gösterir?","Aşağıdaki davranışlardan hangisi trafik adabına sahip bir sürücü için uygundur?","Fanlı soğutma sisteminde fanı çalıştıran parça aşağıdakilerden hangisidir?","Aşağıdaki durumların hangisinde kazazedeye baş-çene pozisyonu verilmesi uygundur?","Aşağıdakilerden hangisi, marşa basılıp motor çalıştığında sönmesi gerekir?","Yerleşim Yerinde = YY Yerleşim Yeri Dışında = YYD Kavşaklara kaç metre kala şerit değiştirmek yasaktır?"};
    String[] soru18cevap1 ={"Zorunlu mali sorumluluk sigortası yoksa","Durak","Kullandıkları her araçta geçiş üstünlüğünü kendilerine ait sanmak","II ve III","Dolaşım sistemi","Denetim korkusu olmadan emniyet kemerini takmak","Fan motoru","Solunum yolu tıkalı olan","Yağ lambasının","YY : 30, YYD : 150"};
    String[] soru18yanlis1 ={"Araç sahibi tarafından kullanılmıyorsa","Garaj","Başkalarının haklarına saygı göstermek","Yalnız I","Sindirim sistemi","Sürekli şerit değiştirerek araç kullanmak","Su pompası","Burun kanaması olan","El fren lambasının","YY : 50, YYD : 200"};
    String[] soru18yanlis2 ={"Sürücünün, sürücü belgesi yanında yoksa","Otopark","Kurallara uymakta özen göstermek"," I ve II","Boşaltım sistemi","Trafik polisi yoksa kırmızı ışıkta geçmek","Vantilatör kayışı","Bulantı ve kusması olan","Park lambasının","YY : 60, YYD : 250"};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru19 ={"• Doğrultu değiştirme manevralarını yanlış yapmak• Önde giden bir aracı güvenli ve yeterli mesafeden izlememekYukarıda verilenler, trafik kazalarında rol oynayan faktörlerin hangisinin içinde değerlendirilir?","Aşağıdakilerden hangisi yakıt enjeksiyon sisteminin parçasıdır?","Aşağıdakilerden hangisi egzoz gazından zehirlenen kişiye uygulanmaz?","• Solunum yolu açık tutulur.• Solunum ve dolaşım desteklenir.Yukarıda verilenlerin kazazedeye uygulanmasının amacı aşağıdakilerden hangisidir?","Diz ile kalça arasındaki kemikte kırık varsa dıştan uygulanacak atelin boyu ne kadar olmalıdır?","Aşağıdakilerden hangisi, yaralanmalarda uygulanan genel ilk yardım kurallarından biri değildir?","Şekildeki kara yolunda numaralandırılmış şeritlerden hangisi sadece geçme için kullanılır?","Şekildeki kavşakta 1 numaralı araç sağa, 2 numaralı araç ise sola dönüş yapmak istemektedir.Bu araçlarla ilgili olarak aşağıdakilerden hangileri doğrudur?I. Her iki araçta dar kavisle dönmelidir.II. 1 numaralı araç geniş, 2 numaralı araç dar kavisle dönmelidir.III. 1 numaralı araç dar, 2 numaralı araç geniş kavisle dönmelidir.","Aşağıdakilerden hangisinin periyodik bakımı yapılmadığında motorun içine giren hava akışı zorlaşır, motor çekişten düşer ve yakıt sarfiyatı artar?","Aracın gösterge panelinde bulunan şekildeki gösterge sürücüye neyi bildirir?"};
    String[] soru19cevap1 ={"Sürücü kusurları","Enjektör","Kusmasını sağlamak","Temel yaşam desteğinin sağlanması","Topuktan koltuk altına kadar","Yara üzerinin pamukla kapatılması","2","Yalnız III","Hava filtresi","Aracın hızını"};
    String[] soru19yanlis1 ={"Araç kusurları","Distribütör","Solunumu durmuşsa suni solunum yapmak","Çok sayıda yaralının olduğunun bildirilmesi","Dizden kalçaya kadar","Yara yerinin değerlendirilmesi","1","Yalnız I","Yağ filtresi","Motor sıcaklığını"};
    String[] soru19yanlis2 ={"Yaya kusurları","Karter","Sıcak tutmak","Trafik kazalarının azaltılması","Topuktan dize kadar","Kanamanın durdurulması","1 ve 3","Yalnız II","Yakıt filtresi","Yakıt miktarını"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru20 ={"Okul taşıtının arkasındaki “DUR” işaretinin yandığını gören sürücüler nasıl hareket etmelidir?","Beyin, insan vücudundaki hangi sistemin bir parçasıdır?","Marşa basılıp motor çalıştığında aşağıdakilerden hangisinin sönmesi gerekir?","İlk yardım çantasında bulunan malzemelerin ortak özelliği nedir?","Aşağıdakilerden hangisi güvenli sürücülüğü belirleyen kişilik özelliklerindendir?","Trafik kazasına karışan sürücü yaralanmamış ise aşağıdakilerden hangisini yapmak zorundadır?","Motorlu bisikletler otoyollarda asgari kaç km hızla gitmelidir?","Kazazedenin ağız bölgesine bir cam parçası ya da ayna yaklaştırarak buharlanıp buharlanmadığına bakılması Bak-DinleHisset yönteminde hangisinin bir göstergesidir?","Aşağıdakilerin hangisindeki arıza, farların yanmamasına sebep olur?","Aşağıdakilerden hangisi motora ilk hareketi verir?"};
    String[] soru20cevap1 ={"Okul taşıtını geçmemelidir.","Sinir sisteminin","Şarj lambası","Yaşam kurtarmada kullanılırlar.","Trafik ortamındaki riskleri en aza indirecek biçimde davranma becerisi","Işıklı işaret veya yansıtıcı cihazları koymak","Giremez","Bak ","Far anahtarındaki","Marş motoru"};
    String[] soru20yanlis1 ={"Dikkatli ve yavaş geçmelidir.","Hareket sisteminin","Park lambası","Aynı maddeden yapılmışlardır.","Dikkat ve konsantrasyon bozucu davranışlara açık olma eğilimi","Akan trafiği kontrol etmek","40","Dinle","Bujilerdeki","Konjektör "};
    String[] soru20yanlis2 ={"Diğer sürücüleri uyarmalıdır.","Sindirim sisteminin","Sinyal lambası","İlk yardım dışındaki amaçlarda da kullanılabilecek genel malzemelerdir.","Kızgın ve yarışmacı motivasyon ile araç kullanma isteği","Yolu hemen trafiğe açmak","60","Hisset ","Distribütördeki","Alternatör"};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru21 ={"Şekildeki trafik işaretlerinin anlamları sırasıyla hangi seçenekte doğru olarak verilmiştir?","Okul taşıtının arkasındaki DUR ışığı hangi hâllerde yakılır?","Okul taşıtlarında, öğrencilerin kolayca yetişebileceği camlar ve pencereler nasıl olmalıdır?","Aşağıdakilerden hangisi zehirlenmenin genel belirtilerinden değildir?","Aşağıdakilerden hangisi, kısmi tıkanıklık yaşayan kazazedeye yapılacak ilk yardım uygulamalarından biri değildir?","Aşağıdakilerden hangisi trafik adabına uymayan tavırlara örnek değildir?","Bacakta turnike uygulama bölgesi neresidir?","Şekildeki kontrolsüz kavşakta ilk geçiş hakkını hangi araç kullanmalıdır?","Aşağıdakilerden hangisi yakıt tüketiminin artmasında sürücüden kaynaklanan kusurdur?","Aşağıdakilerden hangisi kara yollarında yük veya yolcu taşımak amacıyla kullanılır?"};
    String[] soru21cevap1 ={"I. Taşıt trafiğine kapalı yol - II. Girişi olmayan yol","Sadece öğrenci indirip bindirirken","Sabit","İştah artması","Öksürmesi engellenir.","Karşıdan karşıya geçmeye çalışan kör bir kişiye trafiği tehlikeye düşürmeden yardım etmek.","Diz ile kalça arası","Kamyonet","Motorun gereksiz yere çalışır hâlde tutulması","Mesleki yeterlilik belgesi"};
    String[] soru21yanlis1 ={"I. Yol ver - II. Girişi olmayan yol","Sadece sisli, yağmurlu ve karlı havalarda","Açılıp kapanabilir","Baş ağrısı","Gevşemiş takma dişleri varsa çıkarılır.","Araçlar için yeşil ışık yanmasına rağmen yaya kırmızı ışıkta geçiyorsa aracı yavaşlatmaya gerek yoktur.","Ayak bileğinin üst kısmı","Traktör","Ön düzen ayarlarının bozuk olması","Zorunlu trafik sigorta belgesi"};
    String[] soru21yanlis2 ={"I. Dur - II. Taşıt trafiğine kapalı yol","Taşıtın fren lambaları arızalandığı zaman","Kolayca açılabilir","Solunum zorluğu","Morarma saptanırsa derhal girişimde bulunulur.","Yakın bir dostumuzu gördüğümüz zaman kornayla selam vermek doğrudur.","Ayak bileğinin alt kısmı","Otomobil","Lastik hava basınçlarının yetersiz olması","Tescil belgesi"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru22 ={"İlk yardımın ABC'si olarak kabul edilen uygulamalardan B neyi ifade etmektedir?","Sürücü belgesi olmayanların araç kullanarak trafiğe çıktıklarının tespiti hâlinde aşağıdakilerden hangisi uygulanır?","Otomobil, minibüs, kamyonet, otobüs,kamyon, çekici ve tehlikeli madde taşıyan araçların hepsinde bulundurulması zorunlu olan teçhizat aşağıdakilerden hangisidir?","Yapılan ölçüm sonucunda yasal sınırların üzerinde alkollü olarak araç kullandığı birinci defa tespit edilen sürücüye aşağıdaki işlemlerden hangisi uygulanır?","İki yönlü karayolunda karşıya geçecek yayaların aşağıdakilerden hangisini yapması yanlıştır?","Aşağıdaki hâllerin hangisinde sürücü araç kullanmaktan men edilir?","Bir sürücünün trafik içindeki istenmeyen durumlara öfkelenmesi ve bu öfkeyi belli etmesi yerine, hangi davranışı göstermesi hâlinde çok daha huzurlu bir trafik ortamı oluşur?","Aşağıdakilerden hangisi motora giren havayı temizler?","Aşağıdakilerden hangisi sürücülerde olması gereken davranışlardandır?","Kemikler, eklemler ve kaslar vücudumuzun hangi sistemini oluşturan yapılardandır?"};
    String[] soru22cevap1 ={"Solunumun değerlendirilmesini","İdari para cezası","Yangın söndürme cihazı"," Sürücü belgesi 6 ay süreyle geri alınır.","Önce sağ sonra sol tarafını kontrol etmesi","Uyuşturucu madde alarak araç kullanıyorsa","Hoşgörülü olması","Hava filtresi","Paylaşmayı bilmek ve saygılı olmak","Hareket sistemi"};
    String[] soru22yanlis1 ={"Vücut ısısının düşürülmesini","Ağır hapis cezası","Koruma başlığı","Sürücü belgesi 5 yıl süreyle geri alınır.","3 numaralı aracın izlediği şeridin yanlış olduğu","Yaya geçidini kullanması","Taşıma sınırının üstünde yolcu almışsa","Bencil davranması"," Kendini üstün görmek","Sindirim sistemi"};
    String[] soru22yanlis2 ={"Kan dolaşımının değerlendirilmesini","Aracı en sağ şeritten sürme cezası","Hız sınırlayıcı cihaz","Sadece para cezası verilir.","1 numaralı aracın izlediği şeridin yanlış olduğu","Alt ve üst geçitleri kullanması","Taşıma sınırının üstünde yük yüklemişse","Aşırı stres yapması","Kendi kendine kurallar koymak","Dolaşım sistemi"};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru23 ={"Şekildeki gibi bir kavşakta karşılaşan araçların geçiş hakkı sıralaması nasıl olmalıdır?","Aşağıdakilerden hangisi aküyü şarj eden parçadır?","Araçların güvenli bir şekilde yavaşlamasını, durmasını ve sabitlenmesini sağlayan sistem aşağıdakilerden hangisidir?","Sürüş sırasında aracın gösterge panelinde bulunan şekildeki ikaz ışığının yanması sürücüye neyi bildirir?","I- Sağa dönüş lambasını yakmalıII- Hızını azaltmalıIII- Dar bir kavisle dönmeliŞekildeki gibi sağa dönüş yapacak olan sürücü, yukarıdakilerden hangilerini yapmalıdır? ","Aşağıdakilerden hangisi aracı kullanmaya başlamadan önce yapılması gereken hazırlıklardan biri değildir?","Trafik zabıtası veya yetkililerce Kanunda ve yönetmelikte belirtilen hâllerde araçla ilgili belgelerin alınması ve aracın belirli bir yere çekilerek trafikten alıkonulmasına ne denir?","Baş, boyun ve gövde ekseninin korunmasına hangi yaralanmalarda daha çok dikkat edilmesi gerekir?","Geçilmekte olan araç sürücüsü aşağıdakilerden hangisini yapmalıdır?","Aşağıdakilerden hangisi yakıt sisteminin elemanıdır?"};
    String[] soru23cevap1 ={"1 - 2 - 3 - 4","Alternatör","Fren sistemi","Soğutma suyu sıcaklığının aşırı yükseldiğini","I, II ve III","Klimanın açılması","Trafikten men","Omurga yaralanmalarında","Bulunduğu şeridi izlemelidir.","Yakıt filtresi"};
    String[] soru23yanlis1 ={"1 - 2 - 4 - 3","Endüksiyon bobini","Marş sistemi","Şarj sisteminin çalışmadığını","Yalnız I ","Koltuğun ayarlanması","Trafik suçu","Karın yaralanmalarında","Önündeki aracı geçmeye çalışmalıdır.","Termostat"};
    String[] soru23yanlis2 ={"2 - 1 - 4 - 3","Marş motoru","Ateşleme sistemi","Yağ basıncının çok düştüğünü","I ve II","Aynaların ayarlanması","Trafik terörü","Bacak yaralanmalarında","Hızını arttırmalıdır.","Marş motoru"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru24 ={"Araçların muayene süresi dolmasa bile, aşağıdaki hâllerin hangisinden dolayı özel muayenesi zorunludur?","Belli bir görevi yapan farklı dokuların bir araya gelmesiyle oluşan vücut birimine ne ad verilir?","Aşağıdakilerden hangisi trafiğin çevreye verdiği zararları önlemeye yönelik davranışlardandır?","Aşağıdakilerden hangisi LPG’li motorların üstünlüklerindendir?","Araca römork bağlandığı zaman aşağıdakilerden hangisinin yapılması zorunludur?","Aşağıda verilen taşıtların hangisinde, sürücülerin koruma başlığı ve koruma gözlüğü, yolcuların ise koruma başlığı takması zorunludur?","I. Ambulans ekiplerince müdahaleler yapılması II. Olay yerinde, ilk yardımcı tarafından temel yaşam desteği yapılması III. Hastane acil servislerinde müdahale yapılması IV. Sağlık kuruluşuna haber verilmesi Hayat kurtarma zinciri halkalarının sıralaması hangi seçenekte doğru olarak verilmiştir?","Yaralının araçtan çıkarılması sırasında yapılan yanlışlıklar sonucu, omuriliğin zedelenmesi durumunda ne olabilir?","Aracını park ettikten sonra durduğu yerin diğer yol kullanıcıları açısından görme-görülme ya da manevra engeli oluşturup oluşturmadığını kontrol eden bir sürücünün bu davranışı trafikteki hangi değere uygundur?","Aracın elektrik sisteminde bulunan sigortalardan biri yanmış ise yerine takılacak olan yeni sigortanın amper değeri eskisine göre nasıl olmalıdır?"};
    String[] soru24cevap1 ={"Kazaya karışması sonucu yetkili görevli tarafından gerekli görüldüğünde","Organ","Kimyasal maddelerin ambalajlanarak taşınması","Çevreyi kirletme oranı daha düşüktür.","Römorkun elektrik sisteminin prize takılması","Motosikletlerde","IV - II - I - III","Vücudun bir bölümünde felç","Empati","Aynı"};
    String[] soru24yanlis1 ={"Sürücüsü veya işleticisi değiştiğinde","Hücre","Temiz olmayan yakıt kullanılması","Ek yapım maliyeti getirir.","Römorka yük konulması","Otobüslerde"," I - III - II - IV","Acıkma hissi","Tahammül","Daha büyük"};
    String[] soru24yanlis2 ={"Motoru bakımdan geçirildiğinde","Sistem","Hususi araçların kullanılmasına gayret edilmesi","Bagaj hacmini küçültür.","Römorkun farlarının yakılması","Minibüslerde","II - III - I - IV","Hazımsızlık","Beden dili","Daha küçük"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru25 ={"Egzoz susturucusu, yanmış gazların gürültüsünün azaltılmasında görev yapar. Buna göre araçlardaki egzoz susturucusu çıkarılırsa ne olması beklenir?","Araçta, yeni motorun alıştırılması (rodaj) döneminde aşağıdakilerden hangisine uyulmalıdır?","Şekle göre sürücünün aşağıdakilerden hangisini yapması yanlıştır?","Şekle göre aşağıdakilerden hangisi kesinlikle doğrudur?","Aracın gösterge panelinde şekildeki uyarı lambasının yanıyor olması neyi bildirir?","Yakıt içerisinde toz, su veya pislik varsa motor nasıl çalışır?","Aşağıdaki durumların hangisinde egzoz gazı daha fazla zarar verir?","I. Öz eleştiri yapabilmekII. Risk almaya meyilli olmakIII. Trafikte diğer araç sürücülerini taciz etmekIV. Hata yapan sürücüleri uygun bir dille uyarmakYukarıdakilerden hangileri güvenli sürüşü olumsuz yönde etkileyen kişilik özelliklerindendir?","Ticari amaçla şehirler arası yolda yük ve yolcu taşımacılığı yapan araç sürücüleri, 24 saatlik süre içinde devamlı olarak en fazla kaç saat araç kullanabilirler?","Şah damarına bası uygulanması aşağıdaki bölge kanamalarından hangisinde yapılır?"};
    String[] soru25cevap1 ={"Gürültü kirliliğinin artması","Fazla süratten kaçınılmalıdır.","Yayayı ikaz ederek beklemesini istemesi","1 numaralı motosiklet sürücüsünün geçme yasağına uymadığı","Lastik hava basıncının düşük olduğunu","Düzensiz, tekleyerek","Kapalı garaj içinde uzun süre çalıştırılan aracın egzoz gazına maruz kalındığında","II ve III.","4,5","Yüz bölgesinde olan kanamalarda"};
    String[] soru25yanlis1 ={"Motorun ısınarak stop etmesi","Ani duruş ve kalkış yapılmalıdır.","Yaya geçidine uygun mesafede durması","1 numaralı motosiklet sürücüsünün hız sınırını aştığı","Motor kaputunun tam kapanmadığını","Rölantide","Trafik ortamında kaldırımda beklenildiğinde","I ve IV.","5,5","Bacak bölgesinde olan kanamalarda"};
    String[] soru25yanlis2 ={"Gürültü kirliliğinin en aza inmesi","Sürekli sert ve ani fren yapılmalıdır.","Yayanın geçmesini beklemesi","2 numaralı araç sürücüsünün hız sınırını aştığı","Soğutma sıvısı sıcaklığının çok yükseldiğini","Yüksek devirde","Öndeki araç sürekli yakından takip edildiğinde","I, II ve III.","3,5","Karın bölgesinde olan kanamalarda"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru26 ={"Dokular üzerinde çekme etkisi ile meydana gelen yaralara ne ad verilir?","Trafik kazalarında ölümlerin % 80’i kafatası ve omurga yaralanmalarından olmaktadır. Bu yaralanmalarda bilinçli ilk yardım, sakatlıkları önler ve hayatı kurtarır. Buna göre, aşağıdakilerden hangisi kafatası ve omurga yaralanmalarında yapılması gereken ilk yardım uygulamalarındandır?","I- Deri soğuk ve nemlidir. II- Nabız düzenli ve dolgundur. III- Solunum yüzeysel ve hızlıdır. Verilen bulgulardan hangileri şok belirtisidir?","Aşağıdakilerden hangisi yeni motorun alıştırılması (rodaj) zamanında yapılması uygundur?","I- Yol durumu II- Hava koşulları III- Kişisel kullanım farkları Yukarıdakilerden hangileri, bir aracın periyodik bakımının daha erken yapılmasını gerektirebilecek sürüş koşullarındandır?","El freni teli kopmuş ise aşağıdakilerden hangisi olur?","Kazazedenin solunum yapıp yapmadığı bak-dinle-hisset yöntemiyle 5 saniye süre ile kontrol ediliyor. Aşağıdakilerden hangisi bu yönteme ait olarak ilk yardımcının yaptığı bir uygulama değildir?","Aşağıdakilerden hangisi dokunun tanımıdır?","Kontrolsüz demir yolu geçidine yaklaşan sürücülerin aşağıdakilerden hangisini yapması doğrudur?","Aşağıdakilerden hangisi ateşli havalede yapılan hatalı ilk yardım uygulamalarındandır?"};
    String[] soru26cevap1 ={"Parçalı yaralar","Baş-boyun-gövde ekseninin korunması","I ve III","Ani duruş ve kalkıştan kaçınmak","I, II ve III","El freni tutmaz.","Eli ile göğüs kafesi merkezine bası uygulaması","Vücudun canlılık fonksiyonlarını yerine getiren, aynı yapı ve görevdeki hücreler topluluğudur."," Uygun mesafede mutlaka durması","Karın ve göğüs bölgesi üzerine direkt olarak buz konulması"};
    String[] soru26yanlis1 ={"Delici yaralar","Kazazedenin yalnız bırakılması","Yalnız I","Uzun yolda aynı hızla devamlı gitmek","I ve II","Fren pedal boşluğu artar.","Yüzünü kazazedenin ağzına yaklaştırarak soluğu yanağında hissetmeye çalışması","Kanın vücudumuzda dolaşmasını sağlayan organlardır.","Hızlarını artırarak geçmesi","Kazazedenin giysilerinin çıkartılması"};
    String[] soru26yanlis2 ={"Kesik yaralar","Bilinci açıksa hareket etmesinin sağlanması","Yalnız II","Motoru yüksek devirde çalıştırmak","II ve III","Fren sistemi hava yapar.","Eli ile göğüs kafesi hareketlerini hissetmeye çalışması","Hücreleri oluşturan küçük organ topluluklarıdır.","Demir yolu çok hatlı ise yavaş geçmesi","Kazazedenin koltuk altlarına, kasıklarına, dirseklerin iç yüzü ve avuç içlerine ıslak bez yerleştirilmesi"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru27 ={"Şekildeki trafik kazası, aşağıdakilerden hangisine uyulmaması sonucu meydana gelmiş olabilir?","Şekildeki gibi ışıklı trafik işaret cihazında, sarı ve kırmızı ışığın birlikte yanması sürücüye aşağıdakilerden hangisini bildirir?","Donma vakalarında aşağıdaki ilk yardım uygulamalarından hangisinin yapılması doğrudur?","Kırmızı ışıklı trafik işaretinde veya yetkili memurun dur işaretinde geçme trafik kazalarında - - - - sayılan hâllerdendir.Verilen ifadede boş bırakılan yere aşağıdakilerden hangisi yazılmalıdır?","Boşaltıldığı ortamda çevre kirliliği meydana getirecek maddelere ne ad verilir?","Arıza nedeniyle yolda kalan araçların sürücüleri, tehlikeye meydan vermemek için aşağıdakilerden hangisini yapmalıdır?","Otobüs, kamyon, minibüs, kamyonet ve çekicilere bir yaş sonunda ve devamında kaç yılda bir muayene yaptırılması zorunludur?","Yaralıda boyun hasarı şüphesi varsa, araçtan nasıl çıkarılmalıdır?","Yay salınım süresini kısaltan parça aşağıdakilerden hangisidir?","I- Oturuş pozisyonu verilmesiII- Burun kanatlarının 5 dakika süre ile sıkılmasıIII- Çeneyi göğüsten uzaklaştırarak başın geriye çekilmesiBurun kanaması olan bir kazazedeye yukarıdaki uygulamalardan hangilerinin yapılması doğrudur?"};
    String[] soru27cevap1 ={"Kavşaklarda geçiş hakkına","Yolun trafiğe açılmak üzere olduğunu","Önce ılık sonra sıcak ortama alınması","asli kusur","Atık","Aracı yol dışına veya bankete çıkarıp işaretlemeli","1","Boynuna mutlaka boyunluk takılarak","Amortisör","I ve II"};
    String[] soru27yanlis1 ={"Öndeki aracı geçme kuralına","Yolda bakım çalışması olduğunu","Elektrikli battaniye ile ısıtılması","tali kusur","Kireç","Aracın vitesini boşa almalı","4","Baş-çene pozisyonu verilerek","Rotil","Yalnız I"};
    String[] soru27yanlis2 ={"Takip mesafesine","İleride hemzemin geçit bulunduğunu","Soba ve benzeri ısıtıcılara yaklaştırılması","yol kusuru","Yanıcı madde","Araçta gözcü bulundurmalı","2","Ayaklarından çekilerek","Aks","II ve III"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru28 ={"Duyu organlarının hiçbir uyarana tepki veremeyecek şekilde fonksiyonlarını yitirmesiyle beliren uzun süreli bilinç kaybı hâli aşağıdakilerden hangisidir?","Seyir hâlindeyken araçtan yanık kablo kokusu alınırsa aşağıdakilerden hangisi yapılır?","Sürücünün aşağıdakilerden hangisini yapması kural ihlali sayılır?","Aşağıdaki yerlerden hangisinde duraklama yapılması yasak değildir?","Araçların bir mülke girip çıkması için yapılmış olan yolun, kara yoluna bağlanan ve kara yolu sınır çizgisi içinde kalan kısmına ne ad verilir?","I- Motosikletinde aşınmış lastik kullanması II- Seyir hâlinde iken koruma başlığı ve koruma gözlüğü kullanması III- Motosikletine aldığı yolcuya koruma başlığı takması Yukarıdakilerden hangileri güvenilir motosiklet sürücüsünün özelliklerindendir?","I- Şiddetli kafa travması geçirdiğinin II- Omurilik zedelenmesi olabileceğinin III- Göğüs zedelenmesi geçirdiğinin Kazazedenin burnundan ve kulağından kan ile birlikte sıvı gelmesi aşağıdakilerden hangilerinin göstergesidir? ","• İlk yardımcı sol kolu ile omzundan tutarak kazazedeyi oturur duruma getirir.• Çömelerek sağ kolunu kazazedenin bacaklarının arasından geçirir.• Kazazedenin vücudunu sağ omzuna alır.• Sol el ile kazazedenin sağ elini tutar, ağırlığı dizlerine vererek kalkar.• Kazazedenin önde boşta kalan bileğini kavrayarak kazazedeyi hızla olay yerinden uzaklaştırır. Yukarıda uygulama basamakları verilen acil taşıma tekniği hangisidir?","Trafik içinde hatalı davranış sergileyen bir sürücüyü uyarmak aşağıdakilerden hangisini azaltır?,Düşene sırtın dönen korksun,bir gün kendi düştüğünde, kimse ona elini uzatmayacaktır.(Sadi, Orkide) Yukarıdaki ifadede trafik adabının hangi yönü üzerine söylenmiş olabilir?"};
    String[] soru28cevap1 ={"Koma","Durulur, kontak kapatılır ve akü bağlantısı çıkarılır","Geçme, dönme gibi mecburi hâller dışında şerit değiştirmesi","Duraklara 30 metre mesafede","Geçiş yolu","II ve III","I - II","İtfaiyeci yöntemi ile omuzda taşıma","Sürücünün kaza yapma riskini","Yardımlaşma"};
    String[] soru28yanlis1 ={"Şok","Yakıt seviyesi kontrol edilir","Aracın cinsine ve hızına uygun olan şeridi kullanması","Sol şeritte","Şerit","Yalnız I","II - III","Koltuk altından tutarak sürükleme","Trafikteki araç sayısını","İletişim"};
    String[] soru28yanlis2 ={"Bayılma","Önemsenmez, devam edilir.","Üç şeritli ve iki yönlü yollarda sağ şeritten gitmesi","Dönemeçlerde","Banket","I ve II","I - III","Ayak bileklerinden sürükleme","Yayaların yaya geçidini kullanma oranlarını","Sorumluluk"};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru29 ={" I- Korkutmak veya şaşırtmak II- Su, çamur ve benzerlerini sıçratmak, atmak ve dökmek III- Keyfi davranışlarda bulunmak suretiyle yaya veya araç trafiğini tehlikeye düşürmek Sürücülerin yukarıdaki davranışlarından hangileri, kişilere zarar verecek tedbirsiz ve saygısız davranışlar kapsamına girer?","I- Araçların tescil edilmesiII- Sürücü belgelerinin verilmesi III- Trafik suçlarında tutanak düzenlenmesi Yukarıdakilerden hangileri Emniyet Genel Müdürlüğünün sorumlulukları arasında yer alır?","Şekildeki kavşakta; ileriye yeşil, sola kırmızı ve sağa yeşil oklu ışık yanmaktadır.Buna göre hangi numaralı şeritteki araçlar yollarına devam edebilir?","Şekildeki durumda sürücünün hangisini yapması zorunludur?","Bir araç çevreyi rahatsız edecek şekilde duman ve gürültü çıkarıyorsa aşağıdakilerden hangisi uygulanır?","Marşa basıldığında motor dönüyor ancak çalışmıyorsa ilk olarak aşağıdakilerden hangisi kontrol edilmelidir?","Kamyon, kamyonet ve römorklarda yükle birlikte yolcu taşınırken aşağıdakilerden hangisinin yapılması yasaktır?","I- Motor soğutma suyunun eksilmesiII- Devridaim pompası kayışının kopmasıIII- Radyatör üzerinde bulunan fan motorunun arızalanmasıVerilenlerden hangileri motorun hararet yapma sebebidir?","Aşağıdakilerden hangisi ilk yardımın öncelikli amaçlarındandır?","Aksine bir işaret yoksa şekildeki araç için yerleşim yeri dışındaki bölünmüş yollarda azami hız sınırı saatte kaç kilometredir?"};
    String[] soru29cevap1 ={"I - II - III","I, II ve III","2 ve 3","Uygun mesafede mutlaka durması","İhtar edilir, tekrarı halinde araç trafikten men edilir.","Depodaki yakıt seviyesi","Yolcuların yüklerin üzerine oturtulması","I, II ve III","Yaşamsal fonksiyonların sürdürülmesini sağlamak","110"};
    String[] soru29yanlis1 ={"II - III","Yalnız I","1 ve 2","Sola dönecekse, durmadan seyrini sürdürmesi","Sürücüsüne hapis cezası verilir.","Bujiler","Kasanın yan ve arka kapaklarının kapatılması"," I ve II","Trafikteki kaza sayısını azaltmak","90"};
    String[] soru29yanlis2 ={" I - II","I ve II","1 ve 3","Sağa dönecekse, durmadan seyrini sürdürmesi","Araç sahibine sadece para cezası verilir.","Akü suyu","Yüklerin bağlanması","II ve III","Sağlık personelinin mesleki başarısını artırmak","100"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru30 ={"B sınıfı sürücü belgesine sahip bir sürücünün kullanabileceği diğer sürücü belgesi sınıfı aşağıdakilerden hangisidir?","Güneş çarpması olan kişiye aşağıdaki uygulamalardan hangisi yapılmalıdır?","Kişinin çevre ile bağlantısının tamamen kesildiği, uyaranlara cevap veremediği uzun süreli ve derin bilinç kaybına ne denir?","Aşağıdakilerden hangisi sürücüden kaynaklanan trafik kazası sebebidir?","B sınıfı sürücü belgesine sahip bir sürücünün kullanabileceği diğer sürücü belgesi sınıfı aşağıdakilerden hangisidir?","Aşağıdakilerden hangisi fazla yakıt tüketimine sebep olur ?","Aşağıdakilerden hangisi lastiklerin aşırı şişirilmesi sonucunda oluşabilir?","Aksine bir işaret bulunmadıkça aşağıdaki araçlardan hangisinin yerleşim yeri dışındaki bölünmüş yollarda azami hızı saatte  85 kilometredir?","Aşağıdakilerden hangisi, yan yatış pozisyonuna alınarak taşınabilir?","Yaralıda boyun hasarı şüphesi varsa, araçtan nasıl çıkarılmalıdır?"};
    String[] soru30cevap1 ={"F","Serin bir yere alınarak vücut ısısı düşürülmeli","Koma","Alkollü  olarak araç kullanması","M","Hava filtresinin tıkalı olması","Sürüş konforunun azalması","Kamyon","Besin zehirlenmesi olanlar","Boynuna mutlaka boyunluk takılarak"};
    String[] soru30yanlis1 ={"A2","Üstü örtülerek terlemesi sağlanmalı","Hâlsizlik","Yol yapımında hata olması","A2","Yakıt borularının uzunluğu","Bijon somunlarının gevşemesi","Motosiklet","Göğüs kemiğinde kırık olanlar","Ayaklarından çekilerek"};
    String[] soru30yanlis2 ={"E","Sıcak içecekler verilmeli","Bayılma","Aracın bakımsız olması","E","Yağ filtresinin tıkalı olması","Fren hidroliğinin azalması","Otomobil","Kalça kemiğinde kırık olanlar","Baş-çene pozisyonu verilerek"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru31 = {"Bayılan hastaya ilk yardım olarak aşağıdakilerden hangisi uygulanmaz?","Aksine bir işaret yoksa, şekildeki aracın sürücüsü, iki yönlü dört veya daha fazla şeritli yollarda; geçme ve dönme dışında, aşağıdakilerden hangisinde seyretmek zorundadır? ","Yakıttan elde ettiği ısı enerjisini mekanik enerjiye çeviren makinelere ne denir?","Aşağıdakilerden hangisi göğüs yaralanması olan kazazedeye uygulanmaz?","Ticari amaçla şehirler arası yolda yük ve yolcu taşımacılığı yapan şoförlerin 4,5 saat devamlı araç kullandıktan sonra en az kaç dakika dinlenmeleri gerekir?","Taşıt yolu üzerine çizilen şekildeki sembolün anlamı nedir?","Son ihlalin gerçekleştiği tarihten itibaren geriye doğru 5 yıl içinde yasal sınırların üzerinde alkollü olarak araç kullandığı üçüncü defa tespit edilen sürücünün, sürücü belgesi ne kadar süre ile geri alınır?","Aşağıdakilerden hangisi Karayolları Trafik Kanunu’na göre sürücü olabilmenin şartlarından biri değildir?","Şekildeki gibi yeterince aydınlatılmamış tünele giriş yapan aracın sürücüsü, aşağıdakilerden hangisini yapmak zorundadır?","Aşağıdaki taşıtların hangisinde takograf cihazının bulundurulması zorunlu değildir?"};
    String[] soru31cevap1 ={"Soğuk içecekler içirmek","En sağ şeritte","Motor","Ayakları yüksekte tutup sırtüstü yatırmak","45","Bisiklet yolu","5 yıl","Bir meslek sahibi olmak","Uzağı gösteren ışıkları yakmak","Otomobil"};
    String[] soru31yanlis1 ={"Şok pozisyonu vermek","Orta şeritte","Dinamo","Batan cisim varsa çıkarmamak","25","Motosiklet yolu","2 yıl","Belirli bir eğitim seviyesine sahip olmak","Duraklamak","Çekici"};
    String[] soru31yanlis2 ={"Duyu organlarını uyarmak","Bankette","Vites kutusu","Yarı oturur duruma getirmek","35","Bisiklet giremez","1 yıl","Kullanacağı araca göre belirli bir yaşın üzerinde olmak","Araç içi ışıkları yakmak","Otobüs"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String[] soru32 ={"• Güvenli, ekonomik ve sorunsuz bir sürüş• Hava kirliliğinin azaltılmasına katkı sağlama Bir motorlu araçtan yukarıda verilen kriterleri hangi durumda gerçekleştirmesi beklenir?","Aşağıdakilerden hangisi bir insana yakışmayan tavırlara örnektir?","Geri vites lambalarından biri parlak diğeri sönük yanıyorsa sebebi aşağıdakilerden hangisidir?","Aşağıdaki işlemlerden hangisi trafiğe çıkacak araçların mevzuata uygunluğunu gösterir?","Egzoz susturucusu, yanmış gazların gürültüsünün azaltılmasında görev yapar. Buna göre araçlardaki egzoz susturucusu çıkarılırsa ne olması beklenir?","Aşağıdakilerden hangisi atardamar kanamalarına ait bir özelliktir?","Aşağıdakilerden hangisi, yaralı taşımalarında ilk yardımcının uyması gereken kurallardan biri değildir?","Yaya yolu bulunmayan kara yollarında, yayaların aşağıdakilerden hangisinde yürümesi zorunludur?","Düz yolda belli bir hızdan sonra araçta titreşimler oluşursa muhtemel arıza ne olabilir?","I- Alkol veya madde bağımlılığı II- Eğitim eksikliği ve tedbirsizlik III- Tehlikeye atılmaya hazır kişilik yapısı Yukarıdakilerden hangileri kazalara yol açan faktörlerdendir?"};
    String[] soru32cevap1 ={"Kontrol ve bakımı doğru şekilde yapıldığında","Işık kırmızıdan yeşile döndüğü anda korna veya selektörle hemen uyarıda bulunmak","Lamba bağlantısında oksitlenme vardır.","Kayıt ve tescilinin onaylanması","Gürültü kirliliğinin artması","Açık kırmızı renkteki kanın, kalp atımı ile eş zamanlı fışkırır tarzda akması","Kazazedeyi mümkün olduğunca çok hareket ettirmesi","Gidiş yönüne göre sol bankette","Lastiklerde balanssızlık vardır."," I, II ve III"};
    String[] soru32yanlis1 ={"Sürekli olarak yüksek hızda kullanıldığında","Otoyollarda aniden trafik sıkıştığında arkadaki sürücüleri uyarmak için dörtlüleri çalıştırmak.","Flaşör arızalıdır.","Araç üzerinde keyfi değişiklik yapılması","Motorun ısınarak stop etmesi","Küçük kabarcıklar şeklinde kanama olması","Başını her zaman düz tutması","Trafiğin yoğun olmadığı şeritte","Eksantrik milinde balanssızlık vardır.","Yalnız I"};
    String[] soru32yanlis2 ={"Çok ıslak ya da tozlu ortamda çalıştırıldığında","Trafik ortamında karşı tarafın hatalarını tolere edebilecek şekilde araç kullanmak.","Akü gerilimi düşüktür.","Periyodik bakım kartının doldurulması","Gürültü kirliliğinin en aza inmesi","Yüzeysel bir yaradan yayılarak, yavaş akması","Yavaş ve düzgün adımlarla yürümesi","Gidiş yönüne göre sağ bankette","Alternatörde balanssızlık vardır.","II ve III"};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String[] soru33 ={"Aşağıdakilerden hangisi yakıt sisteminin elemanıdır?","Aşağıdakilerden hangisi motorun parçası değildir? ","Aşağıdakilerden hangisi silindir bloğunun görevidir?","Kalp atımlarının atardamar duvarına yaptığı basıncın, damar duvarında parmak uçlarıyla hissedilmesine ne denir?","Aşağıdakilerden hangisi, yaralı taşımalarında ilk yardımcının uyması gereken kurallardan biri değildir?","Park hâlindeki araca çarpan sürücünün aşağıdakilerden hangisini yapması yanlıştır?","Şekle göre araçların ışıksız bir kavşakta karşılaşmaları hâlinde ilk geçiş hakkını hangisi kullanmalıdır?","Sürücünün trafik ortamında yaptığı davranışlardan hangisi, diğer sürücülerin dikkatinin dağılmasına ya da paniğe kapılmalarına sebep olabilir?","Kara Yolları Trafik Kanununa göre “M,A1, A2, A, B1, B, BE, F ve G” sınıfı sürücü belgeleri kaç yıl süreyle geçerlidir?","Aşağıdakilerden hangisi delici göğüs yaralanmalarında kazazedeye yapılan doğru bir ilk yardım uygulamasıdır?"};
    String[] soru33cevap1 ={"Yakıt filtresi","Rot","Pistonlara yataklık yapmak","Nabız","Kazazedeyi mümkün olduğunca çok hareket ettirmesi","Zarar fazla değilse olay yerinden uzaklaşması","2 nolu araç","Sürekli şerit değiştirerek (slalom yaparak) araç kullanması","10","Bilinci açık ise yarı oturur duruma getirilmesi"};
    String[] soru33yanlis1 ={"Termostat","Krank mili","Şafta hareket vermek","Solunum","Başını her zaman düz tutması","Aracın sahibini bulamaz ise yazılı bilgi bırakması","1 nolu araç","Davranışlarının sonuçlarını düşünerek hareket etmesi","15","Ayaklarının yüksekte tutulup yüzüstü yatırılması"};
    String[] soru33yanlis2 ={"Marş motoru","Piston","Rotlara hareket vermek","Vücut ısısı","Yavaş ve düzgün adımlarla yürümesi","Zarar verdiği aracın sahibini bulması","Hızı fazla olan araç","Aracını kullanırken trafik kurallarının bilincinde olması","20","Ağızdan ılık içecekler verilmesi"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String[] soru34 ={"Aşağıdakilerden hangisi çıkıklarda yapılan ilk yardım uygulamalarındandır?","Trafik işaret levhaları ile belirlenmiş yaya ve okul geçitlerine yaklaşan sürücülerin aşağıdakilerden hangisini yapmaları yanlıştır?","Aşağıdakilerden hangisi silindire giren havayı temizler?","Aşağıdakilerden hangisi yakıt tüketiminin artmasında sürücüden kaynaklanan kusurdur?","Turnike uygulamasında ilk bir saat içinde, kaç dakikada bir boğucu sargı gevşetilmelidir?","Direksiyon döndürme kuvvetini azaltarak sürücüye daha kolay bir şekilde aracı yönlendirme imkânı veren sistem aşağıdakilerden hangisidir?","I. Maddi hasar tespiti yapmak II. Olayı en yakın zabıta veya sağlık kuruluşuna bildirmek III. Kaza yerinde usulüne uygun ilk yardım tedbirlerini almak IV. Yetkililerin isteği hâlinde yaralıları en yakın sağlık kuruluşuna götürmek Kazaya karışan veya olay yerinden geçmekte olan kişiler yukarıdakilerden hangilerini yapmakla yükümlüdürler?","Römork veya yarı römorkları çekmek için imal edilmiş olan ve yük taşımayan motorlu araca ne denir?","Aksine bir işaret bulunmadıkça yerleşim yeri dışındaki bölünmüş yollarda otomobiller için azami hız saatte kaç kilometredir?","Araç sürücülerinin duraklanan veya parke dilen yerden çıkarken; I. Işıkla veya kolla çıkış işareti vermeleri, II. Araçlarını ve araçların etrafını kontrol etmeleri, III. Yoldan geçen araçları ikaz ederek durdurmaları, IV. Görüş alanları dışında kalan yerler varsa gözcü bulundurmaları mecburidir. Verilen bilgilerden hangileri doğrudur?"};
    String[] soru34cevap1 ={"Çıkığın alt bölgesindeki deri rengi, ısı ve nabzın kontrol edilmesi","Hızlarını artırmaları","Hava filtresi","Aracın hızına uygun olmayan viteste gidilmesi","15-20 dakika","Hidrolik direksiyon","II, III ve IV.","Çekici","110","I, II ve IV."};
    String[] soru34yanlis1 ={"Çıkığın yerine oturtulmaya çalışılması","Yavaşlamaları","Benzin filtresi","Bujilerin arızalı ve ayarsız olması","1-2 dakika","Hidrolik fren","Yalnız III","Kamyon","130","I ve III"};
    String[] soru34yanlis2 ={"Kazazedenin hareket ettirilmesi","Yayalara ilk geçiş hakkını vermeleri","Yağ filtresi","Rölanti ayarının bozulması","5-10 dakika","Hava yastığı","I, II ve IV.","Treyler","100","II, III ve IV."};

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru35 ={"İçten yanmalı motorlar hangi enerjiyi mekanik enerjiye dönüştürür?","Hava filtresinin kirli olması motorun çalışmasını nasıl etkiler?","Aşağıdakilerden hangisi motorun hararet yapmasına sebep olur?","Bir kavşakta geçiş üstünlüğüne sahip aracın sesli ve ışıklı uyarısını alan sürücü nasıl hareket etmelidir?","Dizel motorlarda yakıtın ateşlenmesi nasıl olur?","Yerleşim yeri içinde, trafik işaret levhalarına yaklaşım yönünde kaç metre mesafede duraklamak yasaktır?","Geçiş üstünlüğüne sahip araç sürücüsü bu hakkı kullanırken aşağıdakilerden hangisine dikkat etmek zorundadır?","Aşağıdakilerden hangisi kazazedenin taşınmasında uyulması gereken genel kurallardandır?","I. Kazazedenin sert bir zemin üzerine sırt üstü yatırılması II. Kalp basısı uygulamak için göğüs kemiğinin alt ve üst ucunun tespit edilmesi III. Göğüs kemiğine, yandan bakıldığında göğüs yüksekliğinin 1/2'si kadar aşağı inecek şekilde kalp basısı uygulanması Yukarıdakilerden hangileri, yetişkinlerde yapılan temel yaşam desteğinin uygulama basamaklarındandır?","Aşağıdakilerden hangisi burkulma belirtilerinden biri değildir?"};
    String[] soru35cevap1 ={"Isı enerjisini","Yakıt sarfiyatını artırır.","Motor soğutma suyunun eksilmesi","Derhal kavşağı boşaltarak yol vermeli","Sıkıştırılan havanın sıcaklığı ile","15","Can ve mal güvenliğini tehlikeye sokmamaya","Kazazedenin baş-boyun-gövde ekseni esas alınarak en az 6 destek noktasından kavranması","I ve II","Hareket ile azalan ağrı"};
    String[] soru35yanlis1 = {"Hidrolik enerjiyi","Motorun gücü artar.","Fren hidroliğinin eksilmesi","Olduğu yerde hemen durmalı","Buji kıvılcımı ile","20","Hız sınırlamasına","İlk yardımcının kendi sağlığını riske sokması","Yalnız I","Şişlik"};
    String[] soru35yanlis2 ={"Nükleer enerjiyi","Motor yağ eksiltir.","Araç deposundaki yakıtın az olması","Işıklı trafik işaretine uymalı","Elektrik motoru ile","30","Trafik yasaklarına","İlk yardımcının kalkarken ağırlığı karın kaslarına vermesi","II ve III","Kızarma"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru36 ={"Aşağıdakilerden hangisi çevre kirliliğini önleme açısından olumlu bir davranıştır?","Aşağıdakilerden hangisi sürücüye uygun davranışlardandır?","Aracın hareketi için gerekli gücü sağlayan aşağıdakilerden hangisidir?","Hangisi yakıt sisteminin elemanıdır?","Boyun kırıklarında, yanlış taşıma ve gereksiz hareketler sonucu omurilik zedelenmesine bağlı olarak vücutta aşağıdakilerden hangisi meydana gelebilir?","Radyatörde suyun azalmasının sebebi aşağıdakilerden hangisidir?","Yetişkinlerde temel yaşam desteği uygulaması ile ilgili olarak verilenlerden hangisi doğrudur?","Aracın hararet göstergesi çalışmıyorsa aşağıdakilerden hangisi meydana gelmiş olabilir?","Araçta, aşağıdakilerden hangisinin kullanılması yağışlı havalarda kaza riskini artırır?","Hayatın kurtarılması amacıyla olay yerindeki kazazedeye, tıbbi araç gereç aranmaksızın mevcut araç gereçlerle ilaçsız uygulamaları yapan eğitim almış kişiye ne ad verilir?"};
    String[] soru36cevap1 ={"Bakım sırasında çıkan eski parça ve malzemelerin çevreye bilinçsizce bırakılmaması","Yoldan geçerken gördüğü yaralanmalı bir kazayı hemen ilgili birimlere bildirmek","Motor","Yakıt deposu","Felç","Silindir kapak contasında kaçak vardır.","30 kalp masajı, 2 yapay solunum şeklinde uygulanması","Hararet müşürü arızalıdır.","Eski ve aşınmış lastikler","İlk yardımcı"};
    String[] soru36yanlis1 ={"İniş eğimli yollarda motorun durdurulması","Yolcuların isteğine göre araç kullanmak","Egzoz","Vantilatör","Saç dökülmesi","Termostat arızalıdır.","Göğüs kemiği 3 cm aşağı inecek şekilde bası yapılması","Vantilatör kayışı gevşektir.","Tam şarjlı akü","Sürücü"};
    String[] soru36yanlis2 = {"Taşıtlarda kalitesiz yakıtların kullanılması","Diğer sürücülerden önce kendi hakkını gözetmek","Fren","Kondansatör","Bulantı ve kusma","Vantilatör kayışı sıkıdır.","Temel yaşam desteğine yapay solunum ile başlanması","Vantilatör kayışı kopmuştur.","Uzun yakıt boruları","Girişimci"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru37 ={"Aşağıdakilerden hangisi geçiş üstünlüğüne sahip araçlardandır?","Okul taşıtlarında, öğrencilerin kolayca yetişebileceği camlar ve pencereler nasıl olmalıdır?","Kara yollarında meydana gelen trafik kazaları ile ilgili olarak, kazaya karışan veya olay yerinden geçmekte olan sürücünün yasal sorumluluğu nedir?","Aşağıdakilerden hangisi şok belirtilerinden biri değildir?","I. Şarj II. ABS III. Yağ basıncı Verilen ikaz lambalarından hangilerinin araç gösterge panelinde yanması aracın derhal durdurulmasını ve kontağın kapatılmasını gerektirir?","Aşağıdakilerden hangisi, kazalardaki ölümler ve sakat kalmaların en büyük nedenlerindendir?","Aşağıdakilerden hangisinin geçiş üstünlüğü yoktur?","Aşağıdakilerden hangisi, araç geçmede uyulması gereken kurallardan biri değildir?","Yaralının taşınmasında ilk yardımcı kendi sağlığını riske sokmamalıdır. Gereksiz zorlama ve yaralanmalara engel olmak için kurallara uygun davranmalıdır. Buna göre aşağıdakilerden hangisi yaralının taşınması sırasında ilk yardımcının uyması gereken genel kurallardandır?","Aşağıdakilerden hangisi şok belirtilerindendir?"};
    String[] soru37cevap1 ={"İtfaiye aracı","Sabit","Her durumda müdahale etmekle yükümlüdür.","Bilinç seviyesinin artması"," I ve III.","İlk yardımın zamanında ve tekniğine uygun yapılmaması","Toplu taşıma araçlarının","Öndeki aracın işaretini beklemek","Daha uzun ve kuvvetli kas gruplarını kullanması","Kan basıncının düşmesi"};
    String[] soru37yanlis1 ={"Motosiklet","Açılıp kapanabilir","Sadece olaya karışan sürücülerin müdahale etme mecburiyeti vardır.","Kan basıncının düşmesi","I ve II.","Tekrar kaza olma riskinin ortadan kaldırılması","Sanık veya suçlu takip eden araçların","Başka araç tarafından geçilmiyor olmak","Yaralıya uzak mesafede çalışması","Nabız atışının güçlü olması"};
    String[] soru37yanlis2 ={"Tarım traktörü","Kolayca açılabilir","Sadece sağlık personeli olanların müdahale etme mecburiyeti vardır.","Cildin soğuk ve nemli olması","II ve III.","Hayati tehlike oluşturabilecek müdahalelerden kaçınılması","Cankurtaran ve yaralı taşıyan araçların","Karşı yönden gelen trafiği kontrol etmek","Ani dönme ve bükülmeler yaparak yön değiştirmesi","Cildin kuru ve sıcak olması"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    String[] soru38 ={"Aşağıdakilerden hangisi kılcal damar kanamasının özelliğidir?","Batan cisim yara üzerinde duruyorsa, aşağıdakilerden hangisi uygulanır?","Kırığı olan ya da kırık şüphesi bulunan kazazedeye, aşağıdakilerden hangisinin yapılması doğru bir ilk yardım uygulamasıdır?","I- Toplardamar kanamalarında, kan koyu renkli, yavaş ve sürekli akış hâlindedir. II- Atardamar kanamalarında, kan açık renkli ve kalp atımları ile uyumlu olarak kesik kesik akar. Yukarıda kanamalarla ilgili olarak verilenler için ne söylenebilir?","Emniyet Genel Müdürlüğünün yetki alanı dışındaki yerlerde, trafiğin düzenlenmesi ve denetlenmesini hangi kuruluş yerine getirir?","Araçlarda ilk yardım çantası bulundurulması konusunda aşağıdakilerden hangisi doğrudur?","Aşağıdakilerden hangisi silindir içinde sıkıştırılmış olan yakıt-hava karışımını elektrik kıvılcımı ile ateşler?","Aşağıdakilerden hangisi güvenli sürücülükiçin olumsuz etkiye neden olmaz?","Monoküler (tek gözü gören) kişiler, aşağıda verilen sürücü belgesi sınıflarından hangisini almak için başvuru yapabilir?","I. Ani hızlanmalar yapılması II. Araç lastiklerinin eskimesi III. Hava filtresinin değiştirilmesi Yukarıdakilerden hangileri yakıt tüketiminin artmasına neden olur?"};
    String[] soru38cevap1 ={"Sızıntı biçiminde ve hafif bir kanama olması","Çıkarılmadan yaralı hastaneye sevk edilir.","Sorunlu bölgenin hareketsizleştirilmesinin sağlanması","Her ikisi de doğru","Jandarma Genel Komutanlığı","Motorlu araçlarda (motorlu bisiklet, motosiklet ve traktör hariç) zorunludur.","Buji","Sakin olmak","B","I ve II."};
    String[] soru38yanlis1 = {"Koyu renkli ve taşma tarzında kan akması","Dışarıda kalan kısım kesilir ve yara sarılır.","Kol ya da bacaktaki bozulmuş şeklin düzeltilmeye çalışılması","Yalnız I doğru","İl Özel İdareleri","Sadece şehir içi taşımacılık yapan araçlarda zorunludur.","Distribütör","Öfke","C","I, II ve III."};
    String[] soru38yanlis2 ={"Yüksek basınçla akması ve zor durdurulabilmesi","Çıkarılır ve yaralı hastaneye sevk edilir.","Kırık kuşkulu bölge hareketsizleştirilmeden taşıma yapılması","Yalnız II doğru","Afet İşleri Genel Müdürlüğü","Sadece şehirler arası taşımacılık yapan araçlarda zorunludur.","Ateşleme bobini","Saldırgan sürücülük","D","II ve III."};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String[] soru39 ={"Taşıt yolunun karşı tarafına geçecek yayalar, aşağıdakilerden hangisini tercih etmelidirler?","Aşağıdakilerden hangisi, dizel motorlarda depodaki yakıtın bitmesi sonucunda meydana gelir?","Trafik kazasına karışan kişilerin tümü, yetkililerin gelmesini gerekli görmez ve anlaşırlarsa, durumu aralarında yazılı olarak tespit etmek suretiyle olay yerinden ayrılabilirler. Yukarıdaki ifade hangi tür kazalarda geçerlidir?","Bir trafik kazasında ilk yardım uygulamalarına ilk olarak nerede başlanmalıdır?","Hangi durumdaki yaralı kesinlikle sedye ile taşınmalıdır?","Şekildeki gibi bir kavşakta karşılaşan araçların geçiş önceliği sıralaması nasıl olmalıdır?","Akü başka akü ile takviye yapılacaksa kutup başları nasıl bağlanır?","I- Ağızdan burunaII- Silvester (Göğüsten bastırma)III- Holger-Nielsen (Sırttan bastırma)Ağız-burun çevresinde kanama olan yaralılarda solunum durması söz konusu ise, yukarıdaki suni solunum yöntemlerinden hangileri uygulanabilir?","Hangi temel değere sahip sürücü, yoğun trafikte bir dizi hâlinde gitmekte olan diğer sürücülerin önlerine geçip, trafiği daha da sıkışık hâle getirerek yoluna devam etmez?","Yaralanmaya bağlı meydana gelen dış kanamada ilk yardım olarak aşağıdakilerden hangisinin yapılması sakıncalıdır?"};
    String[] soru39cevap1 ={"Yaya geçitlerini","Yakıt sisteminin hava yapması","Maddi hasarlı kazalarda","Olay yerinde","Omurga kırığı olan","2 - 3 - 1","Artı kutup, artı kutupla; eksi kutup, eksi kutupla","II ve III","Empati düzeyi yüksek","Yara bölgesine sıcak uygulama yapılması"};
    String[] soru39yanlis1 ={"Banketleri","Yakıt deposunun delinmesi","Yaralanmalı kazalarda","Hastanede","1. derece yanığı olan","1 - 2 - 3","Eksi kutup, artı kutupla; artı kutup, eksi kutupla","Yalnız I","Görgü seviyesi düşük","Kanama bölgesine kan taşıyan ana damarlara baskı uygulanması"};
    String[] soru39yanlis2 ={"Geçiş yollarını","Hava filtresinin kirlenmesi","Ölümlü kazalarda","Ambulans içinde","Kaburga kırığı olan","3 - 2 - 1","Eksi kutup şasi ile","I ve II","Sorumsuz","Kanayan yer üzerine temiz bir bezle bastırılması"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////




    Runnable runnable1;
    Handler handler1;
    int soruyanlis = 0;
    int sorudogru = 0;
    Button button1,button2,button3;

    TextView textsoru,sure ,sorusayisi;

    String cevap1,cevap2,cevap3,dogru,s1,s2,s3,bolum;

    Soru soru;

    int sorusay = 0;

    int sorusay1 = 0;

    int toplamci = 50;
    int kacsoru = 0;

    int run =0;
    SQLiteDatabase database;

    SharedPreferences sharedPreferences;
    ImageView imageView1;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru50ana);
    MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-9283206876818854/8125117933", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
        sharedPreferences = this.getSharedPreferences("com.ehliyet.kolayehliyet", MODE_PRIVATE);
        bolum = sharedPreferences.getString("secim1","yok");
        database = this.openOrCreateDatabase("data",MODE_PRIVATE,null);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        textsoru = findViewById(R.id.textView);
        imageView1 = findViewById(R.id.resim);
        sure = findViewById(R.id.textView7);
        sorusayisi = findViewById(R.id.textView2);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        sorusayisi.setTypeface(typeface);
        new CountDownTimer(2700000, 1000) {
            @Override
            public void onTick(long l) {
            sure.setText(""+l/1000+" SN");
            }

            @Override
            public void onFinish() {
                ShowDialogBox();
                Toast.makeText(Soru50ana.this, "Süre Bitmiştir.", Toast.LENGTH_SHORT).show();
            }
        }.start();
        if (sorusay == 0) {
            sorudegistir();
            sorudegis();
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cevap1 = button1.getText().toString();
                dogru = soru.cevap;
                if (Objects.equals(dogru, cevap1)) {
                    sorudogru++;
                    dogruc();
                } else {
                    button1.setBackgroundResource(R.drawable.y);
                    dogruc();
                    soruyanlis++;
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cevap2 = button2.getText().toString();
                dogru = soru.cevap;
                if (Objects.equals(dogru, cevap2)) {
                    sorudogru++;
                    dogruc();
                } else {
                    button2.setBackgroundResource(R.drawable.y);
                    dogruc();
                    soruyanlis++;
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cevap3 = button3.getText().toString();
                dogru = soru.cevap;
                if (Objects.equals(dogru, cevap3)) {
                    sorudogru++;
                    dogruc();
                }else {
                    button3.setBackgroundResource(R.drawable.y);
                    dogruc();
                    soruyanlis++;
                }
            }
        });


    }
    public void sorudegistir(){
        kacsoru++;
        if (sorusay == 50){
            if (mInterstitialAd != null) {
                mInterstitialAd.show(Soru50ana.this);
            }
            ShowDialogBox();
            database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm1'");
            database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm1'");
            database.execSQL("UPDATE A SET toplam=toplam+" + toplamci + " WHERE bolum='A1bölüm1'");
            if (bolum.equals("1. BÖLÜM1")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("1. BÖLÜM501s1yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("1. BÖLÜM501s1yildiz", "1").apply();
                }
            }if (bolum.equals("1. BÖLÜM2")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("1. BÖLÜM502s2yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("1. BÖLÜM502s2yildiz", "1").apply();
                }
            }if (bolum.equals("1. BÖLÜM3")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("1. BÖLÜM503s3yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("1. BÖLÜM503s3yildiz", "1").apply();
                }
            }
            if (bolum.equals("2. BÖLÜM1")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("2. BÖLÜM501s1yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("2. BÖLÜM501s1yildiz", "1").apply();
                }
            }if (bolum.equals("2. BÖLÜM2")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("2. BÖLÜM502s2yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("2. BÖLÜM502s2yildiz", "1").apply();
                }
            }if (bolum.equals("2. BÖLÜM3")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("2. BÖLÜM503s3yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("2. BÖLÜM503s3yildiz", "1").apply();
                }
            }if (bolum.equals("3. BÖLÜM1")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("3. BÖLÜM501s1yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("3. BÖLÜM501s1yildiz", "1").apply();
                }
            }if (bolum.equals("3. BÖLÜM2")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("3. BÖLÜM502s2yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("3. BÖLÜM502s2yildiz", "1").apply();
                }
            }if (bolum.equals("3. BÖLÜM3")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("3. BÖLÜM503s3yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("3. BÖLÜM503s3yildiz", "1").apply();
                }
            }if (bolum.equals("4. BÖLÜM1")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("4. BÖLÜM501s1yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("4. BÖLÜM501s1yildiz", "1").apply();
                }
            }if (bolum.equals("4. BÖLÜM2")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("4. BÖLÜM502s2yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("4. BÖLÜM502s2yildiz", "1").apply();
                }
            }if (bolum.equals("4. BÖLÜM3")) {
                if (sorudogru <= 35) {
                    sharedPreferences.edit().putString("4. BÖLÜM503s3yildiz", "0").apply();
                } else if (sorudogru <= 40) {
                    sharedPreferences.edit().putString("4. BÖLÜM503s3yildiz", "1").apply();
                }
            }
        } else if (bolum.equals("1. BÖLÜM1")) {
            if (sorusay <= 9){
                soru = new Soru(soru1[sorusay1], soru1cevap1[sorusay1], soru1yanlis1[sorusay1], soru1yanlis2[sorusay1]);
            }if (sorusay > 9 && sorusay <= 19) {
                if(sorusay1 == 10){
                    sorusay1 -=10;
                }
                soru = new Soru(soru2[sorusay1], soru2cevap1[sorusay1], soru2yanlis1[sorusay1], soru2yanlis2[sorusay1]);
            }
            if (sorusay > 19 &&sorusay <= 29) {
                if(sorusay1 == 10){
                    sorusay1 -=10;
                }
                soru = new Soru(soru3[sorusay1], soru3cevap1[sorusay1], soru3yanlis1[sorusay1], soru3yanlis2[sorusay1]);
            }if (sorusay > 29 &&sorusay <= 39) {
                if(sorusay1 == 10){
                    sorusay1 -=10;
                }
                soru = new Soru(soru4[sorusay1], soru4cevap1[sorusay1], soru4yanlis1[sorusay1], soru4yanlis2[sorusay1]);
            }if (sorusay > 39 && sorusay <= 49) {
                if(sorusay1 == 10){
                    sorusay1 -=10;
                }
                soru = new Soru(soru5[sorusay1], soru5cevap1[sorusay1], soru5yanlis1[sorusay1], soru5yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 2:
                    imageView1.setImageResource(R.drawable.soru1soru3);
                    break;
                case 5:
                    imageView1.setImageResource(R.drawable.soru1soru6);
                    break;
                case 7:
                    imageView1.setImageResource(R.drawable.soru1soru8);
                    break;
                case 12:
                    imageView1.setImageResource(R.drawable.soru2soru3);
                    break;
                case 19:
                    imageView1.setImageResource(R.drawable.soru2soru10);
                    break;
                case 22:
                    imageView1.setImageResource(R.drawable.soru3soru3);
                    break;
                case 23:
                    imageView1.setImageResource(R.drawable.soru3soru4);
                    break;
                case 24:
                    imageView1.setImageResource(R.drawable.soru3soru5);
                    break;
                case 27:
                    imageView1.setImageResource(R.drawable.soru3soru8);
                    break;
                case 30:
                    imageView1.setImageResource(R.drawable.soru4soru1);
                    break;
                case 42:
                    imageView1.setImageResource(R.drawable.soru5soru3);
                    break;
                case 46:
                    imageView1.setImageResource(R.drawable.soru5soru7);
                    break;
                case 47:
                    imageView1.setImageResource(R.drawable.soru5soru8);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;
            }

        }else if (bolum.equals("1. BÖLÜM2")) {
            if (sorusay <= 9) {
                soru = new Soru(soru6[sorusay1], soru6cevap1[sorusay1], soru6yanlis1[sorusay1], soru6yanlis2[sorusay1]);
            }
            if (sorusay > 9 && sorusay <= 19) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru7[sorusay1], soru7cevap1[sorusay1], soru7yanlis1[sorusay1], soru7yanlis2[sorusay1]);
            }
            if (sorusay > 19 && sorusay <= 29) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru8[sorusay1], soru8cevap1[sorusay1], soru8yanlis1[sorusay1], soru8yanlis2[sorusay1]);
            }
            if (sorusay > 29 && sorusay <= 39) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru9[sorusay1], soru9cevap1[sorusay1], soru9yanlis1[sorusay1], soru9yanlis2[sorusay1]);
            }
            if (sorusay > 39 && sorusay <= 49) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru10[sorusay1], soru10cevap1[sorusay1], soru10yanlis1[sorusay1], soru10yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 16:
                    imageView1.setImageResource(R.drawable.soru7soru7);
                    break;
                case 18:
                    imageView1.setImageResource(R.drawable.soru7soru9);
                    break;
                case 39:
                    imageView1.setImageResource(R.drawable.soru9soru10);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;

            }
        }else if (bolum.equals("1. BÖLÜM3")) {
            if (sorusay <= 9) {
                soru = new Soru(soru11[sorusay1], soru11cevap1[sorusay1], soru11yanlis1[sorusay1], soru11yanlis2[sorusay1]);
            }
            if (sorusay > 9 && sorusay <= 19) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru12[sorusay1], soru12cevap1[sorusay1], soru12yanlis1[sorusay1], soru12yanlis2[sorusay1]);
            }
            if (sorusay > 19 && sorusay <= 29) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru13[sorusay1], soru13cevap1[sorusay1], soru13yanlis1[sorusay1], soru13yanlis2[sorusay1]);
            }
            if (sorusay > 29 && sorusay <= 39) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru14[sorusay1], soru14cevap1[sorusay1], soru14yanlis1[sorusay1], soru14yanlis2[sorusay1]);
            }
            if (sorusay > 39 && sorusay <= 49) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru15[sorusay1], soru15cevap1[sorusay1], soru15yanlis1[sorusay1], soru15yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 8:
                    imageView1.setImageResource(R.drawable.soru11soru9);
                    break;
                case 22:
                    imageView1.setImageResource(R.drawable.soru13soru3);
                    break;
                case 24:
                    imageView1.setImageResource(R.drawable.soru13soru5);
                    break;
                case 27:
                    imageView1.setImageResource(R.drawable.soru13soru8);
                    break;
                case 48:
                    imageView1.setImageResource(R.drawable.soru15soru9);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;

            }
        }else if (bolum.equals("2. BÖLÜM1")) {
            if (sorusay <= 9) {
                soru = new Soru(soru16[sorusay1], soru16cevap1[sorusay1], soru16yanlis1[sorusay1], soru16yanlis2[sorusay1]);
            }
            if (sorusay > 9 && sorusay <= 19) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru17[sorusay1], soru17cevap1[sorusay1], soru17yanlis1[sorusay1], soru17yanlis2[sorusay1]);
            }
            if (sorusay > 19 && sorusay <= 29) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru18[sorusay1], soru18cevap1[sorusay1], soru18yanlis1[sorusay1], soru18yanlis2[sorusay1]);
            }
            if (sorusay > 29 && sorusay <= 39) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru19[sorusay1], soru19cevap1[sorusay1], soru19yanlis1[sorusay1], soru19yanlis2[sorusay1]);
            }
            if (sorusay > 39 && sorusay <= 49) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru20[sorusay1], soru20cevap1[sorusay1], soru20yanlis1[sorusay1], soru20yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 10:
                    imageView1.setImageResource(R.drawable.soru17soru1);
                    break;
                case 36:
                    imageView1.setImageResource(R.drawable.soru19soru7);
                    break;
                case 37:
                    imageView1.setImageResource(R.drawable.soru19soru8);
                    break;
                case 39:
                    imageView1.setImageResource(R.drawable.soru19soru10);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;

            }
        }else if (bolum.equals("2. BÖLÜM2")) {
            if (sorusay <= 9) {
                soru = new Soru(soru21[sorusay1], soru21cevap1[sorusay1], soru21yanlis1[sorusay1], soru21yanlis2[sorusay1]);
            }
            if (sorusay > 9 && sorusay <= 19) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru22[sorusay1], soru22cevap1[sorusay1], soru22yanlis1[sorusay1], soru22yanlis2[sorusay1]);
            }
            if (sorusay > 19 && sorusay <= 29) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru23[sorusay1], soru23cevap1[sorusay1], soru23yanlis1[sorusay1], soru23yanlis2[sorusay1]);
            }
            if (sorusay > 29 && sorusay <= 39) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru24[sorusay1], soru24cevap1[sorusay1], soru24yanlis1[sorusay1], soru24yanlis2[sorusay1]);
            }
            if (sorusay > 39 && sorusay <= 49) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru25[sorusay1], soru25cevap1[sorusay1], soru25yanlis1[sorusay1], soru25yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 0:
                    imageView1.setImageResource(R.drawable.soru21soru1);
                    break;
                case 7:
                    imageView1.setImageResource(R.drawable.soru21soru8);
                    break;
                case 20:
                    imageView1.setImageResource(R.drawable.soru23soru1);
                    break;
                case 23:
                    imageView1.setImageResource(R.drawable.soru23soru4);
                    break;
                case 24:
                    imageView1.setImageResource(R.drawable.soru23soru5);
                    break;
                case 42:
                    imageView1.setImageResource(R.drawable.soru25soru3);
                    break;
                case 43:
                    imageView1.setImageResource(R.drawable.soru25soru4);
                    break;
                case 44:
                    imageView1.setImageResource(R.drawable.soru25soru5);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;

            }
        }else if (bolum.equals("2. BÖLÜM3")) {
            if (sorusay <= 9) {
                soru = new Soru(soru26[sorusay1], soru26cevap1[sorusay1], soru26yanlis1[sorusay1], soru21yanlis2[sorusay1]);
            }
            if (sorusay > 9 && sorusay <= 19) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru27[sorusay1], soru27cevap1[sorusay1], soru27yanlis1[sorusay1], soru27yanlis2[sorusay1]);
            }
            if (sorusay > 19 && sorusay <= 29) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru28[sorusay1], soru28cevap1[sorusay1], soru28yanlis1[sorusay1], soru28yanlis2[sorusay1]);
            }
            if (sorusay > 29 && sorusay <= 39) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru29[sorusay1], soru29cevap1[sorusay1], soru29yanlis1[sorusay1], soru29yanlis2[sorusay1]);
            }
            if (sorusay > 39 && sorusay <= 49) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru30[sorusay1], soru30cevap1[sorusay1], soru30yanlis1[sorusay1], soru30yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 10:
                    imageView1.setImageResource(R.drawable.soru27soru1);
                    break;
                case 11:
                    imageView1.setImageResource(R.drawable.soru27soru2);
                    break;
                case 32:
                    imageView1.setImageResource(R.drawable.soru29soru3);
                    break;
                case 33:
                    imageView1.setImageResource(R.drawable.soru29soru4);
                    break;
                case 39:
                    imageView1.setImageResource(R.drawable.soru29soru10);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;

            }
        }else if (bolum.equals("3. BÖLÜM1")) {
            if (sorusay <= 9) {
                soru = new Soru(soru31[sorusay1], soru31cevap1[sorusay1], soru31yanlis1[sorusay1], soru31yanlis2[sorusay1]);
            }
            if (sorusay > 9 && sorusay <= 19) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru32[sorusay1], soru32cevap1[sorusay1], soru32yanlis1[sorusay1], soru32yanlis2[sorusay1]);
            }
            if (sorusay > 19 && sorusay <= 29) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru33[sorusay1], soru33cevap1[sorusay1], soru33yanlis1[sorusay1], soru33yanlis2[sorusay1]);
            }
            if (sorusay > 29 && sorusay <= 39) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru34[sorusay1], soru34cevap1[sorusay1], soru34yanlis1[sorusay1], soru34yanlis2[sorusay1]);
            }
            if (sorusay > 39 && sorusay <= 49) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru35[sorusay1], soru35cevap1[sorusay1], soru35yanlis1[sorusay1], soru35yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 1:
                    imageView1.setImageResource(R.drawable.soru31soru2);
                    break;
                case 5:
                    imageView1.setImageResource(R.drawable.soru31soru6);
                    break;
                case 8:
                    imageView1.setImageResource(R.drawable.soru31soru9);
                    break;
                case 26:
                    imageView1.setImageResource(R.drawable.soru33soru7);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;

            }
        }else if (bolum.equals("3. BÖLÜM2")) {
            if (sorusay <= 9) {
                soru = new Soru(soru11[sorusay1], soru11cevap1[sorusay1], soru11yanlis1[sorusay1], soru11yanlis2[sorusay1]);
            }
            if (sorusay > 9 && sorusay <= 19) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru12[sorusay1], soru12cevap1[sorusay1], soru12yanlis1[sorusay1], soru12yanlis2[sorusay1]);
            }
            if (sorusay > 19 && sorusay <= 29) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru13[sorusay1], soru13cevap1[sorusay1], soru13yanlis1[sorusay1], soru13yanlis2[sorusay1]);
            }
            if (sorusay > 29 && sorusay <= 39) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru14[sorusay1], soru14cevap1[sorusay1], soru14yanlis1[sorusay1], soru14yanlis2[sorusay1]);
            }
            if (sorusay > 39 && sorusay <= 49) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru15[sorusay1], soru15cevap1[sorusay1], soru15yanlis1[sorusay1], soru15yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 8:
                    imageView1.setImageResource(R.drawable.soru11soru9);
                    break;
                case 22:
                    imageView1.setImageResource(R.drawable.soru13soru3);
                    break;
                case 24:
                    imageView1.setImageResource(R.drawable.soru13soru5);
                    break;
                case 27:
                    imageView1.setImageResource(R.drawable.soru13soru8);
                    break;
                case 48:
                    imageView1.setImageResource(R.drawable.soru15soru9);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;

            }
        }else if (bolum.equals("3. BÖLÜM3")) {
            if (sorusay <= 9) {
                soru = new Soru(soru11[sorusay1], soru11cevap1[sorusay1], soru11yanlis1[sorusay1], soru11yanlis2[sorusay1]);
            }
            if (sorusay > 9 && sorusay <= 19) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru12[sorusay1], soru12cevap1[sorusay1], soru12yanlis1[sorusay1], soru12yanlis2[sorusay1]);
            }
            if (sorusay > 19 && sorusay <= 29) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru13[sorusay1], soru13cevap1[sorusay1], soru13yanlis1[sorusay1], soru13yanlis2[sorusay1]);
            }
            if (sorusay > 29 && sorusay <= 39) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru14[sorusay1], soru14cevap1[sorusay1], soru14yanlis1[sorusay1], soru14yanlis2[sorusay1]);
            }
            if (sorusay > 39 && sorusay <= 49) {
                if (sorusay1 == 10) {
                    sorusay1 -= 10;
                }
                soru = new Soru(soru15[sorusay1], soru15cevap1[sorusay1], soru15yanlis1[sorusay1], soru15yanlis2[sorusay1]);
            }
            switch (sorusay) {
                case 8:
                    imageView1.setImageResource(R.drawable.soru11soru9);
                    break;
                case 22:
                    imageView1.setImageResource(R.drawable.soru13soru3);
                    break;
                case 24:
                    imageView1.setImageResource(R.drawable.soru13soru5);
                    break;
                case 27:
                    imageView1.setImageResource(R.drawable.soru13soru8);
                    break;
                case 48:
                    imageView1.setImageResource(R.drawable.soru15soru9);
                    break;
                default:
                    imageView1.setImageResource(R.drawable.sa);
                    break;

            }
        }

        sorusay++;
        sorusay1++;
        soru();
        sorudegis();

    }




    public void dogruc(){
        cevap1 = button1.getText().toString();
        cevap2 = button2.getText().toString();
        cevap3 = button3.getText().toString();
        dogru = soru.cevap;
        handler1 = new Handler();
        runnable1 = new Runnable(){
            @Override
            public void run() {
                if (Objects.equals(dogru, cevap1)){
                    button1.setBackgroundResource(R.drawable.d);
                }else if (Objects.equals(dogru, cevap2)){
                    button2.setBackgroundResource(R.drawable.d);
                }else if (Objects.equals(dogru, cevap3)){
                    button3.setBackgroundResource(R.drawable.d);
                }
                run++;
                handler1.postDelayed(this, 700);
                if (run == 2) {
                    handler1.removeCallbacks(runnable1);
                    run=-1;
                    sorudegistir();
                }
            }
        };
        handler1.post(runnable1);
    }



    public void soru() {
        ArrayList<String> i1 = new ArrayList<String>();
        i1.add("boş");
        i1.add(soru.yanlis);
        i1.add(soru.yanlis1);
        i1.add(soru.cevap);
        int sayi, Sorusec[] = new int[4];
        Sorusec[0] = 0;
        for (int i = 0; i < 4; i++) {
            sayi = (int) (Math.random() * 4);
            for (int j = 0; j <= i; j++) {
                if (Sorusec[j] == sayi) {
                    sayi = (int) (Math.random() * 4);
                    j = 0;
                }
            }
            Sorusec[i] = sayi;
        }
        for (int j = 0; j < 4; j++) {
            if (j == 1) {
                s1 = i1.get(Sorusec[j]);
            }
            if (j == 2) {
                s2 = i1.get(Sorusec[j]);
            }
            if (j == 3) {
                s3 = i1.get(Sorusec[j]);
            }
        }
        if (s1.length() >= 135){
            button1.setTextSize(11);
        }if (s1.length() <= 20){
            button1.setTextSize(16);
        }if (s1.length() <= 55){
            button1.setTextSize(14);
        }if (s1.length() <= 90){
            button1.setTextSize(13);
        }if (s1.length() <= 100){
            button1.setTextSize(12);
        }
        if (s2.length() >= 135){
            button2.setTextSize(11);
        }if (s2.length() <= 20){
            button2.setTextSize(16);
        }if (s2.length() <= 55){
            button2.setTextSize(14);
        }if (s2.length() <= 90){
            button2.setTextSize(13);
        }if (s2.length() <= 100){
            button2.setTextSize(12);
        }
        if (s3.length() >= 135){
            button3.setTextSize(11);
        }if (s3.length() <= 20){
            button3.setTextSize(16);
        }if (s3.length() <= 55){
            button3.setTextSize(14);
        }if (s3.length() <= 90){
            button3.setTextSize(13);
        }if (s3.length() <= 100){
            button3.setTextSize(12);
        }

        if(soru.soru.length() >= 500) {
            textsoru.setTextSize(10);
        }if(soru.soru.length() >= 300){
            textsoru.setTextSize(13);
        } if (soru.soru.length() <= 50) {
            textsoru.setTextSize(25);
        } if (soru.soru.length() <= 100) {
            textsoru.setTextSize(20);
        }if (soru.soru.length() <= 200) {
            textsoru.setTextSize(15);
        }
        textsoru.setText(soru.soru);
        button1.setText(s1);
        button2.setText(s2);
        button3.setText(s3);
    }



    public void sorudegis(){
        button1.setBackgroundResource(R.drawable.soru);
        button2.setBackgroundResource(R.drawable.soru);
        button3.setBackgroundResource(R.drawable.soru);
        sorusayisi.setText(""+kacsoru+"/50");
    }




    public void ShowDialogBox () {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.diag, null);
        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(false);
        TextView textView1 = mView.findViewById(R.id.dogruset);
        TextView textView2 = mView.findViewById(R.id.yanlisset);
        TextView textView3 = mView.findViewById(R.id.baslik);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView1.setText(""+sorudogru);
        textView2.setText(""+soruyanlis);
        mView.findViewById(R.id.restart).setOnClickListener(v -> {
            alertDialog.dismiss();
            Intent intent = new Intent(Soru50ana.this,Soru50ana.class);
            startActivity(intent);
            finish();
        });
        mView.findViewById(R.id.next).setOnClickListener(v -> {
            alertDialog.dismiss();
            if(bolum.equals("1. BÖLÜM1")) {
                sharedPreferences.edit().putString("secim", "1. BÖLÜM2").apply();
            }
            if(bolum.equals("1. BÖLÜM2")) {
                sharedPreferences.edit().putString("secim", "1. BÖLÜM3").apply();
            }
            if(bolum.equals("1. BÖLÜM3")) {
                sharedPreferences.edit().putString("secim", "2. BÖLÜM1").apply();
            }
            if(bolum.equals("2. BÖLÜM1")) {
                sharedPreferences.edit().putString("secim", "2. BÖLÜM2").apply();
            }
            if(bolum.equals("2. BÖLÜM2")) {
                sharedPreferences.edit().putString("secim", "2. BÖLÜM3").apply();
            }
            if(bolum.equals("2. BÖLÜM3")) {
                sharedPreferences.edit().putString("secim", "3. BÖLÜM1").apply();
            }
            if(bolum.equals("3. BÖLÜM1")) {
                sharedPreferences.edit().putString("secim", "3. BÖLÜM2").apply();
            }
            if(bolum.equals("3. BÖLÜM2")) {
                sharedPreferences.edit().putString("secim", "3. BÖLÜM3").apply();
            }
            if(bolum.equals("3. BÖLÜM3")) {
                sharedPreferences.edit().putString("secim", "4. BÖLÜM1").apply();
            }
            if(bolum.equals("4. BÖLÜM1")) {
                sharedPreferences.edit().putString("secim", "4. BÖLÜM2").apply();
            }
            if(bolum.equals("4. BÖLÜM2")) {
                sharedPreferences.edit().putString("secim", "4. BÖLÜM3").apply();
            }
            if(bolum.equals("4. BÖLÜM3")) {
                Toast.makeText(Soru50ana.this,"Sınav Sorularının Tümü Bitmiştir.",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Soru50ana.this,MainActivity3.class);
                startActivity(intent);
                finish();
            }
            Intent intent = new Intent(Soru50ana.this,Soru50ana.class);
            startActivity(intent);
            finish();
        });

        mView.findViewById(R.id.anamenu).setOnClickListener(v -> {
            alertDialog.dismiss();
            finish();
        });

        alertDialog.show();

    }


}