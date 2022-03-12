package com.example.card_flower

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_flower.view.*

class MainActivity : AppCompatActivity() {
    var flower_list=ArrayList<flowers>()
    var adapter:flower_adapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flower_list.add(flowers("GÜL","İkiçenekliler sınıfının, Rosales takımının, " +
                "Gülgiller familyasından bir bitkidir. Kuzey yarımkürenin ılıman ve subtropikal bölgelerinde yetişir." +
                " Kışın yaprağını döker, ancak bazı türleri ise sürekli yeşildir. Dikenli çalı ya da ağaççık görünümündedir. " +
                "Gövdesi dik ya da sürüngen olabilir. Bazı türleri ise sarılıcıdır. Çiçekler kırmızı, beyaz, sarı, pembe hatta" +
                " siyah renkte olabilir. Gülün çiçekler arasında apayrı bir yeri vardır. Mitolojide güzellik tanrıçası Afrodit’in çiçeğidir." +
                " Dini bir sembol olarak Osmanlılar’dan bu yana kullanılagelmiş ve süsleme sanatları içerisinde kendine özel bir yer edinmiştir. " +
                "Türk ve Dünya Edebiyatı’nda şiir ve romanlarda, şarkılarda aşkı sembolize " +
                "eden bir çiçektir gül.",R.drawable.gul))
        flower_list.add(flowers("LALE","Lale, zambakgiller familyasından, Tulipa cinsini oluşturan güzel çiçekleri " +
                "ile süs bitkisi olarak yetiştirilen, soğanlı, çok yıllık otsu bir bitkidir. Anavatanı Pamir, Hindukuş ve Tanrı Dağları’dır. " +
                "Türkler, göçleri esnasında bu bitkinin soğanlarını Anadolu’ya getirmiştir. 16. yüzyılda Kanuni Sultan Süleyman tarafından Hollanda " +
                "Kralı’na gönderilen laleler, ilk başta Hollandalılar’ı ve kısa zaman içerisinde tüm Avrupalılar’ı hayranlık içinde bırakmıştır.\n" +
                "Lale, özellikle doğu kültür ve mitolojilerinde özel bir yere sahiptir. Hollanda’da Lalemania, Osmanlı’da da Lale Devri " +
                "olarak adlandırılan belirli dönemlere markasını vurmuştur. Osmanlı sanatlarının gözbebeği sayılan lale, edebi eserlerde sıkça " +
                "kullanılır. Mitolojilerde de lalenin ortaya çıkışına dair farklı ve çok çeşitli hikayeler anlatılır.",R.drawable.lale))
        flower_list.add(flowers("KARANFİL","Pembe, kırmızı, beyaz ve mor gibi renkleri olan karanfil güzel kokusuyla bilinir." +
                " Doğada olan türlerinin yanında, evlerde de yetiştirilir, ancak daha çok seralarda yetiştirilmektedir. Ilıman iklimde, çok az " +
                "güneşli veya yarı gölgeli ortamlarda sağlıklı bir şekilde yetişirler. Çeşitleri ise şunlardır:\n" +
                "\n" +
                "– Büyük çiçekli karanfil: Bir sapta büyük bir veya az sayıda çiçek bulunur.\n" +
                "– Dağınık karanfil: Çok sayıda küçük çiçekler açar. Saksılarda sarkık olarak yetiştirilebilir.\n" +
                "– Bodur ve toplu çiçekli: Her sap üstünde çok sayıda küçük çiçekler açar.",R.drawable.karanfil))
        flower_list.add(flowers("ZAMBAK","Zambak familyasının, Lilium cinsinden genellikle soğan ile üreyen mevsimlik" +
                " çiçekli bitkilerin adıdır. Zambakgiller familyasında bu cinse ait 110 civarında bitki türü vardır. Genellikle bahçede, " +
                "ancak saksıda da yetiştirilir. Bazı türleri güzel kokuludur.",R.drawable.karanfil))
        flower_list.add(flowers("KASIMPATI","Krizantem, bir diğer ismi ile Kasımpatı yaklaşık 30 tür barındıran, papatyagiller " +
                "familyasına bağlı otsu, yıllık bir bitki türüdür. Çiçek farklılıklarına göre, papatya benzeri, düğme şekilli, çok iri katmerli, " +
                "irili ufaklı katmerli türleri bulunur. Kasım ayında birdenbire çıkıveren, bu ani patlamadan ötürü de isminin Kasımpatı kaldığı " +
                "düşünülen bu güzel çiçek, hem birçok mitolojik hikayeye konu olmuştur, hem de zamanla birtakım mistik kavramların simgesi haline gelmiştir. " +
                "Kimi zaman cenaze çiçeği (Uzakdoğu’da, Japonya’da cenazelere götürüldüğü için), kimi zaman ölümsüz aşkın, kimi zaman da platonik " +
                "sevdaların kahramanı olur",R.drawable.zambak))
        flower_list.add(flowers("","Beyaz ve sarı renklerinin hakim olduğu nergis çiçeği, soğuklara karşı direnç gösterebilen " +
                "bir bitkidir. Daha çok Akdeniz iklimlerinde yetişmeye elverişlidir. 43 çeşidi ile doğada doğal olarak bulunabilen ve süs bitkisi olarak " +
                "da yetiştirilmeye uygun olan nergisin en bilinen çeşitleri arasında, yabani nergis, beyaz nergis, Çin nergisi, güz nergisi, fulya ve" +
                " zerren yer almaktadır. Nergis ismini mitolojik kahraman Narcissus’tan almıştır. İsmini narsisizme, narkoza, çiçeğe vermiş olan Narsis" +
                " (ya da Narkissos) ona aşık olan bir kızın aşkına karşılık vermez ve bir gün kendi aksini görerek, kendi yansımasına aşık olup bu " +
                "aşkla yok olup gider.",R.drawable.nergis))
        flower_list.add(flowers("SÜMBÜL","Sümbül, soğanlı bitkilerden olup daha önce zambakgiller familyasının üyesi olarak kabul edilmekte " +
                "iken, şimdi yeni bir familya olan Hyacinthaceae altında incelenmektedir. Çok güzel kokan sümbül, lale gibi Avrupa’ya Türkiye’den gitmiş," +
                " birçok türleri üretilmiştir. Bunlardan, Hollanda sümbülünün soğanı iri, çiçeklerinin renkleri daha canlıdır. Paris sümbülü daha ufaktır, " +
                "renkleri de beyaz, mavi, pembe olur. Sümbül bahçelerde olduğu gibi saksılarda da yetiştirilir.",R.drawable.sumbul))

        adapter= flower_adapter(this,flower_list)
        list_card.adapter=adapter
    }

    class flower_adapter:BaseAdapter{
        var list_temp=ArrayList<flowers>()
        var context:Context?=null

        constructor(context: Context,list_temp:ArrayList<flowers>):super(){
            this.list_temp=list_temp
            this.context=context
        }

        override fun getCount(): Int {//boyutu kadar dönücek
            return list_temp.size
        }

        override fun getItem(p0: Int): Any {
            return list_temp[p0] //liste elemanlarına position vercek
        }

        override fun getItemId(p0: Int): Long {//dosyanın uzunluğu kadar dönücek
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pos_flower:flowers=list_temp[p0]
            var inflater:LayoutInflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var flower_card:View=inflater.inflate(R.layout.card_flower,null)
            flower_card.textView.text=pos_flower.title
            flower_card.imageView.setImageResource(pos_flower.img!!)
            flower_card.data.text=pos_flower.text

            flower_card.imageView.setOnClickListener{
                var intent=Intent(context,flower_detay::class.java)
                intent.putExtra("name",pos_flower.title)
                intent.putExtra("text",pos_flower.text)
                intent.putExtra("img",pos_flower.img!!)
                context!!.startActivity(intent)
            }
            return flower_card
        }

    }
}

