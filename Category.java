public class Category{
    Tour_Package new_package;
    Category low , high;
    Category(Tour_Package tour){
        this.new_package = tour;
        this.new_package.same = null;
        low = high = null;
    }
}
