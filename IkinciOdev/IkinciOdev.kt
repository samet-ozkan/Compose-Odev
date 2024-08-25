package com.sametozkan.kotlindersleri

fun main() {
    val icAcilarToplamiSonuc = icAcilarToplami(4)
    val maasSonuc = maasHesapla(25)
    val kotaUcretiSonuc = kotaUcretiHesapla(80)
    val fahrenheitSonuc = dereceToFahrenheit(25.5)
    val dikdortgenCevresiSonuc = dikdortgenCevresi(8, 10)
    val faktoriyelSonuc = faktoriyel(5)
    val aHarfiSayisi = aHarfiSay("Galatasaray")

    println("İç Açılar Toplamı: $icAcilarToplamiSonuc")
    println("Maaş: $maasSonuc TL")
    println("Kota Ücreti: $kotaUcretiSonuc TL")
    println("Fahrenheit: $fahrenheitSonuc")
    println("Dikdörtgen Çevresi: $dikdortgenCevresiSonuc")
    println("Faktöriyel: $faktoriyelSonuc")
    println("a Harfi Sayısı: $aHarfiSayisi")

}

fun icAcilarToplami(kenarSayisi: Int): Int {
    return (kenarSayisi - 2) * 180
}

fun maasHesapla(gunSayisi: Int): Int {
    val toplamSaat = gunSayisi * 8
    val mesaiSaati = if (toplamSaat > 160) toplamSaat - 160 else 0
    val normalSaat = toplamSaat - mesaiSaati

    return (normalSaat * 10) + (mesaiSaati * 20)
}

fun kotaUcretiHesapla(kota: Int): Int {
    val sabitUcret = 100
    val asimUcreti = if (kota > 50) (kota - 50) * 4 else 0

    return sabitUcret + asimUcreti
}

fun dereceToFahrenheit(derece: Double): Double {
    return derece * 1.8 + 32
}

fun dikdortgenCevresi(kisaKenar: Int, uzunKenar: Int): Int {
    return 2 * (kisaKenar + uzunKenar)
}

fun faktoriyel(sayi: Int): Int {
    return if (sayi <= 1) 1 else sayi * faktoriyel(sayi - 1)
}

fun aHarfiSay(kelime: String): Int {
    return kelime.count { it == 'a' || it == 'A' }
}







