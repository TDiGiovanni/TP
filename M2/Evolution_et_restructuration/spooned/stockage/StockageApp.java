package stockage;


import java.util.function.Function;
import visitors.JavaCleanVisitor;


public class StockageApp {
    public static void main(String[] args) {
        Directory pastis = new Directory("Pastis");
        Directory eau = new Directory("Eau");
        File martini = new File("Martini.class", "Martiniiiiiiiiiiiiiii");
        File ricard = new File("Ricard", "Ricard");
        File glacon = new File("Glacons.class", "Glacooooooooooons");
        pastis.add(eau);
        pastis.add(martini);
        pastis.add(ricard);
        eau.add(glacon);
        /* RazVisitor razV = new RazVisitor();
        System.out.println("Directory " + pastis.getName() + " size before: " + pastis.size());
        pastis.accept(razV);
        System.out.println("Directory " + pastis.getName() + " size after: " + pastis.size());
         */
        /* CountVisitor countV = new CountVisitor();
        pastis.accept(countV);
        System.out.println("Number of files with more than 10 characters in directory " + pastis.getName() + ": " + countV.getCount());
         */
        /* FindVisitor findV = new FindVisitor(ricard.getName());
        pastis.accept(findV);
        System.out.println("All elements named " + ricard.getName() + " in directory " + pastis.getName() + ": " + findV.find());
         */
        // /*
        JavaCleanVisitor javaCleanV = new JavaCleanVisitor(( name) -> name.contains(".class"));
        System.out.println((("Number of elements in directory " + pastis.getName()) + " before: ") + pastis.getCount());
        pastis.accept(javaCleanV);
        System.out.println((("Number of elements in directory " + pastis.getName()) + " after: ") + pastis.getCount());
        // */
    }
}

