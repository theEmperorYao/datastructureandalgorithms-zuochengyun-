package left.base.class04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月30日 21:52:00
 */
class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet {

    public Dog() {
        super("dog");
    }

}

class Cat extends Pet {

    public Cat() {
        super("Cat");
    }
}

class PetWithCount {
    Pet pet;
    int count;

    public PetWithCount(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }
}

class CatDogQueue {

    Queue<PetWithCount> catQueue;
    Queue<PetWithCount> dogQueue;
    int count;

    public CatDogQueue() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
        count = 0;
    }


    public void add(Pet pet) {

        if (pet instanceof Cat) {
            catQueue.add(new PetWithCount(pet, count++));
        } else if (pet instanceof Dog) {
            dogQueue.add(new PetWithCount(pet, count++));
        } else {
            throw new RuntimeException("输入错误，既不是狗也不是猫");
        }
    }


    public Pet pollALL() {

        if (catQueue.isEmpty() && !dogQueue.isEmpty()) {
            pollDog();
        } else if (!catQueue.isEmpty() && dogQueue.isEmpty()) {
            pollCat();
        } else {
            PetWithCount cat = catQueue.peek();
            PetWithCount dog = dogQueue.peek();
            return cat.count < dog.count ? catQueue.poll().pet : dogQueue.poll().pet;
        }
        throw new RuntimeException("猫狗队列都空了");
    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("猫队列为空");
        }
        return (Cat) catQueue.poll().pet;
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("狗队列为空");
        }
        return (Dog) dogQueue.poll().pet;
    }

    public boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public static void main(String[] args) {
        CatDogQueue catDogQueue = new CatDogQueue();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Dog dog4 = new Dog();

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        catDogQueue.add(cat1);
        catDogQueue.add(cat2);
        catDogQueue.add(dog1);
        catDogQueue.add(dog3);
        catDogQueue.add(cat4);
        catDogQueue.add(cat3);
        catDogQueue.add(dog2);
        catDogQueue.add(dog4);

        Pet pet = catDogQueue.pollALL();
        System.out.println("pet = " + pet.getType());

        Cat cat = catDogQueue.pollCat();
        System.out.println("cat = " + cat.getType());

        Dog dog = catDogQueue.pollDog();
        catDogQueue.pollDog();
        catDogQueue.pollDog();
        catDogQueue.pollDog();
        System.out.println("dog = " + dog.getType());

        boolean empty = catDogQueue.isEmpty();
        System.out.println(empty);

        boolean dogEmpty = catDogQueue.isDogEmpty();
        System.out.println("dogEmpty = " + dogEmpty);

        boolean catEmpty = catDogQueue.isCatEmpty();
        System.out.println("catEmpty = " + catEmpty);

    }
}
