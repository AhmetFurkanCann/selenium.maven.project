package SeleniumExercises_RahulShetty;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Abdijeet");
        names.add("Don");
        names.add("Alekya");
        names.add("Adam");
        names.add("Ram");
        Long c =names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
        long d = Stream.of("Abdijeet","Don","Alekya","Adam","Ram").filter(s ->
        {s.startsWith("A" );
            return true;
        }).count();
        System.out.println(d);
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }
    @Test
    public void streamMap() {
        Stream.of("Abdijeet","Don","Alekya","Adam","Ram").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase(Locale.ROOT)).forEach(s -> System.out.println(s));
        List<String> names = Arrays.asList("Abdijeet","Don","Alekya","Adam","Ram");
        names.stream().filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase()).
                forEach(s -> System.out.println(s));
        //merge 2 lists
        List<String> names1 = Arrays.asList("Ali","Don","Veli","Adam","Ram");
        Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
        newStream.sorted().forEach(s -> System.out.println(s));
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);
    }
    @Test
    public void streamCollect() {
        List<String> ls = Stream.of("Abdijeet","Don","Alekya","Adam","Ram").filter(s -> s.endsWith("a")).
                map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));
        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        values.stream().distinct().forEach(s -> System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }


}
