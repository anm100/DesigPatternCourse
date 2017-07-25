package controller;

import GUI.AddProductUI;
import Models.Product;

public class productController {

	AddProductUI GUI ;
		
public productController(AddProductUI gUI) {
		super();
		GUI = gUI;
	}



public void  addNewProduct(Product p){
	p.addProduct();
}

}
