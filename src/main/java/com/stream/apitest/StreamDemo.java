package com.stream.apitest;

public class StreamDemo {
//    public static void main(String[] args) {
//        List<Students>list =  new ArrayList(){{
//            add(new Students(1, "a"));
//            add(new Students(2, "b"));
//            add(new Students(3, "c"));
//        }};
//        Students optional = list.stream().filter(f -> f.getId() > 4).findFirst().orElseThrow(RuntimeException::new);
//        System.out.println(optional.getId());
//        List<String> strings = Arrays.asList("1,2,3", "a,b,c", "I,II,III");
//        String collect = strings.stream().map(f -> f.split(",")).flatMap(Arrays::stream).collect(Collectors.joining());
//    }
}

class Students {
    Students(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    Students() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer id;
    private String name;

}


