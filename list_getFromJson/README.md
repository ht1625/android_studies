<h1> Hipo Task </h1>

<p>
  Uygulama, bir json dosyasından alınan üyeleri sıralama, arama ve kendini ekleme.
</p>

<p>
  MainActivity dosyası içinde, assets/hipo.json'dan üye bilgileri alınır. Üye bilgileri ile Model/member class listesi oluşturulur. Oluşan userList MemberAdapter'a gönderilir ve activity_main_xml'daki recyclerView'in adapter'ine eşitlenir. Böylece üyeler listelenmiş olur. Arama için searcView'e girilen değer değişikliği için setOnQueryTextListener kullanılır ve girilen input değeri ile member.name ve member.position içinde arama yapılır. Çıkan sonuçlara göre userList güncellenir.
</p>  
<p align="center">
  <img src="https://github.com/ht1625/android_studies/blob/main/list_getFromJson/ImagesProject/ImageHipoTask1.png" height="400">
</p>

<h1> </h1>
<p>
  Kayıt olmak isteyen stajyer Register butonuna tıkladığında, intent kullanılarak AddMember.kt(Register File) sayfasına gönderilir. Burada kulllanıcı gerekli bilgileri doldurmalıdır. Register butonuna tıkladığında EditText içerisindeki bilgiler alınıp intent kullanılarak MainActivity'ye yönlendirilir. MainActivity de gelen bilgiler ile bir member class'ı oluşturulur ve userList'e eklenilir.
</p>  
<p align="center">
  <img src="https://github.com/ht1625/android_studies/blob/main/list_getFromJson/ImagesProject/ImageHipoTask2.png" height="400">
</p>

<h1> </h1>
<p>
  Üyeler için detay sayfası  bulunmaktadır. Kullanıcı, üyenin adına yada pozisyonuna tıkladığı zaman, MemberAdapter içerisinden üyenin bilgileri alınıp intent ile MemberDetail.kt'e aktarılır. 
</p>  
<p align="center">
  <img src="https://github.com/ht1625/android_studies/blob/main/list_getFromJson/ImagesProject/ImageHipoTask3.png" height="400">
</p>
