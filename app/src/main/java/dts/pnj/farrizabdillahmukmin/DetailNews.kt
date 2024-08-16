package dts.pnj.farrizabdillahmukmin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val imageView = findViewById<ImageView>(R.id.detail_image)

        val intent = intent
        val title = intent.getStringExtra("EXTRA_TITLE")
        val content = intent.getStringExtra("EXTRA_CONTENT")
        val imagePath = intent.getStringExtra("EXTRA_IMAGE_PATH")

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val titleTextView = findViewById<TextView>(R.id.detail_title)
        val contentTextView = findViewById<TextView>(R.id.detail_content)

        titleTextView.text = title
        contentTextView.text = content

        // Load the image from drawable resource
        val imageResource = when (imagePath) {
            "drawable/berita_tni" -> R.drawable.berita_tni
            "drawable/latihan_tni" -> R.drawable.latihan_tni
            "drawable/hut_ri" -> R.drawable.hut_ri
            "drawable/berita_polisi" -> R.drawable.berita_polisi
            "drawable/berita_presiden" -> R.drawable.berita_presiden
            "drawable/berita_teroris" -> R.drawable.berita_teroris
            "drawable/berita_panglima" -> R.drawable.berita_panglima
            "drawable/berita_tni_al" -> R.drawable.berita_tni_al
            "drawable/berita_kasal" -> R.drawable.berita_kasal
            "drawable/berita_penembakan" -> R.drawable.berita_penembakan
            else -> R.drawable.ic_news
        }
        imageView.setImageResource(imageResource)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}