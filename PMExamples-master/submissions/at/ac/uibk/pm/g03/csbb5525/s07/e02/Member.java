package at.ac.uibk.pm.g03.csbb5525.s07.e02;


import java.util.Objects;

public class Member implements Comparable<Member>{

    private final String name;
    private final int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //@Override
    //public int compareTo(Member o) {
    //    if(o == null){
    //        throw new NullPointerException();
    //    }
    //    int nameComparison = this.name.compareTo(o.getName());
    //    if (nameComparison != 0){
    //        return nameComparison;
    //    }
    //    return Integer.compare(this.age, o.getAge());
    //
    //}

    @Override
    public int compareTo(Member o) {
        if(o == null){
            throw new NullPointerException();
        }
        int ageComparison = Integer.compare(this.age, o.getAge());
        if (ageComparison != 0){
            return ageComparison;
        }
        return this.name.compareTo(o.getName());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;
        return age == member.age && Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
