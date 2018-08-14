package controllers;

import models.Lab5;
import models.Products;
import play.api.templates.Html;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import views.html.helper.form;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {
    public static Products products;

    public static Form<Lab5> lab5Form = Form.form(Lab5.class);
    public static List<Lab5> lab5s = new ArrayList<Lab5>();

    public static Result Showmain(Html Content) {
        return ok(main.render(Content));
    }

    public static Result index() {
        return Showmain(Home.render());
    }

    public static Result Pupat() {
        return Showmain(Pupat.render());
    }

    public static Result Profile() {
        return Showmain(Profile.render());
    }
    public static Result Showproduct(){
        Products guitar = new Products();
        Products drum = new Products();
        Products bass = new Products();
        Products eguitar = new Products();
        Products keyboard = new Products();
        Products mic = new Products();
        
            guitar.setId("001");
            guitar.setName("กีต้าโปร่ง");
            guitar.setBrand("gibson");
            guitar.setModel("J-45 Standard");
            guitar.setPrice(81000);
            guitar.setAmount(100);

            drum.setId("002");
            drum.setName("กลอง");
            drum.setBrand("yamaha");
            drum.setModel("tRydeen Drum Set with Hardware HW680 Set");
            drum.setPrice(23920);
            drum.setAmount(100);

            bass.setId("003");
            bass.setName("เบส");
            bass.setBrand("tSquier");
            bass.setModel("Deluxe Dimension Bass IV");
            bass.setPrice(13050);
            bass.setAmount(100);

            eguitar.setId("004");
            eguitar.setName("กีต้าไฟฟ้า");
            eguitar.setBrand("PRS SE");
            eguitar.setModel("Mark Tremonti Custom");
            eguitar.setPrice(23800);
            eguitar.setAmount(100);

            keyboard.setId("005");
            keyboard.setName("คีย์บอร์ด");
            keyboard.setBrand("Artesia");
            keyboard.setModel("PA-88H 88 Key Weighted Hammer Action Digital Piano");
            keyboard.setPrice(12900);
            keyboard.setAmount(100);

            mic.setId("006");
            mic.setName("ไมค์");
            mic.setBrand("AKG");
            mic.setModel("P4 Microphone");
            mic.setPrice(3750);
            mic.setAmount(100);
        
        return Showmain(Showproduct.render(guitar,drum,bass,eguitar,keyboard,mic));}

    public static Result Input4() {
        return Showmain(Input4.render());
    }
    public static Result music_post(){
        DynamicForm myForm = Form.form().bindFromRequest();
        String name,brand,model;
        double price,amount;

        name = myForm.get("name");
        brand = myForm.get("brand");
        model = myForm.get("model");
        price = Double.parseDouble(myForm.get("price"));
        amount = Double.parseDouble(myForm.get("amount"));


        products = new Products();
        products.setName(name);
        products.setBrand(brand);
        products.setModel(model);
        products.setPrice(price);
        products.setAmount(amount);


        return Showmain(Show4.render(name,brand,model,price,amount));
    }



}