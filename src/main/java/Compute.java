import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by damir on 04.03.16.
 */
public class Compute {

    public static void main(String[] args) {
        try(
            Ignite ignite = Ignition.start("c:/work/apache-ignite-fabric-1.5.0.final-bin/examples/config/example-ignite.xml")){


            Collection<Result> results= ignite.compute().apply(
                    (Request request)->{
                        final Result result = new Result();
                        long l =1;
                        for (int i = 0; i < request.getC().length; i++) {
                            l *= request.getC()[i];
                        }

                        result.setResult(l);

                        System.out.println("request = " + request + ", result = " + result);
                        return result;
                    }, Arrays.asList(
                            new Request(2878775L,378712L),
                            new Request(178725L,278717L),
                            new Request(378723L,3247873L),
                            new Request(178745L,6507870L),
                            new Request(767877L,8978787L),
                            new Request(2327873L,347878L),
                            new Request(87878734L,3478734L),
                            new Request(2378732L,6567875L),
                            new Request(34478734L,83478734L),
                            new Request(277875L,317872L),
                            new Request(178778725L,217877L),
                            new Request(323787787L,3243787L),
                            new Request(145787787L,6500787L),
                            new Request(767877877L,8987787L),
                            new Request(2327787873L,348787L),
                            new Request(87877834L,3434787787L),
                            new Request(2337877872L,6565787L),
                            new Request(34437877874L,83434787L)
                            )
            );

            long total=0;
            for (Result result : results) {
                total += result.getResult();
            }
            System.out.println("total = " + total);
        }
    }
}
