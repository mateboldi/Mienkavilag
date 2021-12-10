package hu.mateboldi.mienkavilag

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_USER_MAP ="EXTRA_USER_MAP"
private const val TAG="MAIN"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val felhasz =adatokgeneralasa() valamiért nem ismeri fel, hogy én a mire is gondolok....

        val felhasz2 =adatokgeneralasa()
        adatokgeneralasa()

        // ELRENDEZÉS
        //rvMaps.layoutManager=LinearLayoutManager(this);
        // LinearLayoutManager(this).also { rvMaps.layoutManager = it };
        //rvMaps.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        //val mRecyclerView = findViewById(R.id.rvMaps);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvMaps.layoutManager=LinearLayoutManager(this); //csak sikerült Kotlinba ez a szép recycler ....
        //adapter beállítása
        // rvMaps.adapter=terkepAdapter(this, emptyList<felhasz>()) üres lista míg nem volt adat és ne panaszkodjon
        rvMaps.adapter=terkepAdapter(this, felhasz2, object :terkepAdapter.OnClickListener{

            //elindítani a térképet
            override fun onItemClick(position: Int) {
                //MAIN kulcsszóval megkereshető a logban
                //Log.i(TAG, "átadási pozi: $position")
                //Toast.makeText(applicationContext,"ITT NINCS BAJ $position",Toast.LENGTH_SHORT).show()
                val intent= Intent (this@MainActivity,DisplayMapActivity::class.java)
                //szerializáció be kellett írni a felhasz és hely állományba
                intent.putExtra(EXTRA_USER_MAP, felhasz2[position])

                startActivity(intent)
            }
        })


    }

    private fun adatokgeneralasa(): List<felhasz> {
        return listOf(
            felhasz(
                "Debreceni látnivalók",
                listOf(
                    hely("Nagytemplom", "Az ország legnagyobb református temploma", 47.53212906141424, 21.624502951696826),
                    hely("Debreceni Egyetem", "főépület", 47.55363849564105, 21.621679359923792),
                    hely("Déri Múzeum", "Múzeum barokk épületben", 47.533040080966856, 21.622044196571498),
                    hely("Nagyerdei park", "Békás tó", 47.551996999457145, 21.62707535858978)
                )
            ),
            felhasz("Templomromok Debrecen közelében",
                listOf(
                    hely("Fancsikai", "Árpádkori", 47.486425494636435, 21.70774692147021),
                    hely("Zeleméri", "Zeleméri", 47.626311333993534, 21.57793629993061),
                    hely("Parlagi", "Dombosi", 47.60132932341817, 21.695166805064222)
                )),
            /*felhasz("HA BŐVÍTENI AKARUNK ITT VAN EGY SABLON",
                listOf(
                    hely("Fancsikai", "Árpádkori", 47.486425494636435, 21.70774692147021),
                    hely("Zeleméri", "Zeleméri", 47.626311333993534, 21.57793629993061),
                    hely("Parlagi", "Dombosi", 47.60132932341817, 21.695166805064222)
                )),*/
            felhasz("Bevásárlási lehetőségek",
                listOf(
                    hely("Fórum", "Bevásárló központ", 47.533169584400596, 21.628895976060438),
                    hely("Pláza", "Bevásárló központ", 47.53514765081896, 21.62436958673248),
                    hely("Zsibogó", "Zsibi", 47.522749040038605, 21.65148372468231),
                    hely("TOP SHOP", "Bevásárló park", 47.54153854903595, 21.577298885186025)
                )),
            felhasz("Egyetemi épületek",
                listOf(
                    hely("IK", "Informatikai kar",47.54212434913745, 21.639670296412618),
                    hely("ÁJK", "Jogi kar", 47.544711104023754, 21.64176095360945),
                    hely("GTK", "Debreceni Egyetem Gazdaságtudományi Kar", 47.55275730517107, 21.60830695906143),
                    hely("Debreceni Egyetem", "BTK", 47.55363849564105, 21.621679359923792)
                )
            )
        )
    }
}