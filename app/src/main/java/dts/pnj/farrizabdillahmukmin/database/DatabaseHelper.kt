package dts.pnj.farrizabdillahmukmin.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import dts.pnj.farrizabdillahmukmin.R
import java.io.File
import java.io.FileOutputStream

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE $TABLE_NEWS (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMN_TITLE TEXT, " +
                    "$COLUMN_CONTENT TEXT, " +
                    "$COLUMN_PATH_IMAGE TEXT)"
        )

        db.execSQL(
            "CREATE TABLE $TABLE_ALUMNI (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMN_NIM TEXT, " +
                    "$COLUMN_NAMA TEXT, " +
                    "$COLUMN_TEMPAH_LAHIR TEXT, " +
                    "$COLUMN_TANGGAL_LAHIR TEXT, " +
                    "$COLUMN_ALAMAT TEXT, " +
                    "$COLUMN_AGAMA TEXT, " +
                    "$COLUMN_TELEPON TEXT, " +
                    "$COLUMN_TAHUN_MASUK INTEGER, " +
                    "$COLUMN_TAHUN_LULUS INTEGER, " +
                    "$COLUMN_PEKERJAAN TEXT, " +
                    "$COLUMN_JABATAN TEXT)"
        )

        // Insert dummy data
        insertDummyData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NEWS")
        onCreate(db)
    }

    private fun insertDummyData(db: SQLiteDatabase) {
        val titles = listOf(
            "Rekaman CCTV Penganiayaan Polisi Menyebar, Pelaku Berbaju Loreng",
            "Militer Indonesia Latihan Penanggulangan Bencana Bersama Australia dan AS",
            "Segala Persiapan TNI dan Polri Mengamankan Kegiatan HUT RI ke-79 di IKN",
            "Polisi di Majalengka Dilarang Foto dengan Pose \"Angkat Jari\", Wakapolres Ungkap Alasannya",
            "Jokowi Masukkan Makan Bergizi Gratis Prabowo ke RAPBN 2025, Terkait Anggaran Pendidikan?",
            "Penembakan di Papua: Jenderal bintang satu TNI meninggal, pemerintah sebut 'KKB teroris'",
            "Agus Subiyanto sah menjadi panglima TNI - Seperti apa kedekatannya dengan Presiden Jokowi?",
            "Korban Penggelapan Mobil Dipanggil Lantamal Batam, 2 Oknum TNI AL Terlibat",
            "Siap Bangun Pertahanan Laut Tangguh Untuk Indonesia Maju, KASAL Buka Rapat Pimpinan TNI AL Tahun 2024",
            "Kasus baku tembak anggota polisi tak ditangani transparan, 'kepolisian semakin tidak dipercaya oleh masyarakat'"
        )

        val contents = listOf(
            "Video berdurasi lima menit ini menunjukkan penganiayaan dua polisi oleh 4 pelaku, di antaranya berseragam loreng hijau.",
            "Wakil Asisten Operasi Panglima TNI Marsma TNI Muhammad Taufiq Arasj menyempatkan diri meninjau militer Indonesia, Australia, dan Amerika Serikat (AS) yang menggelar latihan bersama dalam hal bantuan kemanusiaan dan penanggulangan bencana atau Humanitarian Aid and Disaster Relief (HADR). Latma bersandi Bhakti Kanyini AusIndo 2024 itu resmi secara resmi dibuka oleh Marc Monagan dari Legislative Assembly di The Parliament House, Darwin, Australia, Senin, (12/8/2024) waktu setempat. Latihan akan berlangsung selama 14 hari.",
            "Seorang anggota TNI melakukan monitoring di Nusantara Command Center di Ibu Kota Nusantara (IKN), Penajam Paser Utara, Kalimantan Timur, Senin, 12 Agustus 2024. Nusantara Command Center berfungsi sebagai pengawas lokasi dan pembangunan berbagai proyek APBN dan Non-APBN di Ibu Kota Nusantara sekaligus menjaga IKN dari serangan siber.",
            "Anggota kepolisian di Majalengka, Jawa Barat (Jabar), kini dilarang berpose dengan mengangkat jarinya ketika berfoto. Wakapolres Majalengka, Kompol Asep Agustoni menjelaskan, larangan ini diberlakukan demi menjaga netralitas Polri menjelang Pilkada Serentak 2024. Menurutnya, berfoto dengan pose mengangkat jari dapat diinterpretasikan sebagai dukungan kepada calon kepala daerah pada Pilkada mendatang.",
            "Presiden Jokowi memastikan program Makan Bergizi Gratis (MBG) yang digagas presiden terpilih Pilpres 2024, Prabowo Subianto, masuk dalam rancangan anggaran pendapatan dan belanja negara (RAPBN) 2025. Jokowi berujar, program makan bergizi gratis termasuk dalam strategi kebijakan jangka pendek untuk mengakselerasi pertumbuhan ekonomi, menguatkan kesejahteraan, serta pemerataan  antardaerah.",
            "Pemerintah Indonesia mengategorikan apa yang mereka sebut sebagai kelompok kriminal bersenjata (KKB) di Papua adalah teroris setelah seorang jenderal bintang satu meninggal dunia dalam insiden baku tembak yang terjadi di Beoga, Kabupaten Puncak, pada Minggu (25/04). Sebelumnya, kelompok pro-kemerdekaan Papua, Tentara Pembebasan Nasional Papua Barat - Organisasi Papua Merdeka (TPNPB-OPM) mengeklaim \"bertanggung jawab\" atas penembakan itu.",
            "Rapat paripurna DPR RI resmi mengesahkan Jenderal TNI Agus Subiyanto sebagai Panglima TNI menggantikan Laksamana TNI Yudo Margono, pada Selasa (21/11). Keputusan itu diambil setelah Ketua Komisi I DPR, Meutya Viada Hafid, menyampaikan laporan mengenai proses mekanisme calon Panglima TNI, termasuk pelaksanaan uji kelayakan dan kepatutan atau fit and proper test terhadap Jenderal Agus.",
            "Belasan korban penggelapan mobil di Batam, menyebut dugaan bekingan \"orang kuat\" dalam kasus penggelapan mobil di Batam yang melibatkan oknum TNI.",
            "Guna membangun pertahanan laut yang tangguh untuk Indonesia maju dan mewujudkan kekuatan TNI Angkatan Laut (TNI AL) yang profesional, modern dan tangguh, Kepala Staf Angkatan Laut (Kasal) Laksamana TNI Dr. Muhammad Ali membuka Rapat Pimpinan (Rapim) TNI Angkatan Laut (TNI AL) tahun 2024 bertempat di Auditorium Denma Mabesal, Cilangkap, Jakarta Timur, Kamis (29/02). Rapim TNI AL tahun 2024 sebagai forum untuk melaksanakan penyamaan visi dan sinkronisasi untuk menunjang keberhasilan pelaksanaan program kerja TNI AL yang telah ditetapkan guna mencapai kesiapan dan kesiagaan yang tinggi dalam melaksanakan tugas-tugas TNI AL yang dipercayakan oleh negara.",
            "Kasus baku tembak antara Brigadir J dan Bharada E— yang menewaskan Brigadir J— di rumah Kadiv Propam Polri Irjen Ferdy Sambo bisa berdampak pada kehormatan institusi kepolisian jika tidak ada langkah penyelesaian yang konkret, kata pengamat."
        )

        val imageResourceIds = listOf(
            "drawable/berita_tni",
            "drawable/latihan_tni",
            "drawable/hut_ri",
            "drawable/berita_polisi",
            "drawable/berita_presiden",
            "drawable/berita_teroris",
            "drawable/berita_panglima",
            "drawable/berita_tni_al",
            "drawable/berita_kasal",
            "drawable/berita_penembakan"
        )

        for (i in titles.indices) {
            val values = ContentValues().apply {
                put(COLUMN_TITLE, titles[i])
                put(COLUMN_CONTENT, contents[i])
                put(COLUMN_PATH_IMAGE, imageResourceIds[i])
            }

            // Log values for debugging
            Log.d("DatabaseHelper", "Inserting data: $values")

            val rowId = db.insert(TABLE_NEWS, null, values)
            if (rowId == -1L) {
                Log.e("DatabaseHelper", "Failed to insert row for title: ${titles[i]}")
            } else {
                Log.d("DatabaseHelper", "Inserted row with ID: $rowId")
            }
        }
    }


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "alumni.db"

        // News table
        const val TABLE_NEWS = "news"
        const val COLUMN_ID = "_id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_CONTENT = "content"
        const val COLUMN_PATH_IMAGE = "path_image"

        // Alumni table
        const val TABLE_ALUMNI = "alumni"
        const val COLUMN_NIM = "nim"
        const val COLUMN_NAMA = "nama"
        const val COLUMN_TEMPAH_LAHIR = "tempat_lahir"
        const val COLUMN_TANGGAL_LAHIR = "tanggal_lahir"
        const val COLUMN_ALAMAT = "alamat"
        const val COLUMN_AGAMA = "agama"
        const val COLUMN_TELEPON = "telepon"
        const val COLUMN_TAHUN_MASUK = "tahun_masuk"
        const val COLUMN_TAHUN_LULUS = "tahun_lulus"
        const val COLUMN_PEKERJAAN = "pekerjaan"
        const val COLUMN_JABATAN = "jabatan"
    }
}