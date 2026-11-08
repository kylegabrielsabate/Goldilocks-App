package com.example.goldilocks.data

import com.example.goldilocks.R

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val category: String,
    val imageResId: Int,
    val isCake: Boolean = false // True ONLY for Whole Cakes (8x12, 9rd, Petite)
)

object ProductRepository {
    val allProducts = listOf(
        // Mamon
        Product(1, "Fluffy Mamon Bitbit 6s", 210.0, "Mamon", R.drawable.fluffy_mamon_bitbit_6s, false),
        Product(2, "Cheesy Mamon Bitbit 6s", 270.0, "Mamon", R.drawable.cheesy_mamon_bitbit_6s, false),
        Product(3, "Fluffy Mamon", 35.0, "Mamon", R.drawable.fluffy_mamon, false),
        Product(4, "Cheesy Fluffy Mamon", 45.0, "Mamon", R.drawable.cheesy_fluffy_mamon, false),
        Product(5, "Fluffy Mamon Bitbit 6s", 210.0, "Mamon", R.drawable.fluffy_mamon_bitbit_6s, false),
        Product(6, "Toasted Mamon", 170.0, "Mamon", R.drawable.toasted_mamon, false),

        // Cake Slices (Dedication DISABLED)
        Product(7, "Chiffon Cake Slice", 45.0, "Cake Slices", R.drawable.chiffon_cake_slice, false),
        Product(8, "Double Dutch Cake Slice", 45.0, "Cake Slices", R.drawable.double_dutch_cake_slice, false),
        Product(9, "Buttercake Slice", 45.0, "Cake Slices", R.drawable.buttercake_slice, false),
        Product(10, "Mocha Marble Cake Slice", 45.0, "Cake Slices", R.drawable.mocha_marble_cake_slice, false),
        Product(11, "Chocolate Cake Slice", 45.0, "Cake Slices", R.drawable.chocolate_cake_slice, false),
        Product(12, "Marble Cake Slice", 45.0, "Cake Slices", R.drawable.marble_cake_slice, false),
        Product(13, "Assorted Chiffon Cake Slice Bitbit 6s", 270.0, "Cake Slices", R.drawable.assorted_chiffon_cake_slice_bitbit_6s, false),
        Product(14, "Assorted Butter Cake Slices 6s", 270.0, "Cake Slices", R.drawable.assorted_butter_cake_slices_6s, false),
        Product(15, "Banana Cake Slice", 45.0, "Cake Slices", R.drawable.banana_cake_slice, false),
        Product(16, "Eggpie Slice", 65.0, "Cake Slices", R.drawable.eggpie_slice, false),

        // Whole Cakes (Dedication ENABLED)
        Product(17, "Luscious Choco 9rd", 645.0, "Whole Cakes", R.drawable.luscious_choco_9rd, true),
        Product(18, "Luscious Choco Petite", 475.0, "Whole Cakes", R.drawable.luscious_choco_petite, true),
        Product(19, "Luscious Gooey Choco 9rd", 645.0, "Whole Cakes", R.drawable.luscious_gooey_choco_9rd, true),
        Product(20, "Classic Choco Balloons 8x12", 735.0, "Whole Cakes", R.drawable.classic_choco_balloons_8x12, true),
        Product(21, "Luscious Chocolate 8x12", 935.0, "Whole Cakes", R.drawable.luscious_chocolate_8x12, true),
        Product(22, "Black Forest", 790.0, "Whole Cakes", R.drawable.black_forest, true),
        Product(23, "Signature Tiramisu", 945.0, "Whole Cakes", R.drawable.signature_tiramisu, true),
        Product(24, "Signature Matcha", 1050.0, "Whole Cakes", R.drawable.signature_matcha, true),
        Product(25, "Signature Chocolate", 945.0, "Whole Cakes", R.drawable.signature_chocolate, true),
        Product(26, "Ube Dream", 790.0, "Whole Cakes", R.drawable.ube_dream, true),
        Product(27, "Classic Sansrival", 935.0, "Whole Cakes", R.drawable.classic_sansrival, true),
        Product(28, "Mango Dream", 790.0, "Whole Cakes", R.drawable.mango_dream, true),
        Product(29, "Choco Cherry Torte", 735.0, "Whole Cakes", R.drawable.choco_cherry_torte, true),
        Product(30, "Black Forest Petite", 525.0, "Whole Cakes", R.drawable.black_forest_petite, true),
        Product(31, "All About Chocolate Petite", 620.0, "Whole Cakes", R.drawable.all_about_chocolate_petite, true),
        Product(32, "Choco Cherry Torte 8x12", 1050.0, "Whole Cakes", R.drawable.choco_cherry_torte_8x12, true),
        Product(33, "Classic Choco Balloons 9rd", 485.0, "Whole Cakes", R.drawable.classic_choco_balloons_9rd, true),
        Product(34, "Luscious Caramel 9rd", 630.0, "Whole Cakes", R.drawable.luscious_caramel_9rd, true),
        Product(35, "Luscious Mocha 9rd", 630.0, "Whole Cakes", R.drawable.luscious_mocha_9rd, true),
        Product(36, "Luscious Mocha 8x12", 930.0, "Whole Cakes", R.drawable.luscious_mocha_8x12, true),
        Product(37, "Luscious Caramel 8x12", 930.0, "Whole Cakes", R.drawable.luscious_caramel_8x12, true),

        // Brownies
        Product(38, "Classic Brownies", 340.0, "Brownies", R.drawable.classic_brownies_box, false),
        Product(39, "Classic Brownies Box", 340.0, "Brownies", R.drawable.classic_brownies_box, false),

        // Polvoron
        Product(40, "Pinipig Polvoron Box", 200.0, "Polvoron", R.drawable.pinipig_polvoron_box, false),
        Product(41, "Cookies n' Cream Polvoron Box", 200.0, "Polvoron", R.drawable.cookies_n_cream_polvoron_box, false),
        Product(42, "Cashew Polvoron Box", 200.0, "Polvoron", R.drawable.cashew_polvoron_box, false),
        Product(43, "Ube Polvoron Box", 200.0, "Polvoron", R.drawable.ube_polvoron_box, false),
        Product(44, "Classic Polvoron Box", 235.0, "Polvoron", R.drawable.classic_polvoron_box, false),
        Product(45, "Premium Polvoron Luxe Choco", 225.0, "Polvoron", R.drawable.premium_polvoron_luxe_choco, false),
        Product(46, "Matcha Polvoron Box", 200.0, "Polvoron", R.drawable.matcha_polvoron_box, false),
        Product(47, "Assorted Polvoron Box", 275.0, "Polvoron", R.drawable.assorted_polvoron_box, false),
        Product(48, "Pinipig Polvoron 10s", 95.0, "Polvoron", R.drawable.pinipig_polvoron_10s, false),
        Product(49, "Ube Polvoron 10s", 95.0, "Polvoron", R.drawable.ube_polvoron_10s, false),
        Product(50, "Cashew Polvoron 10s", 95.0, "Polvoron", R.drawable.cashew_polvoron_10s, false),
        Product(51, "Cookies n' Cream Polvoron 10s", 95.0, "Polvoron", R.drawable.cookies_n_cream_polvoron_10s, false),
        Product(52, "Assorted Polvoron 12s", 105.0, "Polvoron", R.drawable.assorted_polvoron_12s, false),
        Product(53, "Classic Polvoron 10s", 140.0, "Polvoron", R.drawable.classic_polvoron_10s, false),

        // Bread & Pastries
        Product(54, "Sandwich Bread", 105.0, "Bread", R.drawable.sandwich_bread, false),
        Product(55, "Monay", 95.0, "Bread", R.drawable.monay, false),
        Product(56, "Mango Loaf", 95.0, "Bread", R.drawable.mongo_loaf, false),
        Product(57, "Ube Loaf", 95.0, "Bread", R.drawable.ube_loaf, false),
        Product(58, "Pizza Bread Cheeseburger", 55.0, "Bread", R.drawable.pizza_bread_cheeseburger, false),
        Product(59, "Cinnamon Roll", 45.0, "Bread", R.drawable.cinnamon_roll, false),
        Product(60, "Siopao", 115.0, "Bread", R.drawable.siopao, false),
        Product(61, "Cheesy Taisan", 40.0, "Pastries", R.drawable.cheesy_taisan, false),
        Product(62, "Blueberry Muffin", 65.0, "Pastries", R.drawable.blueberry_muffin, false),

        // Ensaymada
        Product(63, "Cheesy Ensaymada Bitbit 6s", 240.0, "Ensaymada", R.drawable.cheesy_ensaymada_bitbit_6s, false),
        Product(64, "Cheesy Ensaymada", 120.0, "Ensaymada", R.drawable.cheesy_ensaymada, false),
        Product(65, "Ube Ensaymada", 50.0, "Ensaymada", R.drawable.ube_ensaymada, false),

        // Hopia
        Product(66, "Mango Hopia", 130.0, "Hopia", R.drawable.mongo_hopia, false),
        Product(67, "Pork Hopia", 130.0, "Hopia", R.drawable.pork_hopia, false),

        // Macaroons
        Product(68, "Butter Macaroons Big", 170.0, "Macaroons", R.drawable.butter_macaroons_big, false),
        Product(69, "Butter Macaroons Small", 95.0, "Macaroons", R.drawable.butter_macaroons_small, false),

        // Cookies & Snacks
        Product(70, "Meringue", 170.0, "Cookies & Snacks", R.drawable.meringue, false),
        Product(71, "Caramel Pop Corn Big", 65.0, "Cookies & Snacks", R.drawable.caramel_pop_corn_big, false),
        Product(72, "Nutty Caramel Pop Corn", 45.0, "Cookies & Snacks", R.drawable.nutty_caramel_pop_corn, false),
        Product(73, "Choco Nibblers", 170.0, "Cookies & Snacks", R.drawable.choco_nibblers, false),
        Product(74, "Raisin Caramel Cookies", 75.0, "Cookies & Snacks", R.drawable.raisin_caramel_cookies, false),
        Product(75, "Chocolate Chip Cookies", 75.0, "Cookies & Snacks", R.drawable.chocolate_chip_cookies, false),

        // Traditional
        Product(76, "Classic Puto", 130.0, "Traditional", R.drawable.classic_puto, false),
        Product(77, "Butter Puto", 130.0, "Traditional", R.drawable.butter_puto, false),
        Product(78, "Ube Cheese Puto", 130.0, "Traditional", R.drawable.ube_cheese_puto, false),

        // Ready-to-Eat
        Product(79, "Pinoy Deli Pouch Laing", 115.0, "Ready-to-Eat", R.drawable.pinoy_deli_pouch_laing, false),
        Product(80, "Pinoy Deli Pouch Dinuguan", 105.0, "Ready-to-Eat", R.drawable.pinoy_deli_pouch_dinuguan, false)
    )

    fun getCategories(): List<String> {
        return allProducts.map { it.category }.distinct().sorted()
    }
}