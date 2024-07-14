object InventoryManagementSystem {
   
    def getProductList(products:List[String]) : List[String] = {

        val name = scala.io.StdIn.readLine("Enter product name (or type 'done' to finish): ");
        if (name != "done") getProductList(products :+ name);
        else products;
    }

    def printProductList(products:List[String]) : Any = {
        for(x <- products) println((products.indexOf(x) + 1) + ":" + x );
    }

    def getTotalProduct(products:List[String]) : Unit = {
        println(products.length);
    }
}

object Main extends App {

    val emptyList: List[String] = Nil;
    var productList = InventoryManagementSystem .getProductList(emptyList);

    println("Product items are:");
    InventoryManagementSystem .printProductList(productList);

    printf("Length of the inventory: ");
    InventoryManagementSystem .getTotalProduct(productList);
}