class ArraysConcepts{

    public static void main(String[] args) {
        

        String product1Title = "Apple iPhone 13 (128GB) - Blue";
        String product2Title = "Apple iPhone 15 (128 GB) - Black";
        String product3Title = "Apple iPhone 15 (128 GB) - Blue";
        product1Title = "new title";

        String[] titles = { "Apple iPhone 13 (128GB) - Blue", "Apple iPhone 15 (128 GB) - Black"};
        // 0, 1, 2 -> position numbers -> index
        System.out.println( titles[0] );
        System.out.println( titles[1] );
        System.out.println( titles[2] );

        titles[0] = "Apple iPhone 13 (128GB) - Green";
        System.out.println( titles[0] );

        titles[2] = "Apple iPhone 16 (256 GB) - Blue";
        System.out.println( titles[2] );

        int[] prices = { 999, 1500, 3000, 45000, 25000  };
        // 0, 1, 2, 3, 4 -> index
        System.out.println( prices[2]  );
        System.out.println( prices[4]  );

        prices[3] = 50000;
        System.out.println( prices[3]  );

        System.out.println( prices.length  );
        System.out.println( titles.length );



    }

}