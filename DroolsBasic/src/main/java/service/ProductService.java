package service;

import org.kie.api.runtime.KieSession;

import com.ggk.drools.config.DroolsBeanFactory;

import model.Product;

public class ProductService {

	private KieSession kieSession=new DroolsBeanFactory().getKieSession();

    public Product applyLabelToProduct(Product product){
        kieSession.insert(product);
        kieSession.fireAllRules();
        System.out.println(product.getLabel());
        return  product;

    }
}
