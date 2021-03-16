package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public void feedAll(){
        for(Dog dogItem : dogs){
            dogItem.feed();
        }
    }

    public Dog findByName(String name) {

        for(Dog dogItem : dogs) {
            if(dogItem.getName().equals(name)){
                return dogItem;
            }
        }

        throw new IllegalArgumentException("No dog with this name.");
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void playWith(String name, int hours) {
        for(Dog dogItem : dogs) {
            if(dogItem.getName().equals(name)){
                dogItem.play(hours);
            }
        }
    }

    public List<String> getHappyDogNames(int minimumHappy) {
        List <String> happyDogs = new ArrayList<>();

        for(Dog dogItem : dogs){
            if(dogItem.getHappiness() > minimumHappy){
                happyDogs.add(dogItem.getName());
            }
        }
        return happyDogs;
    }
}
