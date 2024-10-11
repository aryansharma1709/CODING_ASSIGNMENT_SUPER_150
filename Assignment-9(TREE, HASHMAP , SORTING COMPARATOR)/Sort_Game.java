import java.util.*;
public class Main {
	static class Emp {
        String name;
        int salary;
        public Emp(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return this.name + " " + this.salary;
        }
    }
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        List<Emp> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int salary = sc.nextInt();
            if (salary >= x)
                l.add(new Emp(name, salary));
        }

        Collections.sort(l, new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                if (o1.salary == o2.salary)
                    return o1.name.compareTo(o2.name);
                return o2.salary - o1.salary;
            }
        });

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}