package ru.gb.zettro.ads.lesson4.LinkIterator;

public class LinkIteratorApp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 23);
        list.display();
        itr.insertAfter("Semen", 34);
        itr.insertAfter("Anton", 33);
        itr.insertBefore("Elisey", 19);
        itr.insertBefore("Yaroslav", 47);
        itr.insertAfter("Boris", 38);
        itr.insertAfter("Dmitry", 42);
        itr.insertBefore("Grigory", 55);
        itr.insertAfter("Nikolay", 43);
        list.display();
        System.out.println("==================");
        // Let's search for "Dmitry", "Anton" and "Ibragim"
        printUserInfo(itr, "Dmitry");
        printUserInfo(itr, "Anton");
        printUserInfo(itr, "Ibragim");
        System.out.println("==================");

        // Locate and remove some users
        deleteUser(itr, "Grigory");
        deleteUser(itr, "Semen");
        deleteUser(itr, "Boris");
        deleteUser(itr, "Grigory");
        System.out.println("==================");

        list.display();
    }

    private static void deleteUser(LinkIterator itr, String username) {
        itr.reset();
        while(true) {
            if (itr.getCurrent().name.equals(username)) {
                itr.deleteCurrent();
                System.out.println(username + " is deleted");
                break;
            }
            if (!itr.atEnd()) {
                itr.nextLink();
            } else {
                System.out.println(username + " is not found");
                break;
            }
        }
    }

    private static void printUserInfo(LinkIterator itr, String username) {
        itr.reset();
        while(true) {
            if (itr.getCurrent().name.equals(username)) {
                System.out.println(username + " is found. His age is " + itr.getCurrent().age);
                break;
            }
            if (!itr.atEnd()) {
                itr.nextLink();
            } else {
                System.out.println(username + " is not found");
                break;
            }
        }
    }

}
