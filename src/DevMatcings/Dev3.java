package DevMatcings;

import java.util.HashMap;

class Person {
    String name;
    Person parent;
    int money;

    public Person(String name, Person parent, int money) {
        this.name = name;
        this.parent = parent;
        this.money = money;
    }

    void getReward(int i) {
        int moneyToParent = (int) (i * 0.1);
        this.money += i - moneyToParent;
        if (this.parent != null)
            this.parent.getReward(moneyToParent);
    }
}

class Dev3 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> personHashMap = new HashMap<>();
        for (String name : enroll)
            personHashMap.put(name, new Person(name, null, 0));

        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-"))
                continue;
            personHashMap.get(enroll[i]).parent = personHashMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++)
            personHashMap.get(seller[i]).getReward(amount[i] * 100);

        int[] result = new int[enroll.length];

        for (int i = 0; i < result.length; i++)
            result[i] = personHashMap.get(enroll[i]).money;

        return result;
    }
}
